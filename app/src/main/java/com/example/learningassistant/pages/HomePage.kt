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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learningassistant.BottomBar
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.homePageModels.FeatureCourseGroupModel
import com.example.learningassistant.interfaceClasses.InformativeCourses
import com.example.learningassistant.interfaceResources.ColorsOfButton
import com.example.learningassistant.interfaceResources.UnfilledButton
import com.example.learningassistant.learningPageFragments.learningPageResource.notNotificationColor
import com.example.learningassistant.ui.theme.backgroundColorClassic
import com.example.learningassistant.ui.theme.containerColor
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.fontSizeDetails
import com.example.learningassistant.ui.theme.fontSizeHeader
import com.example.learningassistant.ui.theme.fontSizeMini
import com.example.learningassistant.ui.theme.priceColor
import com.example.learningassistant.viewModels.HomePageViewModel

private val interfaceCreator = InterfaceCreator()
private val suggestedCourseOperator = InformativeCourses()




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

    val viewModel: HomePageViewModel = viewModel()

    val suggestedCourses = viewModel.getSuggestedCourses()
    val topicList = viewModel.getTopicsList()
    val featureCourseList = viewModel.getFeatureCourses()


    PageInterfaceForHomePage(navController = navController, navControllerHost = navControllerHost, pageNumber = 1) {
        Surface (modifier = Modifier
            .padding(0.dp, 100.dp, 0.dp, 70.dp)
            .fillMaxHeight()){
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

                        LazyGridUnfilledButton(topicList)

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


@Composable
fun LazyGridUnfilledButton(topicsList: List<String>){

    val colorsOfButton = ColorsOfButton(notNotificationColor, Color.Black)
    val unfilledButton = UnfilledButton(
        colors = colorsOfButton,
        borderSize = 1,
        height = 30.dp,
        roundedShape = 15.dp,
        padding = 5.dp
        )
    Surface(modifier = Modifier.padding(0.dp, 10.dp), color = Color.Unspecified) {
        LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.Fixed(2),
            horizontalItemSpacing = 4.dp,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            content = {
                items(topicsList.size) {index ->
                    unfilledButton.Show {
                        Text(text = topicsList[index], fontSize = fontSizeMini)
                    }
                }
            }
        )
    }

}

@Composable
fun TopBarHomePage(navController: NavController){
    val topBarCreator = TopBarCreator(navController, 100.dp, Alignment.CenterVertically, Arrangement.SpaceBetween,
        Modifier
            .fillMaxWidth()
            .fillMaxHeight())
    topBarCreator.TopBarClassic(
        imageId = R.drawable.ic_launcher_background,
        imageWidth = 85,//65
        imageHeight = 90,
        title = "Amin Azizzade",
        iconSize = 40,
        iconId = R.drawable.entering_way_icon
    )

}