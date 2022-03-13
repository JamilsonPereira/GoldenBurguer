package br.com.managerfood.golden.usecase.product

import br.com.managerfood.golden.domain.Product
import reactor.core.publisher.Mono

interface UpdateProduct {
    fun execute(idProduct: Long, domain: Product): Mono<Product>
}