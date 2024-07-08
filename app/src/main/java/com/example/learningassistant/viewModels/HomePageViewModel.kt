package com.example.learningassistant.viewModels

import androidx.lifecycle.ViewModel
import com.example.learningassistant.R
import com.example.learningassistant.data.dataClasses.homePageModels.FeatureCourseGroupModel
import com.example.learningassistant.data.dataClasses.homePageModels.InformativeCourseGroupModel

class HomePageViewModel : ViewModel() {

    private val _suggestedCourses = listOf(
        InformativeCourseGroupModel("Global Business Trends andMarkets", 5, 12, 12, 700),
        InformativeCourseGroupModel("Example 2", 1, 1, 40, 200),
        InformativeCourseGroupModel("Example 3", 3, 2,30, 250),
        InformativeCourseGroupModel("Example 4", 7, 10, 20, 600),
        InformativeCourseGroupModel("Example 5", 12, 11, 10, 900)
    )
    val suggestedCourses: List<InformativeCourseGroupModel>
        get() = _suggestedCourses

    private val _topicsList = listOf(
        "AI & Future",
        "Climate Change",
        "Digital Marketing",
        "Renewable Energy",
        "VR & AR",
        "Post-Pandemic Education",
        "Blockchain & Crypto",
        "Space Exploration",
        "Digital Health",
        "Global Economy",
        "Innovation & Entrepreneurship",
        "Cultural Diversity",
        "Robotics & Automation",
        "Biotech & Genetic Engineering",
        "Digital Art",
        "Next-Gen Transportation",
        "Data Privacy & Cybersecurity",
        "Structured Finance & DeFi",
        "AI Ethics",
        "Future Business Models"
    )
    val topicsList: List<String>
        get() = _topicsList

    private val _featureCourseList = listOf(
        FeatureCourseGroupModel(R.drawable.schen, "Example 1", false, 100, 4.7f, 130),
        FeatureCourseGroupModel(R.drawable.schen, "Example 2", true, 120, 4.3f, 571),
        FeatureCourseGroupModel(R.drawable.schen, "Example 3", false, 80, 4.1f, 239),
        FeatureCourseGroupModel(R.drawable.schen, "Example 4", false, 700, 5.0f, 982),
        FeatureCourseGroupModel(R.drawable.schen, "Example 5", true, 102, 4.1f, 101),
        FeatureCourseGroupModel(R.drawable.schen, "Example 6", true, 10, 3.2f, 1678)
    )
    val featureCourseList: List<FeatureCourseGroupModel>
        get() = _featureCourseList
}