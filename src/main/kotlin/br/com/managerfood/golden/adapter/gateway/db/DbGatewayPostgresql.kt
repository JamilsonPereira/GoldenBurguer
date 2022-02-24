package br.com.managerfood.golden.adapter.gateway.db

import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.domain.Product
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DbGatewayPostgresql {
    fun findAllCategories(): Flux<Category>
    fun createNewCategory(domain : Category): Mono<Category>
    fun createNewProduct(domain: Product): Mono<Product>
    fun findAllProducts(): Flux<Product>
}