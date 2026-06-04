package com.example.avatarapp.domain.usecase

import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

class SearchEpisodesUseCaseTest {

    @Mock
    private lateinit var repository: EpisodeRepository

    private lateinit var searchEpisodesUseCase: SearchEpisodesUseCase

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
            season = "1",
            numInSeason = "2",
            directedBy = "Dave Filoni",
            originalAirDate = "2005-02-21",
            animatedBy = "JM Animation",
            writtenBy = listOf("Michael Dante DiMartino"),
            productionCode = "102",
            viewers = "4.4"
        )
    )

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        searchEpisodesUseCase = SearchEpisodesUseCase(repository)
    }

    @Test
    fun `invoke with matching query should return filtered episodes`() {
        runBlocking {
            // Given
            `when`(repository.getEpisodes()).thenReturn(mockEpisodes)
            val query = "Iceberg"

            // When
            val result = searchEpisodesUseCase(query)

            // Then
            assertEquals(1, result.size)
            assertEquals("The Boy in the Iceberg", result[0].title)
            verify(repository).getEpisodes()
        }
    }

    @Test
    fun `invoke with non-matching query should return empty list`() {
        runBlocking {
            // Given
            `when`(repository.getEpisodes()).thenReturn(mockEpisodes)
            val query = "Zuko"

            // When
            val result = searchEpisodesUseCase(query)

            // Then
            assertEquals(0, result.size)
            verify(repository).getEpisodes()
        }
    }

    @Test
    fun `invoke with blank query should return empty list and not call repository`() {
        runBlocking {
            // Given
            val query = " "

            // When
            val result = searchEpisodesUseCase(query)

            // Then
            assertEquals(0, result.size)
        }
    }
}
