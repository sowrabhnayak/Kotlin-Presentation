package com.example.kotlindemo._07_functions.inline

enum class ResponseType {
    SUCCESS,
    FAILURE
}

inline fun responseValidation(response: String?, fn: (ResponseType) -> Unit) {
    if (response.isNullOrEmpty()) {
        fn(ResponseType.FAILURE)
    } else {
        fn(ResponseType.SUCCESS)
    }
}

fun main() {
    val response1 = "{name:\"Messi\"}"
    responseValidation(response1) {
        println("Response type is: $it")
    }
}