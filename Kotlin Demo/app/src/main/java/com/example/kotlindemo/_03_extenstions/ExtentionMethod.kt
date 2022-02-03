package com.example.kotlindemo._03_extenstions

val malayalam = "Malayalam";
val random = "random"

fun main() {
    println("is $malayalam a palindrome ${malayalam.isPalindrome()}")
    println("is $random a palindrome ${random.isPalindrome()}")
}

fun String.isPalindrome(): Boolean {
    return this.lowercase() == this.lowercase().reversed()
}