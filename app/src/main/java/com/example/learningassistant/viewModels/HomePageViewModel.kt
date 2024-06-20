package com.example.learningassistant.viewModels

import androidx.lifecycle.ViewModel
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.homePageModels.FeatureCourseGroupModel
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel

class HomePageViewModel: ViewModel()
{
    private var suggestedCourses = ArrayList<InformativeCourseGroupModel>()

    private var topicsList = ArrayList<String>()

    private var featureCourseList = ArrayList<FeatureCourseGroupModel>()

    fun getSuggestedCourses(): ArrayList<InformativeCourseGroupModel>
    {
        suggestedCourses = getInformativeCourses()
        return suggestedCourses
    }

    fun getTopicsList(): ArrayList<String>
    {
        topicsList = getTopicsButton()
        return topicsList
    }

    fun getFeatureCourses(): ArrayList<FeatureCourseGroupModel>
    {
        featureCourseList = getFeatureCoursesList()
        return featureCourseList
    }

    private fun getTopicsButton(): ArrayList<String>{
        topicsList.clear()
        val topics = listOf(
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
        topics.forEachIndexed { _, topic ->
            topicsList.add(topic)
        }
        return topicsList
    }


    private fun getFeatureCoursesList(): ArrayList<FeatureCourseGroupModel>{
        featureCourseList.clear()
        val featureCourse1 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 1", liked = false, price = 100, rating = 4.7F, ratingCount = 130)
        val featureCourse2 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 2", liked = true, price = 120, rating = 4.3F, ratingCount = 571)
        val featureCourse3 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 3", liked = false, price = 80, rating = 4.1F, ratingCount = 239)
        val featureCourse4 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 4", liked = false, price = 700, rating = 5.0F, ratingCount = 982)
        val featureCourse5 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 5", liked = true, price = 102, rating = 4.1F, ratingCount = 101)
        val featureCourse6 = FeatureCourseGroupModel(image = R.drawable.schen, title = "Example 6", liked = true, price = 10, rating = 3.2F, ratingCount = 1678)
        featureCourseList.add(featureCourse1)
        featureCourseList.add(featureCourse2)
        featureCourseList.add(featureCourse3)
        featureCourseList.add(featureCourse4)
        featureCourseList.add(featureCourse5)
        featureCourseList.add(featureCourse6)
        return featureCourseList
    }


    private fun getInformativeCourses(): ArrayList<InformativeCourseGroupModel>{
        suggestedCourses.clear()
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


}