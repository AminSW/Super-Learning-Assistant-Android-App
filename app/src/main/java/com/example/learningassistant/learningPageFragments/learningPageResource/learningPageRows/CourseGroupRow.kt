package com.example.learningassistant.learningPageFragments.learningPageResource.learningPageRows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningassistant.learningPageFragments.learningPages.CourseInfoText
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.learningPageModels.CourseGroupModel
import com.example.learningassistant.learningPageFragments.learningPageResource.LinearProgressBar
import com.example.learningassistant.ui.theme.containerColor
import com.example.learningassistant.ui.theme.detailColor

@Composable
fun CourseRow(course: CourseGroupModel) {
    Surface(
        color = containerColor,
        modifier = Modifier
            .padding(10.dp)
            .height(130.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 3.dp
    )
    {
        Row {

            Surface(
                modifier = Modifier.padding(10.dp, 15.dp, 10.dp, 15.dp),
                shape = RoundedCornerShape(15.dp),
                color = containerColor
            )
            {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                    contentDescription ="a")
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            )
            {
                Spacer(modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp))

                Surface(
                    modifier = Modifier.height(40.dp)
                    .fillMaxWidth(),
                    color = containerColor)
                {
                    CourseInfoText(
                        fontSize    = 17.sp,
                        info        = course.groupName,
                        fontWeight  = FontWeight.Bold,
                        color       = Color.Unspecified
                    )
                }

                Surface(
                    modifier    = Modifier.height(40.dp),
                    color       = containerColor
                )
                {
                    CourseInfoText(
                        fontSize    = 14.sp,
                        info        = course.teacher,
                        fontWeight  = FontWeight.SemiBold,
                        color       = detailColor
                    )
                }
                Surface(modifier = Modifier.height(30.dp), color = containerColor) {
                    LinearProgressBar(course.totalTask, course.completedTask)
                }

            }

        }
    }

}