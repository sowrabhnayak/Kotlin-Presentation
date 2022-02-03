package com.example.kotlindemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

const val noOfRunnable = 10000L
const val sleepTime = 5000L

fun main() {
    threadSample()
//    coroutineSample()
}

fun threadSample() {
    for (i in 1..noOfRunnable) {
        Thread {
            sleep(sleepTime)
            println(i)
        }.start()
    }
}

fun coroutineSample() = runBlocking {
    for (i in 1..noOfRunnable) {
        launch {
            delay(sleepTime)
            println(i)
        }
    }
}
