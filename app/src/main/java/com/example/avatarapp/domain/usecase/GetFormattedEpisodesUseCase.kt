package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.repository.EpisodeRepository
import javax.inject.Inject

class GetFormattedEpisodesUseCase @Inject constructor(
    private val repository: EpisodeRepository,
    private val formatter: EpisodeTitleFormatter
) {
    suspend operator fun invoke(): List<String> {
        val episodes = repository.getEpisodes()
        return episodes.map { formatter.format(it) }
    }
}
