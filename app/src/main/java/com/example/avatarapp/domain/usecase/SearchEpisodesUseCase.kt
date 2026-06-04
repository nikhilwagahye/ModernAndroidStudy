package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import javax.inject.Inject

class SearchEpisodesUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(query: String): List<Episode> {
        if (query.isBlank()) return emptyList()
        return repository.getEpisodes().filter { 
            it.title.contains(query, ignoreCase = true) 
        }
    }
}
