package com.example.kotlindemo._04_filters

import kotlin.system.measureTimeMillis

class FiltersClass {

    fun addAllEvenNumbers(list: List<Int>) {
        val time = measureTimeMillis {
            var sum = 0
            list.filter { it % 2 == 0 }
                .forEach { sum += it }
        }
        println("Total Time taken: $time")
    }

    fun addAllEvenNumberWithIterator(list: List<Int>) {
        val time = measureTimeMillis {
            var sum = 0
            for (int in list) {
                if (int % 2 == 0) {
                    sum += int
                }
            }
        }
        println("Total Time taken: $time")
    }

    fun addAllEvenNumberWithLoop(list: List<Int>) {
        val time = measureTimeMillis {
            var sum = 0
            val size = list.size
            for (i in 0..size) {
                if (list[i] % 2 == 0) {
                    sum += list[i]
                }
            }
        }
        println("Total Time taken: $time")
    }
}