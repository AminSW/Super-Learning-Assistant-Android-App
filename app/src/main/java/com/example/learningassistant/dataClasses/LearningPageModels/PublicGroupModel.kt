package com.example.learningassistant.dataClasses.LearningPageModels

data class PublicGroupModel(
    val groupName: String,
    val notification: Boolean,
    val lastMessage: String
)