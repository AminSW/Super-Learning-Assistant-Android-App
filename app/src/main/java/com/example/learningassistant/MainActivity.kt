package com.example.learningassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningassistant.data.remote.PostsService
import com.example.learningassistant.data.remote.dto.PostResponse
import com.example.learningassistant.navigations.MainNav
import com.example.learningassistant.ui.theme.LearningAssistantTheme

class MainActivity : ComponentActivity()
{
    private val service = PostsService.create()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer =
                {
                    value = service.getPosts()
                }
            )




            println("Size: ${posts.value.size}")
            LearningAssistantTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    LazyColumn()
                    {
                        items(posts.value)
                        { item ->
                            println("Amin ${item.title}")
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                            {
                                Text(text = item.title, fontSize = 20.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = item.body, fontSize = 14.sp)
                            }
                        }
                    }
                }
//
//                    //Player()
//                    //VideoPlayer()
////                    MainNav()
////                    val videoUri =
////                         Uri.parse("android.resource://com.mkrdeveloper.videoplayercompose/raw/sample")
////                    val videoUrl =
////                        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
////
////                    Column {
////                        YouTubePlayer(
////                            youtubeVideoId = "oMfuX_bhrDw",
////                            lifecycleOwner = LocalLifecycleOwner.current
////                        )
////                        Spacer(modifier = Modifier.height(16.dp))
////                        VideoPlayer(videoUri = videoUri)
//                        //VideoPlayerExo(videoUrl =videoUrl)
//
//                }

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