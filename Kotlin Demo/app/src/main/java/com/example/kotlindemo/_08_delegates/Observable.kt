package com.example.kotlindemo._08_delegates

import kotlin.properties.Delegates

object Observable {

    var observableVariable by Delegates.observable("") { p, old, new ->
        println("${p.name} updated from $old to $new")
    }

}

fun main() {
    Observable.observableVariable = "Bangalore"
    Thread.sleep(2000)
    Observable.observableVariable = "Mysore"
}