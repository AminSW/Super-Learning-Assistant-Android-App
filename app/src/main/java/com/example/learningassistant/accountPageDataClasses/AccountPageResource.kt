package com.example.learningassistant.accountPageDataClasses

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.learningassistant.R
import com.example.learningassistant.data.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.interfaceClasses.CourseImage
import com.example.learningassistant.interfaceClasses.CourseLessonAndHours
import com.example.learningassistant.interfaceClasses.CourseMainText
import com.example.learningassistant.interfaceResources.buttonHierarchy.ColorsOfButton
import com.example.learningassistant.interfaceResources.buttonHierarchy.FilledButton
import com.example.learningassistant.learningPageFragments.learningPageResource.mainColor
import com.example.learningassistant.ui.theme.borderColor
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.priceColor
import com.example.learningassistant.ui.theme.textUnitScheme


@Composable
fun InstructorCurseObject(
    model: InformativeCourseGroupModel, /*, surfaseHeight: Dp*/
    objectHeight: Dp
){
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
        border = BorderStroke(3.dp, borderColor)
        //shadowElevation = 1.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            CourseImage(image = R.drawable.ic_launcher_background)

            Surface(modifier = Modifier.height(160.dp))
            {
                Column(verticalArrangement = Arrangement.SpaceAround)
                {

                    CourseMainText(content = content)

                    CourseLessonAndHours(lessons = lessons, hours = hours, minutes = minutes)

                    CoursePriceAndAddToCart(price = price)

                }
            }
        }
    }
}

@Composable
private fun CoursePriceAndAddToCart(price: Int){

    val colorsOfButton = ColorsOfButton(mainColor, mainColor)
    val filledButton = FilledButton(
        colors = colorsOfButton,
        borderSize = 3,
        height = 30.dp,
        roundedShape = 15.dp,
        padding = 0.dp
    )

    Surface(
        modifier = Modifier
            .width(230.dp)
            .padding(10.dp, 0.dp, 10.dp, 0.dp),
        color = Color.Unspecified)
    {
        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(text = "$$price", color = priceColor, fontSize = MaterialTheme.textUnitScheme.fontSizeDetails, fontWeight = FontWeight.W700)
            filledButton.Show {
                Text(text = "Add To Cart", fontSize = MaterialTheme.textUnitScheme.fontSizeMini)
            }
        }
    }
}

@Composable
public fun NumberAndInfo(
    number: Int,
    info: String,
    sizeNum: TextUnit,
    sizeInfo: TextUnit,
    fontWeightNum: FontWeight,
    height: Dp
)
{
    Surface(modifier = Modifier.height(height)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "$number", fontSize = sizeNum, fontWeight = fontWeightNum)
            Text(text = info, fontSize = sizeInfo, color = detailColor)
        }
    }
}

