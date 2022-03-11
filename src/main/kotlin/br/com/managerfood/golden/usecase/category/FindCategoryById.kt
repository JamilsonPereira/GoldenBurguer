package br.com.managerfood.golden.usecase.category

import br.com.managerfood.golden.domain.Category
import reactor.core.publisher.Mono

interface FindCategoryById {
    fun execute(id: Long): Mono<Category>
}