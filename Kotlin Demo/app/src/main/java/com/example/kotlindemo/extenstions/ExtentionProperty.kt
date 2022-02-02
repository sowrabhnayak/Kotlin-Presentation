package com.example.kotlindemo.extenstions

val x = 10;

fun main(){
    println("Binary Form of $x = ${x.binaryForm()}")
}

fun Int.binaryForm():String{
    return this.toString(2);
}