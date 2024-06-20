package com.example.learningassistant.viewModels

import androidx.lifecycle.ViewModel
import com.example.learningassistant.accountPageDataClasses.Instructor
import com.example.learningassistant.accountPageDataClasses.LimitedString
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel

class AccountPageViewModel : ViewModel() {

    private var instructorObject: Instructor? = null
    private val suggestedCourses = ArrayList<InformativeCourseGroupModel>()

    fun getInformativeCoursesForAccountPage(): ArrayList<InformativeCourseGroupModel> {
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
        return suggestedCourses
    }

    fun getInstructorObject(): Instructor?
    {
        instructorObject = Instructor(
            name = "Amin Azizzade",
            miniBio = LimitedString(25  , "Computer Engineer"),
            courses = 12,
            totalStudent = 12345,
            review = 4214,
            aboutInstructor = LimitedString(250, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer;LSNDSBF"),
            popularCourses = suggestedCourses
        )
        return instructorObject
    }


}