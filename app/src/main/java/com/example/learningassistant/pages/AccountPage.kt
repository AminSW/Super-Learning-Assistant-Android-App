package com.example.learningassistant.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.learningassistant.accountPageDataClasses.Instructor
import com.example.learningassistant.accountPageDataClasses.LimitedString
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.interfaceClasses.InformativeCourses
import com.example.learningassistant.ui.theme.detailColor


private val suggestedCourses = ArrayList<InformativeCourseGroupModel>()
//private val suggestedCourseOperator = InformativeCourses()
private val instructorObject = Instructor(
    name = "Amin Azizzade",
    miniBio = LimitedString(25  , "Computer Engineer"),
    courses = 12,
    totalStudent = 12345,
    review = 4214,
    aboutInstructor = LimitedString(250, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer;LSNDSBF"),
    popularCourses = suggestedCourses
    )

@Composable
fun AccountPage(navController: NavController, navControllerHost: NavController){
    getInformativeCoursesForAccountPage()
    PageInterfaceClassic(navControllerHost = navControllerHost, pageNumber = 4) {
        Surface(modifier = Modifier.fillMaxWidth().background(Color.Blue))
        {
            instructorObject.ShowThePage()
        }
    }
}

private fun getInformativeCoursesForAccountPage(){
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