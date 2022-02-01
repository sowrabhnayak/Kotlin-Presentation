package com.example.kotlindemo.scope

class ViewDetails(
    var length: Int = 25,
    var breadth: Int = 25,
    var area: Int  = 0,
    var perimeter: Int = 0,
    var isSquare: Boolean = false
)

class ScopeFunctions {

    private val viewCache = mutableMapOf<String, ViewDetails>()
    private val viewLock = Any()

    fun applyFunction(view: ViewDetails) {
        view.apply {
            area = length * breadth
            perimeter = 2 * (length + breadth)
            isSquare = length == breadth
        }
    }

    fun alsoFunction(shapeId: String, defaultView: ViewDetails): ViewDetails {
        return viewCache[shapeId] ?: synchronized(viewLock) {
            viewCache[shapeId] ?: defaultView.also {
                println("Setting the default Shape")
                viewCache[shapeId] = defaultView
            }
        }
    }

}