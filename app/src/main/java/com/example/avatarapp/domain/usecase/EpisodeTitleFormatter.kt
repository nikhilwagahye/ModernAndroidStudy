package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import javax.inject.Inject

class EpisodeTitleFormatter @Inject constructor() {
    fun format(episode: Episode): String {
        return "S${episode.season}E${episode.numInSeason}: ${episode.title.replace("'", "")}"
    }
}
