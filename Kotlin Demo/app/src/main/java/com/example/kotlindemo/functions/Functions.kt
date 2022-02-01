package com.example.kotlindemo.functions

class Functions {

    private fun String.responseIsValid(): Boolean {
        return isNullOrBlank().not()
    }

    fun processResponse(response: String, block: (ResponseEnum) -> Unit) {
        if (response.responseIsValid()) {
            block(ResponseEnum.SUCCESS)
        } else {
            block(ResponseEnum.FAILURE)
        }
    }

}