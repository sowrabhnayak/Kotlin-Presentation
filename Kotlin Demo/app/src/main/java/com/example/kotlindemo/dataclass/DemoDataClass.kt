package com.example.kotlindemo.dataclass

data class FullName(var firstName: String, var lastName: String)

fun main(){


    // Java
    val javaCandidate1 = JavaFullName("Nayak", "Sowrabh")
    val javaCandidate2 = JavaFullName("Nayak", "Sowrabh")
    val javaCandidate3 = javaCandidate1.clone()
    println("Java  ")
    println(javaCandidate1)
    println("Is candidate1 = candidate2 ${javaCandidate1 == javaCandidate2}")
    println("Candidate1 HashCode = ${javaCandidate1.hashCode()}, candidate2.hashCode = ${javaCandidate2.hashCode()}")
    println(javaCandidate3)

    repeat(3) { println() }
    //Kotlin
    val candidate1 = FullName("Nayak", "Sowrabh")
    val candidate2 = FullName("Nayak", "Sowrabh")
    val candidate3 = candidate1.copy()
    println(candidate1)
    println("Is candidate1 = candidate2 ${candidate1 == candidate2}")
    println("Candidate1 HashCode = ${candidate1.hashCode()}, candidate2.hashCode = ${candidate2.hashCode()}")
    println(candidate3)
}