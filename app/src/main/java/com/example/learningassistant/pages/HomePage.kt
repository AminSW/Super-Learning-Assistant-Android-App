@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.learningassistant.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learningassistant.BottomBar
import com.example.learningassistant.interfaceClasses.InformativeCourses
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.homePageModels.FeatureCourseGroupModel
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.learningPageFragments.learningPageResource.notNotificationColor
import com.example.learningassistant.ui.theme.backgroundColorClassic
import com.example.learningassistant.ui.theme.containerColor
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.fontSizeDetails
import com.example.learningassistant.ui.theme.fontSizeHeader
import com.example.learningassistant.ui.theme.priceColor

private val suggestedCourses = ArrayList<InformativeCourseGroupModel>()
private val suggestedCourseOperator = InformativeCourses()

private val topicsList = ArrayList<String>()
private val featureCourseList = ArrayList<FeatureCourseGroupModel>()
private val interfaceCreator = InterfaceCreator()


@Composable
fun PageInterfaceForHomePage(navController: NavController, navControllerHost: NavController,
                             pageNumber: Int, operation: @Composable () -> Unit
){

    interfaceCreator.MainInterface(navControllerHost = navControllerHost, pageNumber = pageNumber,
        bottomBar = { BottomBar(navController = navControllerHost, page = pageNumber) },
        topBar = { TopBarHomePage(navController = navController) })
    {
        operation()
    }
}

@Composable
fun HomePage(navController: NavController, navControllerHost: NavController){
    getInformativeCourses()
    getTopicsButton()
    getFeatureCourses()
    PageInterfaceForHomePage(navController = navController, navControllerHost = navControllerHost, pageNumber = 1) {
        Surface (modifier = Modifier.padding(0.dp, 100.dp, 0.dp, 70.dp).fillMaxHeight()){
            Column(verticalArrangement = Arrangement.Top) {

                suggestedCourseOperator.InformativeCourseHolderRow(
                    backgroundColor = backgroundColorClassic,
                    height = 220,
                    heightToPhone = 0.22f,
                    upSpacerPadding = 0,
                    bottomSpacerPadding = 20,
                    topicTextPadding = 10,
                    suggestedCourseList = suggestedCourses,
                    objectHeight = 120.dp)

                Surface(color = backgroundColorClassic, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35f)
                    .height(170.dp)) {
                    Column(verticalArrangement = Arrangement.SpaceBetween){

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {

                            TopicText(text = "Topics", padding = 10)
                            DetailText(text = "See All", padding = 10)

                        }

                        LazyGridUnfilledButton()

                    }
                }

                Surface (
                    color = backgroundColorClassic, modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                ){


                    Column(verticalArrangement = Arrangement.SpaceEvenly) {
                        Surface(color = backgroundColorClassic, modifier = Modifier.fillMaxWidth()) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween){
                                TopicText(text = "Featured Courses", 10)
                                DetailText(text = "See All", padding = 10)
                            }
                        }

                        LazyRow{
                            items(featureCourseList.size){index ->
                                FeatureCourseRow(featureCourseList[index])
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureCourseRow(model: FeatureCourseGroupModel){
    Surface(modifier = Modifier
        .width(270.dp)
        .padding(10.dp, 0.dp, 10.dp, 0.dp),
        color = containerColor,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 1.dp){

            Column() {
                Surface(modifier = Modifier.padding(5.dp),
                    shape = RoundedCornerShape(15.dp)){
                    Image(painter = painterResource(model.image), contentDescription = null)
                }
                Surface(modifier = Modifier
                    .padding(10.dp)
                    .height(60.dp)
                    .fillMaxWidth()){
                    Column (horizontalAlignment = Alignment.Start,verticalArrangement = Arrangement.SpaceBetween){

                        Surface(modifier = Modifier.width(160.dp), color = Color.Unspecified) {
                            Row {
                                Text(text = model.title, fontSize = fontSizeHeader, fontWeight = FontWeight.W700)
                            }
                        }


                        Surface(modifier = Modifier.fillMaxWidth(), color = Color.Unspecified) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(text = "$${model.price}", fontSize = fontSizeDetails, fontWeight = FontWeight.W800, color = priceColor)
                                Text(text = "${model.rating} (${model.ratingCount})", fontSize = fontSizeDetails, fontWeight = FontWeight.W800, color = detailColor)
                            }
                        }

                    }
                }
            }

    }
}


@Preview(showBackground = true)
@Composable
fun LazyGridUnfilledButton(){
    Surface(modifier = Modifier.padding(0.dp, 10.dp), color = Color.Unspecified) {
        LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.Fixed(2),
            horizontalItemSpacing = 4.dp,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            content = {
                items(topicsList.size) {index ->
                    UnfilledButton(borderColor = notNotificationColor, 1, context = topicsList[index], Color.Black, 30.dp, 15.dp, 5)
                }
            }
        )
    }

}

@Composable
fun TopBarHomePage(navController: NavController){
    val topBarCreator = TopBarCreator(navController, 100.dp, Alignment.CenterVertically, Arrangement.SpaceBetween, Modifier.fillMaxWidth().fillMaxHeight())
    topBarCreator.TopBarClassic(
        imageId = R.drawable.ic_launcher_background,
        imageWidth = 85,//65
        imageHeight = 90,
        title = "Amin Azizzade",
        iconSize = 40,
        iconId = R.drawable.entering_way_icon
    )

}

fun getTopicsButton(){
    val topics = listOf(
        "AI & Future",
        "Climate Change",
        "Digital Marketing",
        "Renewable Energy",
        "VR & AR",
        "Post-Pandemic Education",
        "Blockchain & Crypto",
        "Space Exploration",
        "Digital Health",
        "Global Economy",
        "Innovation & Entrepreneurship",
        "Cultural Diversity",
        "Robotics & Automation",
        "Biotech & Genetic Engineering",
        "Digital Art",
        "Next-Gen Transportation",
        "Data Privacy & Cybersecurity",
        "Structured Finance & DeFi",
        "AI Ethics",
        "Future Business Models"
    )
    topics.forEachIndexed { _, topic ->
        topicsList.add(topic)
    }
}

fun getFeatureCourses(){
    val featureCourse1 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 1", liked = false, price = 100, rating = 4.7F, ratingCount = 130)
    val featureCourse2 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 2", liked = true, price = 120, rating = 4.3F, ratingCount = 571)
    val featureCourse3 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 3", liked = false, price = 80, rating = 4.1F, ratingCount = 239)
    val featureCourse4 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 4", liked = false, price = 700, rating = 5.0F, ratingCount = 982)
    val featureCourse5 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 5", liked = true, price = 102, rating = 4.1F, ratingCount = 101)
    val featureCourse6 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 6", liked = true, price = 10, rating = 3.2F, ratingCount = 1678)
    featureCourseList.add(featureCourse1)
    featureCourseList.add(featureCourse2)
    featureCourseList.add(featureCourse3)
    featureCourseList.add(featureCourse4)
    featureCourseList.add(featureCourse5)
    featureCourseList.add(featureCourse6)
}


fun getInformativeCourses(){
    val sCourses =  InformativeCourseGroupModel(content = "Global Business Trends and Markets", lessons = 5, hours = 12, minutes = 12, price = 700)
    val sCourses2 = InformativeCourseGroupModel(content = "Example 2", lessons = 1, hours = 1, minutes = 40, price = 200)
    val sCourses3 = InformativeCourseGroupModel(content = "Example 3", lessons = 3, hours = 2, minutes = 30, price = 250)
    val sCourses4 = InformativeCourseGroupModel(content = "Example 4", lessons = 7, hours = 10, minutes = 20, price = 600)
    val sCourses5 = InformativeCourseGroupModel(content = "Example 5", lessons = 12, hours = 11, minutes = 10, price = 900)
    suggestedCourses.add(sCourses)
    suggestedCourses.add(sCourses2)
    suggestedCourses.add(sCourses3)
    suggestedCourses.add(sCourses4)
    suggestedCourses.add(sCourses5)
}

