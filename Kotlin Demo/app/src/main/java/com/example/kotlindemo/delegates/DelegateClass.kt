package com.example.kotlindemo.delegates

/**
 * Std Lib Delegate
 */
private val os by lazy {
    "${System.getProperty("os.name")}v${System.getProperty("os.version")}"
}