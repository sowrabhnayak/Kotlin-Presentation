package com.example.kotlindemo

// Available in Java 15
sealed class Response
class SuccessResponse(val data:String) : Response()
class ErrorResponse(val errorReason:String): Response()

fun main(){
    val error = ErrorResponse("ErrorResponse")
    val validResponse = SuccessResponse("{\"success\": true,\"payload\": { /* Application-specific data would go here. */}}")

    readResponse(error)
    readResponse(validResponse)
}

fun readResponse(response: Response) {
    when (response){
        is ErrorResponse -> println(response.errorReason)
        is SuccessResponse -> println(response.data)
    }
}
