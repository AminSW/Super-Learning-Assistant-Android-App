package com.example.learningassistant.dataClasses

data class CourseDetailModel(
    private val title: String,
    private val videos: List<Video>,
    private val description: String,
    private val evaluation: Float
)
