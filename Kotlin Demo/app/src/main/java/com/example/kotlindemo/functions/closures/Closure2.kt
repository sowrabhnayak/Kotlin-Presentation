package com.example.kotlindemo.functions

val outer = fun():()->Unit{
    var a = "Data"
    var inner = fun() {
        println(a)
    }
    return inner; // this returns a function
}
fun main(){
    outer.invoke().invoke()
}