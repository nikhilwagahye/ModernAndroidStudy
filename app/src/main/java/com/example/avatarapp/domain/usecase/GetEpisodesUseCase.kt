package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(): List<Episode> {
        return repository.getEpisodes()
    }
}
