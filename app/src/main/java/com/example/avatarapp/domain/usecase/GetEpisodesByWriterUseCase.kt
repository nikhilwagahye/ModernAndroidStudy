package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import javax.inject.Inject

class GetEpisodesByWriterUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(writerName: String): List<Episode> {
        if (writerName.isBlank()) return emptyList()
        return repository.getEpisodes().filter { episode ->
            episode.writtenBy.any { it.contains(writerName, ignoreCase = true) }
        }
    }
}
