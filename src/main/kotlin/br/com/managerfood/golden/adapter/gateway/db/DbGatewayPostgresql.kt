package br.com.managerfood.golden.adapter.gateway.db

import br.com.managerfood.golden.adapter.database.entity.CategoryEntity
import br.com.managerfood.golden.domain.Category
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DbGatewayPostgresql {
    fun findAllCategories(): Flux<CategoryEntity>
    fun createNewCategory(domain : Category): Mono<Category>
}