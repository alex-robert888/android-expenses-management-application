package com.example.expensesmanagementapplication.utils

val baseUrl = "http://192.168.0.102:8080";

fun getRegisterUrl(): String {
    return "$baseUrl/auth/register"
}

fun getLogInUrl(): String {
    return "$baseUrl/auth/login"
}


