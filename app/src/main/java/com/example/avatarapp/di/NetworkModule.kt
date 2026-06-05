package com.example.avatarapp.di

import com.example.avatarapp.data.api.ApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi.Builder().build()

        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            .client(provideOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

private fun provideOkHttpClient(): OkHttpClient {
    // Logging Interceptor to print requests/responses to Logcat
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder()
        // Auth Interceptor: Automatically attach a Bearer Token to all requests
//            .addInterceptor { chain ->
//                val originalRequest = chain.request()
//                val authenticatedRequest = originalRequest.newBuilder()
//                    .header("Authorization", "Bearer YOUR_ACCESS_TOKEN")
//                    .build()
//                chain.proceed(authenticatedRequest)
//            }
        .addInterceptor(AuthInterceptor())
        .addInterceptor(loggingInterceptor)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

/*

package com.example.avatarapp.di

import com.example.avatarapp.data.api.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        //ktx serialization
//        val contentType = "application/json".toMediaType()
//        val kotlinxConverterFactory = Json { ignoreUnknownKeys = true }
     // Moshi
        val moshi = Moshi.Builder()
            .build()


        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            //.addConverterFactory(GsonConverterFactory.create()) // With GSON
           // .addConverterFactory(kotlinxConverterFactory.asConverterFactory(contentType)) // With kotlinxConverterFactory - Kotlinx Serialization
            .addConverterFactory(MoshiConverterFactory.create(moshi))

            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}


 */
