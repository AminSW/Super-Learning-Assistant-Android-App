package com.example.learningassistant.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningassistant.learningPageFragments.learningPageResource.mainColor
import com.example.learningassistant.ui.theme.LearningAssistantTheme
import com.example.learningassistant.ui.theme.backgroundColorClassic
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.sillyGray
import com.example.learningassistant.ui.theme.textUnitScheme


@Composable
fun CoursePage()
{
    Surface(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxSize(),
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
        )
        {
            VideoScreen()
            DetailScreen()
        }

    }
}

@Composable
fun VideoScreen()
{
    Surface(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.24f),
        color = Color.Black
    )
    {

    }
}

@Composable
fun DetailScreen()
{
    val tabItems = listOf(
        TabItem(
            title = "Lesson"
        ),
        TabItem(
            title = "More"
        )
    )

    Surface(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color.Yellow
    )
    {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Surface(
                modifier = Modifier
                    .fillMaxHeight(0.125f)
            )
            {
                VideoTitle(title = "Video Title")
            }

            Surface(
                modifier = Modifier
                    .fillMaxHeight(0.1527f)
            )
            {
                CircleProgressBar(totalTask = 349273123, completedTask = 231311222)
            }

            Surface()
            {
                SwipeableTabRow(tabItemList = tabItems)
            }

        }
    }
}

@Composable
fun VideoTitle(title: String)
{
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = backgroundColorClassic,
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = title,
                fontSize = MaterialTheme.textUnitScheme.fontSizeMainHeader
            )
        }
    }
}


@Composable
fun CircleProgressBar(totalTask: Int, completedTask: Int)
{
    val progress = calculateProgress(totalTask, completedTask)

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        onClick = { /*TODO*/ },
        color = backgroundColorClassic
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(),
            )
            {
                MotivationalText(completedTask = completedTask, totalTask = totalTask)
            }

            Surface(
                modifier = Modifier
                    .background(backgroundColorClassic)
                    .fillMaxSize()
            )
            {
                ProgressBarWithPercentage(progress = progress*100)
                {
                    CircularProgressIndicator(
                        progress =
                        {
                            progress
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColorClassic),
                        color = mainColor,
                        strokeWidth = 8.dp,
                        strokeCap = StrokeCap.Round,
                        trackColor = sillyGray
                    )
                }
            }
        }
    }
}

@Composable
fun SwipeableTabRow(tabItemList : List<TabItem>)
{

    LocalContentColor.provides(mainColor)

    var selectedTab by remember{
        mutableIntStateOf(0)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
    )
    {

        TabRow(
            selectedTabIndex = selectedTab,
        )
        {
            tabItemList.forEachIndexed { index, tabItem ->
                Tab(
                    selected = selectedTab == index,
                    onClick =
                    {
                        selectedTab = index
                    },
                    text =
                    {
                        Text(text = tabItem.title, color = mainColor)
                    },
                )

            }

        }


        ChangeScreen(screen = selectedTab)
    }
}

fun calculateProgress(totalTask: Int, completedTask: Int): Float
{
    val progress : Float = completedTask.toFloat()/totalTask
    return progress
}

@Composable
fun ProgressBarWithPercentage(progress : Float, progressBar: @Composable () -> Unit)
{
    val roundedProgress = String.format("%.1f", progress)
    Card(
        modifier = Modifier.fillMaxSize()
    )
    {
        Box(
            modifier = Modifier.fillMaxSize()
        )
        {
            progressBar()

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "$roundedProgress %", color = mainColor, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
fun ChangeScreen(screen: Int)
{
    if (screen == 0)
    {
        Text(text = "Screen 0")
    }
    else {
        Text(text = "Screen 1")
    }
}



@Composable
fun ShowFraction(completedTask: Int, totalTask: Int)
{
    Row ()
    {

        Text(
            text = "$completedTask",
            fontSize = MaterialTheme.textUnitScheme.fontSizeDetails,
            fontWeight = FontWeight.SemiBold,
            color = detailColor
        )

        Text(
            text = "/$totalTask",
            fontSize = MaterialTheme.textUnitScheme.fontSizeDetails,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp))

    }
}

@Composable
fun MotivationalText(completedTask: Int, totalTask: Int)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Text(text = "Great Work")

        ShowFraction(completedTask = completedTask, totalTask = totalTask)

    }
}



data class TabItem(
    val title: String
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview()
{
    LearningAssistantTheme()
    {
        CoursePage()
    }
}

