package com.example.kotlindemo._10_rx

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.math.ceil
import kotlin.math.min

private val coroutineScope = CoroutineScope(Job())

fun main() {
    val job = coroutineScope.launch {
        makePizzas()
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

val doughProducer: Flow<List<Dough>> = flow {
    var doughCount = 0
    while (true) {
        delay(1000)
        val rand = ceil(Math.random() * 10).toInt()
        val list = mutableListOf<Dough>()
        for (i in 0 until rand) {
            list.add(Dough(doughCount++))
        }
        println("Dough Emitted ${doughCount - rand} - $doughCount")
        emit(list)
    }
}

val cheeseProducer: Flow<Cheese> = flow {
    var cheeseCount = 0
    while (true) {
        delay(600)
        println("Cheese Emitted $cheeseCount")
        emit(Cheese(cheeseCount++))
    }
}

val pizzaBread: Flow<PizzaBread> = doughProducer.transform { doughList ->
    doughList.forEach { dough ->
        delay(100)
        println("PizzaBread emitted ${dough.index}")
        emit(PizzaBread(dough.index))
    }
}

val pizza: Flow<Pizza> =
    pizzaBread.zip<PizzaBread, Cheese, Pizza>(cheeseProducer) { pizzaBread, cheese ->
        val index = min(pizzaBread.index, cheese.index)
        delay(5000)
        println("Pizza $index emitted ")
        Pizza(index)
    }

suspend fun makePizzas() {
    pizza.collect {
        println("Served Pizza ${it.index}")
    }
}

class Dough(val index: Int)
class PizzaBread(val index: Int)
class Cheese(val index: Int)
class Pizza(val index: Int)