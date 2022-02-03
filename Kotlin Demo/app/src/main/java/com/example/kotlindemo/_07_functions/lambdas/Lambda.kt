package com.example.kotlindemo._07_functions.lambdas

/**
 * Receive
 */
enum class ResponseEnum {
    SUCCESS,
    FAILURE
}

fun processResponse(response: String, callback: (ResponseEnum) -> Unit) {
    if (response.isBlank().not()) {
        callback(ResponseEnum.SUCCESS)
    } else {
        callback(ResponseEnum.FAILURE)
    }
}

fun main() {
    processResponse("") { println(it) }

//    processResponse("") { responseEnum, responseCode -> println("$responseEnum $responseCode") }
}