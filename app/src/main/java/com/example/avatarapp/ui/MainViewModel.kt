package com.example.avatarapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avatarapp.data.model.Episode
import com.example.avatarapp.data.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : ViewModel() {

    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes


    // Track the loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

// commented because i want on button click
//    init {
//        fetchEpisodes()
//    }

    fun fetchEpisodes() {
        viewModelScope.launch {
            _isLoading.value = true // Start loading
            try {
                val result = repository.getEpisodes()
                _episodes.value = result
            } catch (e: Exception) {
                // Handle errors here
            } finally {
                _isLoading.value = false // Stop loading
            }
        }
    }
}
