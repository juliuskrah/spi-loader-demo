package com.juliuskrah

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Entry class for the load implementation demo
 * @author Julius Krah
 */
@SpringBootApplication(proxyBeanMethods = false)
class LoadImplementationsApplication

fun main(args: Array<String>) {
	runApplication<LoadImplementationsApplication>(*args)
}
