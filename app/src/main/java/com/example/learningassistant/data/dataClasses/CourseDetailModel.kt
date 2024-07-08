package com.example.learningassistant.data.dataClasses

data class CourseDetailModel(
    private val title: String,
    private val videos: List<Video>,
    private val description: String,
    private val evaluation: Float
)
