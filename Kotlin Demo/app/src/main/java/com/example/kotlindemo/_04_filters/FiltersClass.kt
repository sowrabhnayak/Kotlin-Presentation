package com.example.kotlindemo._04_filters

import kotlin.system.measureTimeMillis

object FiltersClass {

    fun addAllEvenNumbersUsingFilters(list: List<Int>) {
        println("Executing addAllEvenNumbersUsingFilters")
        val time = measureTimeMillis {
            var sum = 0
            list.filter { it % 2 == 0 }
                .forEach { sum += it }
            println("Total sum: $sum")
        }
        println("Total Time taken: $time")
    }

    fun addAllEvenNumberWithIterator(list: List<Int>) {
        println("Executing addAllEvenNumberWithIterator")
        val time = measureTimeMillis {
            var sum = 0
            for (int in list) {
                if (int % 2 == 0) {
                    sum += int
                }
            }
            println("Total sum: $sum")
        }
        println("Total Time taken: $time")
    }

    fun addAllEvenNumberWithLoop(list: List<Int>) {
        println("Executing addAllEvenNumberWithLoop")
        val time = measureTimeMillis {
            var sum = 0
            val size = list.size
            for (i in 0 until size) {
                if (list[i] % 2 == 0) {
                    sum += list[i]
                }
            }
            println("Total sum: $sum")
        }
        println("Total Time taken by addAllEvenNumberWithLoop: $time")
    }
}

fun main() {
    val shuffled = (0..1000000).shuffled()

    FiltersClass.addAllEvenNumbersUsingFilters(shuffled)
    println()
    FiltersClass.addAllEvenNumberWithIterator(shuffled)
    println()
    FiltersClass.addAllEvenNumberWithLoop(shuffled)
}