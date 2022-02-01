package com.example.kotlindemo.expressions

class ExpressionClass {

    private val localMutableMap = mutableMapOf<Char, Int>()

    fun addValueToMap(key: Char, value: Int) {
        localMutableMap[key] = value
    }

    private val localUnMutableMap = mapOf(
        Pair('a', 1),
        Pair('b', 1),
        Pair('c', 1),
        Pair('d', 2),
        Pair('e', 2),
        Pair('g', 3),
        Pair('h', 4)
    )

    fun printMap() {
        for((key, value) in localUnMutableMap) {
            println("$key -> $value")
        }
    }

    fun applyWhen(char: Char): String {
        when(char) {
            'a' -> return "Part of first Category"
            'b' -> return "Part of first Category"
            'd' -> return "Part of second Category"
            'e' -> return "Part of second Category"
            'g' -> return "Part of third Category"
            'h' -> return "Part of third category"
            else -> return "Unknown Category"
        }
    }

    fun functionOnNullability(str: String?): String? {
        println(str!!.length)

        if (str != null) {
            str.forEach {
                print(it)
            }
        }

        if (str == null) return null

        return "String is $str"
    }

}