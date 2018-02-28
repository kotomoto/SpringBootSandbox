package org.koto.restplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RestPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<RestPlaygroundApplication>(*args)
}
