package com.example.kotlindemo._10_rx

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

private val coroutineScope = CoroutineScope(Job())

fun main() {
    printCurrentThread()
    val job = coroutineScope.launch {
        printCurrentThread()
        collectFibonacciNumbers()
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

private fun printCurrentThread() {
    println("Thread: ${Thread.currentThread()}")
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

suspend fun collectFibonacciNumbers() {
    fibonacci().collect {
        println("$it")
    }
}

