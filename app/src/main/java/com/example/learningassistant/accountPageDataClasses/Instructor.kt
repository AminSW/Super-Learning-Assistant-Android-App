package com.example.learningassistant.accountPageDataClasses

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.interfaceClasses.CourseImage
import com.example.learningassistant.interfaceClasses.CourseLessonAndHours
import com.example.learningassistant.interfaceClasses.CourseMainText
import com.example.learningassistant.learningPageFragments.learningPageResource.mainColor
import com.example.learningassistant.pages.FilledButton
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.fontSizeDetails
import com.example.learningassistant.ui.theme.fontSizeHeader
import com.example.learningassistant.ui.theme.fontSizeHuge
import com.example.learningassistant.ui.theme.fontSizeMini
import com.example.learningassistant.ui.theme.fontSizeTopic
import com.example.learningassistant.ui.theme.priceColor
import com.example.learningassistant.ui.theme.fontSizeMainHeader

class Instructor(
    private val name: String,
    private val miniBio: LimitedString,
    private val courses: Int,
    private val totalStudent: Int,
    private val review: Int,
    private val aboutInstructor: LimitedString,
    private val popularCourses: List<InformativeCourseGroupModel>
) {
    @Composable
    fun ShowThePage() {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Text(text = name, fontSize = fontSizeMainHeader, fontWeight = FontWeight.W700)
            miniBio.ShowText()
            
            Spacer(modifier = Modifier.padding(12.dp))
            
            Surface(modifier = Modifier.fillMaxWidth())
            {
                Row(horizontalArrangement = Arrangement.SpaceEvenly)
                {
                    NumberAndInfo(
                        number = courses,
                        sizeNum = fontSizeMainHeader,
                        fontWeightNum = FontWeight.W700,

                        info = "Courses",
                        sizeInfo = fontSizeDetails,

                        height = 50.dp
                    )
                    NumberAndInfo(
                        number = totalStudent,
                        sizeNum = fontSizeMainHeader,
                        fontWeightNum = FontWeight.W700,

                        info = "Total Student",
                        sizeInfo = fontSizeDetails,

                        height = 50.dp
                    )
                    NumberAndInfo(
                        number = review,
                        sizeNum = fontSizeMainHeader,
                        fontWeightNum = FontWeight.W700,

                        info = "Review",
                        sizeInfo = fontSizeDetails,

                        height = 100.dp
                    )
                }
            }

            Surface(Modifier.fillMaxWidth())
            {
                Column(verticalArrangement = Arrangement.SpaceBetween)
                {
                    Text(text = "About Instructor", fontSize = fontSizeHuge, fontWeight = FontWeight.W700)
                    Spacer(modifier = Modifier.padding(10.dp))
                    aboutInstructor.ShowText(detailColor, fontSizeTopic)
                }
            }
        }
    }
}

@Composable
fun InstructorCourseHolderColumn(backgroundColor: Color, with: Int,
                                 upSpacerPadding: Int, bottomSpacerPadding: Int,
                                 suggestedCourseList: List<InformativeCourseGroupModel>,
                                 objectHeight: Dp
){
    Surface(color = backgroundColor, modifier = Modifier
        .width((with + upSpacerPadding + bottomSpacerPadding).dp)
        .fillMaxHeight()) {
        Column {
            Spacer(modifier = Modifier.padding(upSpacerPadding.dp))
            LazyColumn {
                items(suggestedCourseList.size) { index ->

                    InstructorCurseObject(model = suggestedCourseList[index], objectHeight)

                }
            }
            Spacer(modifier = Modifier.padding(bottomSpacerPadding.dp))
        }


    }
}
class LimitedString(private val limit: Int, private val text: String){
    @Composable
    fun ShowText()
    {
        var showedString = text;
        if (text.length > limit) showedString = text.substring(0, limit)
        Text(text = "$showedString...")
    }
    @Composable
    fun ShowText(textColor: Color)
    {
        var showedString = text;
        if (text.length > limit) showedString = text.substring(0, limit)
        Text(text = "$showedString...", color = textColor)
    }
    @Composable
    fun ShowText(textColor: Color, fontSize: TextUnit)
    {
        var showedString = text;
        if (text.length > limit) showedString = text.substring(0, limit)
        Text(text = "$showedString...", color = textColor , fontSize = fontSize)
    }
}

