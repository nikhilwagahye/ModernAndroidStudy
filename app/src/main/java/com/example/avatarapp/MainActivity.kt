package com.example.avatarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avatarapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.jvm.java

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // "Hey Hilt, please inject a Car into this variable right after the Activity is created."
    @Inject
    lateinit var object2: Car // <-- HILT INJECTS THIS AUTOMATICALLY!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    EpisodeListScreen()
                }
            }
        }
        object2.drive(); // <-- HILT INJECTS THIS AUTOMATICALLY!
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeListScreen(viewModel: MainViewModel = hiltViewModel()) {
    val episodes by viewModel.episodes.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
   //  val episodes by viewModel.episodes.collectAsState();

    EpisodeListContent(
        episodes = episodes,
        isLoading = isLoading,
        onFetchEpisodes = { viewModel.fetchEpisodes() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeListContent(
    episodes: List<com.example.avatarapp.data.model.Episode>,
    isLoading: Boolean,
    onFetchEpisodes: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home Page")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        val context = LocalContext.current

        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Welcome to Jetpack Compose!",
                fontSize = 15.sp)

            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Button was clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                    onFetchEpisodes()
                    //viewModel.fetchEpisodes();
                },
                enabled = !isLoading
            ) {
                Text("Show Toast")
            }

            Button(
                onClick = {
                    // 2. Initialize the Intent targeting your second activity
                    val intent = Intent(context, SecondActivity::class.java).apply {
                        putExtra("USER_NAME_KEY", "Nikhil")
                        putExtra("USER_AGE_KEY", 36)
                    }
                    // 3. Launch the target activity
                    context.startActivity(intent)
                },
            ) {
                Text("Nav to next")
            }


            if (isLoading) {
                CenteredProgressIndicator()
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(episodes) { episode ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "S${episode.season}E${episode.numInSeason}: ${
                                    episode.title.replace("'", "")
                                }",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Directed by: ${episode.directedBy}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Aired: ${episode.originalAirDate}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CenteredProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(), // Fills the entire screen
        contentAlignment = Alignment.Center // Centers everything inside it
    ) {
        CircularProgressIndicator()
    }
}
// Study

// Stateful Composable (NOT hoisted - manages its own state)
@Composable
fun callWithState() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count++ }) {
        Text(text = "Count is $count");
    }
}

// Stateless Composable (Hoisted - state is managed by caller)
@Composable
fun callWithoutState(count: Int, onCountChanged: () -> Unit) {
    Button(onClick = onCountChanged ) {
        Text(text = "Count is $count");
    }
}

// Caller
@Composable
fun caller () {
    var count by remember { mutableStateOf(0) }
    callWithoutState(
        count = count,
        onCountChanged = { count++ }
    )
}


// some examples
// "Hey Hilt, if anyone asks for an Engine, this is how you build it!"
class Engine @Inject constructor() {

    fun start() {
        println("Engine started!")
    }
}

// "Hey Hilt, when you build this Car, please inject an Engine into it for me."
// private val engine: Engine <-- HILT INJECTS THIS AUTOMATICALLY!)
class Car @Inject constructor(private val engine: Engine) {
    fun drive() {
        println(engine.start())
    }
}


class ClassName @Inject constructor() {

    fun run () {
        println("Hello World!")
    }
    val run2 = { println("Hello World! 2") }

}

class UseHere @Inject constructor(private val className : ClassName) {
    // val className2 = ClassName(); No need to write, injected in constructor of class
    fun useHere() {
        className.run()
        className.run2();
    }
}

