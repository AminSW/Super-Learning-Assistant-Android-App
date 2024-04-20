package com.example.learningassistant.dataClasses.learningPageModels

data class PublicGroupModel(
    val groupName: String,
    val notification: Boolean,
    val lastMessage: String
)