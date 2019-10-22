package com.demo.journalist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JournalistApplication

fun main(args: Array<String>) {
	runApplication<JournalistApplication>(*args)
}
