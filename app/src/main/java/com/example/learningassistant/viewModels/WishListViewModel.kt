package com.example.learningassistant.viewModels

import androidx.lifecycle.ViewModel
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel

class WishListViewModel: ViewModel() {

    private val _wishList = mutableListOf(
        InformativeCourseGroupModel("Example1", 12, 90, 10, 700),
        InformativeCourseGroupModel("Example2", 15, 32, 23, 400),
        InformativeCourseGroupModel("Example3", 17, 56, 35, 300),
        InformativeCourseGroupModel("Example4", 8, 24, 27, 200),
        InformativeCourseGroupModel("Example5", 10, 20, 48, 100),
        InformativeCourseGroupModel("Example6", 5, 10, 40, 320),
        InformativeCourseGroupModel("Example7", 11, 29, 18, 450),
        InformativeCourseGroupModel("Example8", 2, 4, 30, 120)
    )

    val wishList: List<InformativeCourseGroupModel>
        get() = _wishList
}