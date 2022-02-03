package com.example.kotlindemo._07_functions.closures

val outer = fun(): () -> Unit {
    var a = "Data"
    var inner = fun() {
        println(a)
    }
    return inner // this returns a function
}

fun main() {
    outer.invoke().invoke()
}