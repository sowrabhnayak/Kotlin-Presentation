package com.example.kotlindemo._07_functions.closures

val outer = fun(): () -> Unit {
    val a = "Data"
    val inner = fun() {
        println(a)
    }
    return inner // this returns a function
}

fun getInnerFunction(): () -> Unit {
    val a = "Data"
    val inner = fun() {
        println(a)
    }
    return inner
}

fun main() {
    outer.invoke().invoke()
    getInnerFunction().invoke()
}