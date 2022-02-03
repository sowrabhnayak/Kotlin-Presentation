package com.example.kotlindemo.functions

class Functions {

    private var variable = ""
        set(value) {
            println("Set called on variable with value $value")
            field = value.lowercase().trim()
            println("Updated the variable value to $field")
        }

    private val os by lazy {
         "${System.getProperty("os.name")}v${System.getProperty("os.version")}"
    }

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