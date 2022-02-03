package com.example.kotlindemo.extenstions

val x = 10;

fun main() {
    println("Binary Form of $x = ${x.binaryForm}")
}

val Int.binaryForm: String
    get() {
        return toString(2)
    }