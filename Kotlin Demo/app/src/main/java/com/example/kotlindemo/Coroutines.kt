package com.example.kotlindemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

fun main(){
//    threadSample()
    coroutineSample()
}

fun threadSample() {
    for(i in 1..10000){
        Thread {
            sleep(1000)
            println(i)
        }.start()
    }
}

fun coroutineSample() = runBlocking {
    for(i in 1..10000){
        launch {
            delay(1000L)
            println(i)
        }
    }
}
