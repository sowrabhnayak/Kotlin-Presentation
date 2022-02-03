package com.example.kotlindemo._08_delegates

/**
 * Std Lib Delegate
 */
class DelegateClass {

    val os by lazy {
        val initValue = "${System.getProperty("os.name")}v${System.getProperty("os.version")}"
        println("Initialized value: $initValue")
        initValue
    }

}

fun main() {
    val delegateClass = DelegateClass()
    println("Sleeping for 2sec")
    Thread.sleep(2000)
    println("Sleeping of 2sec Finished")
    println("Value of OS is: ${delegateClass.os}")
}