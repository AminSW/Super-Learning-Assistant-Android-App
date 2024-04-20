package com.example.learningassistant.learningPageFragments.learningPages

import com.example.learningassistant.dataClasses.learningPageModels.CourseGroupModel
import com.example.learningassistant.ui.theme.backgroundColorClassic


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learningassistant.learningPageFragments.learningPageResource.PageInterfaceForLearningPages
import com.example.learningassistant.learningPageFragments.learningPageResource.learningPageRows.CourseRow


@ExperimentalMaterial3Api
@Composable
fun CourseGroup(navController: NavController, navControllerHost: NavController) {

    PageInterfaceForLearningPages(
        navController = navController, navControllerHost = navControllerHost, 2)
    {
        Spacer(modifier = Modifier.padding(35.dp))
        CourseGroupList()
        Spacer(modifier = Modifier.padding(35.dp))
    }
}

@Composable
fun CourseGroupList(){
    val courseList = remember { mutableStateListOf<CourseGroupModel>() }
    addValuesToCourseList(courseList)
    GroupsList(courseList = courseList)
}

@Composable
fun GroupsList(courseList: List<CourseGroupModel>) {
    Surface(modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 80.dp),
        color = backgroundColorClassic
    ) {
        LazyColumn {
            items(courseList.size) { index ->
                CourseRow(course = courseList[index])
            }
        }
    }
}

@Composable
fun CourseInfoText(fontSize: TextUnit, info: String, fontWeight: FontWeight, color: Color) {
    Text(
        text = info,
        modifier = Modifier
            .width(150.dp)
            .padding(5.dp),
        fontSize = fontSize,
        fontStyle = FontStyle.Normal,
        fontWeight = fontWeight,
        color = color
    )
}


fun stringShorten(string: String): String
{
    return if (string.length < 21) string
    else {
        StringBuilder().append(string.subSequence(0,21)).append("...").toString()
    }
}

fun addValuesToCourseList(courseList: SnapshotStateList<CourseGroupModel>) {
    val model1 = CourseGroupModel(stringShorten("Example 1 Example Long Text"), "Amin Aziz", 2, true, 52, 14)
    courseList.add(model1)

    val model2 = CourseGroupModel(stringShorten("Example 2"), "Ramin Aziz", 3, true, 89, 35)
    courseList.add(model2)

    val model3 = CourseGroupModel(stringShorten("Example 3"), "Zekeriya", 3, true, 12, 11)
    courseList.add(model3)

    val model4 = CourseGroupModel(stringShorten("Example 4"), "Maga", 3, true, 3, 3)
    courseList.add(model4)

    val model5 = CourseGroupModel(stringShorten("Example 5"), "Maga ", 3, true, 95, 5)
    courseList.add(model5)

    val model6 = CourseGroupModel(stringShorten("Example 6"), "Maga", 3, true, 47, 44)
    courseList.add(model6)

    val model7 = CourseGroupModel(stringShorten("Example 7"), "Maga", 3, true, 68, 54)
    courseList.add(model7)

    val model8 = CourseGroupModel(stringShorten("Example 8"), "Maga", 3, true, 82, 42)
    courseList.add(model8)
}