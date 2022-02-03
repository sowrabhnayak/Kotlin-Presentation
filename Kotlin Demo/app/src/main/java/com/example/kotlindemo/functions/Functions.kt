package com.example.kotlindemo.functions

class Functions {

    fun processResponse(response: String, callback: (ResponseEnum) -> Unit) {
        if (response.isBlank().not()) {
            callback(ResponseEnum.SUCCESS)
        } else {
            callback(ResponseEnum.FAILURE)
        }
    }

}

enum class ResponseEnum {
    SUCCESS,
    FAILURE
}