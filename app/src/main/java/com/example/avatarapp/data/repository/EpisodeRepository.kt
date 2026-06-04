package com.example.avatarapp.data.repository

import com.example.avatarapp.data.api.ApiService
import com.example.avatarapp.data.model.Episode
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getEpisodes(): List<Episode> {
        return apiService.getEpisodes()
    }
}
