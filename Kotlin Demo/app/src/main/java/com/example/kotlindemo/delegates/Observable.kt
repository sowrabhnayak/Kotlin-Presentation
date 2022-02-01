package com.example.kotlindemo.delegates

import kotlin.properties.Delegates

class Observable {

    val observableVariable by Delegates.observable("") { p, old, new ->
        println("${p.name} updated from $old to $new")
    }

}