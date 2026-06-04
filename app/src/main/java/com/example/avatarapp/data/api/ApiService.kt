package com.example.avatarapp.data.api

import com.example.avatarapp.data.model.Episode
import retrofit2.http.GET

interface ApiService {
    @GET("avatar/episodes")
    suspend fun getEpisodes(): List<Episode>
}
