package br.com.managerfood.golden

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GoldenApplication

fun main(args: Array<String>) {
	runApplication<GoldenApplication>(*args)
}
