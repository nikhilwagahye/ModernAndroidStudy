package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import javax.inject.Inject

class GetEpisodesBySeasonUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(season: String): List<Episode> {
        return repository.getEpisodes().filter { it.season == season }
    }
}
