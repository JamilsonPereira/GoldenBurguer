package br.com.managerfood.golden.usecase.product

import reactor.core.publisher.Mono

interface DeleteProduct {
    fun execute(idProduct: Long): Mono<Void>
}