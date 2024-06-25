package com.example.learningassistant.accountPageDataClasses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
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
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.textUnitScheme

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
            Text(text = name, fontSize = MaterialTheme.textUnitScheme.fontSizeMainHeader, fontWeight = FontWeight.W700)
            miniBio.ShowText()
            
            Spacer(modifier = Modifier.padding(12.dp))
            
            Surface(modifier = Modifier.fillMaxWidth())
            {
                Row(horizontalArrangement = Arrangement.SpaceEvenly)
                {
                    NumberAndInfo(
                        number = courses,
                        sizeNum = MaterialTheme.textUnitScheme.fontSizeMainHeader,
                        fontWeightNum = FontWeight.W700,

                        info = "Courses",
                        sizeInfo = MaterialTheme.textUnitScheme.fontSizeDetails,

                        height = 50.dp
                    )
                    NumberAndInfo(
                        number = totalStudent,
                        sizeNum = MaterialTheme.textUnitScheme.fontSizeMainHeader,
                        fontWeightNum = FontWeight.W700,

                        info = "Total Student",
                        sizeInfo = MaterialTheme.textUnitScheme.fontSizeDetails,

                        height = 50.dp
                    )
                    NumberAndInfo(
                        number = review,
                        sizeNum = MaterialTheme.textUnitScheme.fontSizeMainHeader,
                        fontWeightNum = FontWeight.W700,

                        info = "Review",
                        sizeInfo = MaterialTheme.textUnitScheme.fontSizeDetails,

                        height = 100.dp
                    )
                }
            }

            Surface(Modifier.fillMaxWidth())
            {
                Column(verticalArrangement = Arrangement.SpaceBetween)
                {
                    Text(text = "About Instructor", fontSize = MaterialTheme.textUnitScheme.fontSizeHuge, fontWeight = FontWeight.W700)
                    Spacer(modifier = Modifier.padding(10.dp))
                    aboutInstructor.ShowText(detailColor, MaterialTheme.textUnitScheme.fontSizeTopic)
                }
            }

            Surface(modifier = Modifier.fillMaxWidth())
            {
                Column()
                {
                    Surface()
                    {
                        InstructorCourseHolderColumn(
                            backgroundColor = Color.White,
                            width = 500,
                            upSpacerPadding = 10,
                            bottomSpacerPadding = 10,
                            suggestedCourseList = popularCourses,
                            objectHeight = 150.dp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InstructorCourseHolderColumn(backgroundColor: Color, width: Int,
                                 upSpacerPadding: Int, bottomSpacerPadding: Int,
                                 suggestedCourseList: List<InformativeCourseGroupModel>,
                                 objectHeight: Dp
){
    Surface(color = backgroundColor, modifier = Modifier
        .width((width + upSpacerPadding + bottomSpacerPadding).dp)
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

