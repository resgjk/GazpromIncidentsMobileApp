package com.example.gazpromincidents.models

data class User(
    val id: Int,
    val username: String,
    val name: String,
    val surname: String,
    val name_by_father: String,
    val job_title: String,
    val on_work: Boolean,
    val phone_number: String,
    val password: String
)
