package com.ute.fragment.model

import java.io.Serializable

data class Student(
    val id: String,
    val studentId: String,
    val name: String,
    val email: String,
    val phone: String,
    val major: String,
    val className: String,
    val gpa: Double,
    val gender: String
) : Serializable