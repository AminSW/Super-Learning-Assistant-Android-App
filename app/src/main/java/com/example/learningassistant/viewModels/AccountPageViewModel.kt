package com.example.learningassistant.viewModels

import androidx.lifecycle.ViewModel
import com.example.learningassistant.accountPageDataClasses.Instructor
import com.example.learningassistant.accountPageDataClasses.LimitedString
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
class AccountPageViewModel : ViewModel() {

    private val _suggestedCourses = listOf(
        InformativeCourseGroupModel("Global Business Trendsand Markets", 5, 12, 12, 700),
        InformativeCourseGroupModel("Example 2", 1, 1, 40, 200),
        InformativeCourseGroupModel("Example 3", 3, 2,30, 250),
        InformativeCourseGroupModel("Example 4", 7, 10, 20, 600),
        InformativeCourseGroupModel("Example 5", 12, 11, 10, 900)
    )
    val suggestedCourses: List<InformativeCourseGroupModel>
        get() = _suggestedCourses

    private val _instructorObject = Instructor(
        name = "Amin Azizzade",
        miniBio = LimitedString(25, "Computer Engineer"),courses = 12,
        totalStudent = 12345,
        review = 4214,
        aboutInstructor = LimitedString(250, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer;LSNDSBF"),
        popularCourses = _suggestedCourses
    )
    val instructorObject: Instructor
        get() = _instructorObject
}