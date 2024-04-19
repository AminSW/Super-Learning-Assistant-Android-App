package com.example.learningassistant.dataClasses.LearningPageModels

data class CourseGroupModel(
    val groupName       : String,
    val teacher         : String,
    val groupLearners   : Int,
    val groupNews       : Boolean,
    val totalTask       : Int,
    val completedTask   : Int)
