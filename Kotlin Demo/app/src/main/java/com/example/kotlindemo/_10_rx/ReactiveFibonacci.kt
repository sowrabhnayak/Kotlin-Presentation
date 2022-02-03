package com.example.kotlindemo._10_rx

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

private val coroutineScope = CoroutineScope(Job())

fun main() {
    println("Thread: ${Thread.currentThread()}")
    val job = coroutineScope.launch {
        println("Thread: ${Thread.currentThread()}")
        collectNumbers()
    }
    coroutineScope.launch {
        delay(10000)
        println("Cancelling the Coroutine")
        job.cancel()
    }
    keepMainThreadAlive(job)
}

private fun keepMainThreadAlive(job: Job) {
    while (job.isActive) {
    }
}

fun fibonacci(): Flow<Int> = flow {
    emit(1)
    var f1 = 1
    var f2 = 1
    while (true) {
        delay(500)
        val temp = f2
        f2 += f1
        f1 = temp
        emit(f1)
    }
}

suspend fun collectNumbers() {
    fibonacci().collect {
        println("$it")
    }
}

