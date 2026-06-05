package com.example.avatarapp.di

import okhttp3.Interceptor
import okhttp3.Response

//class AuthInterceptor(private val sessionManager: SessionManager) : Interceptor {
class AuthInterceptor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // 1. Get the token from your storage
        // val token = sessionManager.getAuthToken()
        val token = "ABCD";

        // 2. Check if the token is null or empty
        if (token.isNullOrBlank()) {
            // If there is no token, just proceed with the original request
            // without adding the Authorization header.
            return chain.proceed(originalRequest)
        }

        // 3. If the token exists, create a new request and attach the header
        val authenticatedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        // Proceed with the authenticated request
        return chain.proceed(authenticatedRequest)
    }
}