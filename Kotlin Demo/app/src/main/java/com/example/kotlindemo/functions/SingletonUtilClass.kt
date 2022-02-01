package com.example.kotlindemo.functions

object SingletonUtilClass {

    fun getSumOfNumbers(a: Int, b: Int) = a + b

    fun getFirstWord(s: String, separator: String): String {
        val index = s.indexOf(separator)
        return if (index == -1) {
            return s
        } else {
            s.substring(0, index)
        }
    }

    /**
     * This is no more necessary
     */
    fun getFirstWord(s: String): String = getFirstWord(s, " ")

}