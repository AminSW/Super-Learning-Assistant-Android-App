package com.example.learningassistant.interfaceClasses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.learningPageFragments.learningPageResource.TextIconHorizontal
import com.example.learningassistant.learningPageFragments.learningPageResource.mainColor
import com.example.learningassistant.pages.TopicText
import com.example.learningassistant.pages.UnfilledButton
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.fontSizeDetails
import com.example.learningassistant.ui.theme.fontSizeHeader
import com.example.learningassistant.ui.theme.priceColor
import com.example.learningassistant.ui.theme.specialIconColor

class InformativeCourses {

    @Composable
    fun InformativeCourseHolderRow(backgroundColor: Color, height: Int, heightToPhone: Float,
                                   upSpacerPadding: Int, bottomSpacerPadding: Int,
                                   topicTextPadding: Int,
                                   suggestedCourseList: List<InformativeCourseGroupModel>,
                                   objectHeight: Dp){
        Surface(color = backgroundColor, modifier = Modifier
            .height((height+upSpacerPadding+bottomSpacerPadding).dp)
            .fillMaxHeight(heightToPhone)
        ) {
            Column(verticalArrangement = Arrangement.SpaceAround) {

                Spacer(modifier = Modifier.padding(upSpacerPadding.dp))
                TopicText(text = "Suggested Courses", topicTextPadding)

                LazyRow {
                    items(suggestedCourseList.size){index ->

                        InformativeCourseObject(model = suggestedCourseList[index], objectHeight)

                    }
                }
                Spacer(modifier = Modifier.padding(bottomSpacerPadding.dp))
            }
        }
    }
    @Composable
    fun InformativeCourseHolderColumn(backgroundColor: Color, with: Int,
                                   upSpacerPadding: Int, bottomSpacerPadding: Int,
                                   suggestedCourseList: List<InformativeCourseGroupModel>,
                                      objectHeight: Dp){
        Surface(color = backgroundColor, modifier = Modifier
            .width((with + upSpacerPadding + bottomSpacerPadding).dp)
            .fillMaxHeight()) {
            Column {
                Spacer(modifier = Modifier.padding(upSpacerPadding.dp))
                LazyColumn {
                    items(suggestedCourseList.size) { index ->

                        InformativeCourseObject(model = suggestedCourseList[index], objectHeight)

                    }
                }
                Spacer(modifier = Modifier.padding(bottomSpacerPadding.dp))
            }


        }
    }

    @Composable
    private fun InformativeCourseObject(model: InformativeCourseGroupModel, surfaseHeight: Dp){
        val content: String = model.content
        val lessons: Int = model.lessons
        val hours: Int = model.hours
        val minutes:Int = model.minutes
        val price: Int = model.price

        Surface(
            modifier = Modifier
                .width(420.dp)
                .fillMaxWidth(0.5f)
                .padding(10.dp, 10.dp, 10.dp, 10.dp),
            shape = RoundedCornerShape(20.dp),
            shadowElevation = 1.dp
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                CourseImage(image = R.drawable.ic_launcher_background)

                Surface(modifier = Modifier.height(160.dp)) {
                    Column(verticalArrangement = Arrangement.SpaceAround)
                    {

                        CourseMainText(content = content)

                        CourseLessonAndHours(lessons = lessons, hours = hours, minutes = minutes)

                        CoursePriceAndEnroll(price = price)

                    }
                }
            }
        }
    }



}


@Composable
fun CourseImage(image : Int){
    Surface(modifier = Modifier
        .padding(15.dp)
        .size(130.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(painter = painterResource(id = image),
            contentDescription = null)
    }
}

@Composable
fun CourseTextIcon(icon: Int, iconColor: Color, text: String){
    val width = (text.length * 9) + 35
    TextIconHorizontal(
        width = width,
        height = 20,
        padding = 0,
        address = icon,
        iconColor = iconColor,
        backgroundColor = Color.Unspecified,
        navController = null,
        nextPage = "",
        title = text,
        fontSize = fontSizeDetails.value.toInt(),
        fontWeight = FontWeight.W600,
        color = detailColor
    )
}

@Composable
fun CourseMainText(content: String){
    Text(text = content,
        fontSize = fontSizeHeader,
        fontWeight = FontWeight.W700,
        modifier = Modifier.padding(10.dp, 5.dp))
}

@Composable
fun CourseLessonAndHours(lessons: Int, hours: Int, minutes: Int){
    Surface(modifier = Modifier
        .width(260.dp)
        .padding(0.dp, 0.dp, 0.dp, 0.dp),
        color = Color.Unspecified) {
        Row (horizontalArrangement = Arrangement.Absolute.Left){
            CourseTextIcon(icon = R.drawable.book, iconColor = mainColor, text ="$lessons Lesson")
            CourseTextIcon(icon = R.drawable.clock, iconColor = specialIconColor, text = "${hours}h $minutes min")
        }
    }
}

@Composable
private fun CoursePriceAndEnroll(price: Int){
    Surface(modifier = Modifier
        .width(230.dp)
        .padding(10.dp, 0.dp, 10.dp, 0.dp),
        color = Color.Unspecified) {
        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(text = "$$price", color = priceColor, fontSize = fontSizeDetails, fontWeight = FontWeight.W700)
            UnfilledButton(borderColor = mainColor, 3, context = "Enroll Now", mainColor, 30.dp, 15.dp, 0)
        }
    }
}