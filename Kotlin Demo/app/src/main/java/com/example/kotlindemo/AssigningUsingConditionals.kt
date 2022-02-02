package com.example.kotlindemo

class PayLoad
class IOError
class HTTPError



val responseCode = 0
val x = when(responseCode){
    0 -> PayLoad()
    1 -> IOError()
    2 -> HTTPError()
    else -> {}
}