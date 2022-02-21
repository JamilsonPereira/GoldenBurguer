package br.com.managerfood.golden.usecase.category

import br.com.managerfood.golden.domain.Category
import reactor.core.publisher.Mono

interface CreateCategory {
    fun execute(category: Category): Mono<Category>
}