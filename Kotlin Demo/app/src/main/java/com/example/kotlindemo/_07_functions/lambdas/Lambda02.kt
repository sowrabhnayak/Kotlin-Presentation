package com.example.kotlindemo._07_functions.lambdas

import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.annotation.RequiresApi

class Lambda02 {

    lateinit var button: Button
    lateinit var spinner: Spinner

    // Kotlin Style
    private val onLongClickListener: (View) -> Boolean = {
        it.visibility = View.GONE
        true
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setListener() {
        button.setOnLongClickListener(onLongClickListener)
        button.setOnContextClickListener(onLongClickListener)
    }

}