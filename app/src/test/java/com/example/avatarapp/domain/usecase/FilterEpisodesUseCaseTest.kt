package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FilterEpisodesUseCaseTest {

    private lateinit var filterEpisodesUseCase: FilterEpisodesUseCase

    private val mockEpisodes = listOf(
        Episode(
            id = 1,
            title = "The Boy in the Iceberg",
            season = "1",
            numInSeason = "1",
            directedBy = "Dave Filoni",
            originalAirDate = "2005-02-21",
            animatedBy = "JM Animation",
            writtenBy = listOf("Michael Dante DiMartino"),
            productionCode = "101",
            viewers = "4.4"
        ),
        Episode(
            id = 2,
            title = "The Avatar Returns",
            season = "2",
            numInSeason = "2",
            directedBy = "Dave Filoni",
            originalAirDate = "2005-02-21",
            animatedBy = "JM Animation",
            writtenBy = listOf("Michael Dante DiMartino"),
            productionCode = "202",
            viewers = "4.4"
        )
    )

    @Before
    fun setUp() {
        filterEpisodesUseCase = FilterEpisodesUseCase()
    }

    @Test
    fun `invoke should return episodes filtered by season`() {
        // When
        val result = filterEpisodesUseCase(mockEpisodes, "1")

        // Then
        assertEquals(1, result.size)
        assertEquals("1", result[0].season)
        assertEquals("The Boy in the Iceberg", result[0].title)
    }

    @Test
    fun `invoke with no matches should return empty list`() {
        // When
        val result = filterEpisodesUseCase(mockEpisodes, "3")

        // Then
        assertEquals(0, result.size)
    }
}
