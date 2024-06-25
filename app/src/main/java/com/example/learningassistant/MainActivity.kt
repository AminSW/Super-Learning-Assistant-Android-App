package com.example.learningassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningassistant.navigations.MainNav
import com.example.learningassistant.ui.theme.LearningAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningAssistantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {

                    //Player()
                    //VideoPlayer()
                    MainNav()
//                    val videoUri =
//                         Uri.parse("android.resource://com.mkrdeveloper.videoplayercompose/raw/sample")
//                    val videoUrl =
//                        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
//
//                    Column {
//                        YouTubePlayer(
//                            youtubeVideoId = "oMfuX_bhrDw",
//                            lifecycleOwner = LocalLifecycleOwner.current
//                        )
//                        Spacer(modifier = Modifier.height(16.dp))
//                        VideoPlayer(videoUri = videoUri)
                        //VideoPlayerExo(videoUrl =videoUrl)

                }

            }

        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningAssistantTheme {
        MainNav()
    }
}