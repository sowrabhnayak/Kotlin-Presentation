package com.example.kotlindemo._09_rx

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


suspend fun main() {
    makePizzas()
}

// Dough -> Pizza Bread -> Pizza
//              Cheese ->



val doughProducer: Flow<List<Dough>> = flow {
    var doughCount = 0;
    while (true) {
        delay(1000)
        val rand = Math.ceil(Math.random() * 10).toInt()
        val list = mutableListOf<Dough>()
        for (i in 1 until rand + 1) {
            list.add(Dough(doughCount++))
        }
        println("Dough Emitted ${doughCount - rand} - $doughCount")
        emit(list)
    }
}

val cheeseProducer: Flow<Cheese> = flow {
    var cheeseCount = 0;
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
        val index = Math.min(pizzaBread.index, cheese.index)
        delay(5000)
        println("Pizza $index emitted ")
        Pizza(index)
    }

suspend fun makePizzas() {
    pizza.collect { println("Served Pizza ${it.index}") }
}

class Dough(val index: Int)
class Cheese(val index: Int)
class PizzaBread(val index: Int)
class Pizza(val index: Int)