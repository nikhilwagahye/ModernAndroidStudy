package com.example.avatarapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.avatarapp.data.model.Episode
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class EpisodeListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun welcomeText_isVisible() {
        composeTestRule.setContent {
            EpisodeListContent(
                episodes = emptyList(),
                isLoading = false,
                onFetchEpisodes = {}
            )
        }

        composeTestRule.onNodeWithText("Welcome to Jetpack Compose!")
            .assertIsDisplayed()
    }

    @Test
    fun buttonClick_triggersFetchEpisodes() {
        var clicked = false
        val onFetchAction = { clicked = true }

        composeTestRule.setContent {
            EpisodeListContent(
                episodes = emptyList(),
                isLoading = false,
                onFetchEpisodes = onFetchAction
            )
        }

        composeTestRule.onNodeWithText("Show Toast")
            .performClick()

        assert(clicked)
    }

    @Test
    fun listDisplaysItems_whenEpisodesProvided() {
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

        composeTestRule.setContent {
            EpisodeListContent(
                episodes = mockEpisodes,
                isLoading = false,
                onFetchEpisodes = {}
            )
        }

        composeTestRule.onNodeWithText("S1E1: The Boy in the Iceberg", substring = true)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("S1E2: The Avatar Returns", substring = true)
            .assertIsDisplayed()
        
        composeTestRule.onAllNodesWithText("Directed by: Dave Filoni")
            .assertCountEquals(2)
    }

    @Test
    fun loadingIndicator_isVisible_whenLoading() {
        composeTestRule.setContent {
            EpisodeListContent(
                episodes = emptyList(),
                isLoading = true,
                onFetchEpisodes = {}
            )
        }

        composeTestRule.onNodeWithText("Show Toast")
            .assertIsNotEnabled()
    }
}
