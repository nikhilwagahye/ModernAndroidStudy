package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import javax.inject.Inject

class GetEpisodesByDirectorUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(directorName: String): List<Episode> {
        if (directorName.isBlank()) return emptyList()
        return repository.getEpisodes().filter { 
            it.directedBy.contains(directorName, ignoreCase = true) 
        }
    }
}
