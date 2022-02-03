package com.example.kotlindemo.functions

import android.os.Build
import android.view.View
import android.view.View.GONE
import android.widget.Button
import android.widget.Spinner
import androidx.annotation.RequiresApi


/**
 * Receive
 */
enum class ResponseEnum {
    SUCCESS,
    FAILURE
}
fun processResponse(response: String, callback: (ResponseEnum) -> Unit) {
    if (response.isBlank().not()) {
        callback(ResponseEnum.SUCCESS)
    } else {
        callback(ResponseEnum.FAILURE)
    }
}

fun main() {
    processResponse("") { println(it) }

//    processResponse("") { responseEnum, responseCode -> println("$responseEnum $responseCode") }
}







lateinit var button:Button
lateinit var spinner:Spinner

// Kotlin Style
val onLongClickListener: (View) -> Boolean = {
    it.visibility = GONE
    true
}

@RequiresApi(Build.VERSION_CODES.M)
fun setListener(){
    button.setOnLongClickListener(onLongClickListener)
    button.setOnContextClickListener(onLongClickListener)
}