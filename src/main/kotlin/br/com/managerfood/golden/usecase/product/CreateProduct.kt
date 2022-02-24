package br.com.managerfood.golden.usecase.product

import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.domain.Product
import reactor.core.publisher.Mono

interface CreateProduct {
    fun execute(domain: Product): Mono<Product>
}