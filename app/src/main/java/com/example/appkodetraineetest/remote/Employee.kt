package com.example.appkodetraineetest.remote

/**
 * Contains employee information from the users API
 * */
data class Employee(
    val id: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
    val userTag: String,
    val department: String,
    val position: String,
    val birthday: String,
    val phone: String
)