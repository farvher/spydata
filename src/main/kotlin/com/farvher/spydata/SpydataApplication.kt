package com.farvher.spydata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpydataApplication

fun main(args: Array<String>) {
    runApplication<SpydataApplication>(*args)
}
