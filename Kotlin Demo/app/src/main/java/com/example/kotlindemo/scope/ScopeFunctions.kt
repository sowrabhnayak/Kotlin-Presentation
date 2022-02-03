package com.example.kotlindemo.scope

data class ViewDetails(
    val length: Int,
    val breadth: Int,
    var area: Int = 0,
    var perimeter: Int = 0,
    var isSquare: Boolean = false
)

class ScopeFunctions {

    private val viewCache = mutableMapOf<String, ViewDetails>()
    private val viewLock = Any()

    fun applyFunction(view: ViewDetails) {
        view.area = view.length * view.breadth
        view.perimeter = 2 * (view.length + view.breadth)
        view.isSquare = view.length == view.breadth
    }

    fun alsoFunction(shapeId: String, defaultView: ViewDetails): ViewDetails {
        var value = viewCache[shapeId]
        if (value == null) {
            synchronized(viewLock) {
                value = viewCache[shapeId]
                if (value == null) {
                    println("Setting the default Shape: $defaultView")
                    value = defaultView
                    viewCache[shapeId] = value!!
                    return value!!
                } else {
                    return value!!
                }
            }
        } else {
            return value!!
        }
    }

    fun withFunction(view: ViewDetails) {
        println("The shape has length of ${view.length} breadth of ${view.breadth} and is a " +
                    (if (view.isSquare) "square" else "rectangle") + " with area $${view.area}")
//        with(view) {
//            println("The shape has length of $length breadth of $breadth and is a " +
//                        (if (isSquare) "square" else "rectangle") + " with area $area")
//        }
    }


}