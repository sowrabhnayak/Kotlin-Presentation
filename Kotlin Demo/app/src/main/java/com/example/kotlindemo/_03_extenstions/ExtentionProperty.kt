package com.example.kotlindemo._03_extenstions

val x = 10;

val Int.binaryForm: String
    get() {
        return toString(2)
    }

fun main() {
    println("Binary Form of $x = ${x.binaryForm}")
}