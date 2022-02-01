package com.example.kotlindemo.functions

object SingletonUtilClass {

    fun getSumOfNumbers(a: Int, b: Int) = a + b

    fun getFirstWord(s: String, separator: String): String {
        val index = s.indexOf(separator)
        return if (index == -1) s else s.substring(0, index)
    }

    fun String.firstWord(separator: String): String {
        val index = indexOf(separator)
        return if (index == -1) this else substring(0, index)
    }

    /**
     * This is no more necessary, this can be eliminated by adding default values to params in functions
     */
    fun getFirstWordWithSpaceDelimiter(s: String): String = getFirstWord(s, separator = " ")

    val String.firstWord: String
        get() {
            val index = indexOf(" ")
            return if (index == -1) this else substring(0, index)
        }


    fun printFirstWordOfNames() {
        val names = listOf(
            "Ratan Tata",
            "Lionel Messi",
            "Cristiano Ronaldo"
        )

        names.forEach {
            println(it.firstWord)
        }

    }

}