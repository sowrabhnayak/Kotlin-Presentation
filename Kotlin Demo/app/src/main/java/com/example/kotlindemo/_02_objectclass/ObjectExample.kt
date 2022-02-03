package com.example.kotlindemo._02_objectclass

object Preferences {

    fun getSetting1() {
        println("getSetting1 called")
    }

    fun getSetting2() {
        println("getSetting2 called")
    }

    fun getSetting3() {
        println("getSetting3 called")
    }
}

fun main() {
    println(Preferences.getSetting1())
    println(Preferences.getSetting2())
    println(Preferences.getSetting3())
}