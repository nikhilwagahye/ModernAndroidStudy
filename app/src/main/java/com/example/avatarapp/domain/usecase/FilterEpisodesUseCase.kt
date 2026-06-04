package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import javax.inject.Inject

class FilterEpisodesUseCase @Inject constructor() {
    operator fun invoke(episodes: List<Episode>, season: String): List<Episode> {
        return episodes.filter { it.season == season }
    }
}
