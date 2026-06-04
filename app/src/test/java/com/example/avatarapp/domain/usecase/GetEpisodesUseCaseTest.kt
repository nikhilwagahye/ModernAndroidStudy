package com.example.avatarapp.domain.usecase

import android.util.Log
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

class GetEpisodesUseCaseTest {

    @Mock
    private lateinit var repository: EpisodeRepository

    private lateinit var getEpisodesUseCase: GetEpisodesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getEpisodesUseCase = GetEpisodesUseCase(repository)
    }

    @Test
    fun `invoke should return episodes from repository`() {
        runBlocking {
            // Given
            val mockEpisodes = listOf(
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
                )
            )
            `when`(repository.getEpisodes()).thenReturn(mockEpisodes)

            // When
            val result = getEpisodesUseCase()

            // Then
            assertEquals(mockEpisodes, result)
            verify(repository).getEpisodes()
        }
    }
}
