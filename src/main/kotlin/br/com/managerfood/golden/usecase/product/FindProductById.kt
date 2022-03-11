package br.com.managerfood.golden.usecase.product

import br.com.managerfood.golden.domain.Product
import reactor.core.publisher.Mono

interface FindProductById {
    fun execute(idProduct: Long): Mono<Product>
}