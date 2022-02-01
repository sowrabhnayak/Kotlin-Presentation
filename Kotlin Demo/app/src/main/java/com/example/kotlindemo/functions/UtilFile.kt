package com.example.kotlindemo.functions

data class FullName(val firstName: String, val lastName: String)

fun parseName(name: String): FullName {
    val space = name.indexOf(' ')
    return FullName(
        name.substring(0, space),
        name.substring(space + 1)
    )
}

fun processUsername() {
    val username = "Kotlin Demo"
    val nameObject = parseName(username)
    val firstName = nameObject.firstName
    val lastName = nameObject.lastName

    // Usage of variables to print
    println("First Name: $firstName \nLast Name: $lastName")

    // Usage of variables from objects to print
    println("First Name: ${nameObject.firstName} \nLast Name: ${nameObject.lastName}")
}