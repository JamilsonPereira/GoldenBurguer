package br.com.managerfood.golden.usecase.category

import br.com.managerfood.golden.domain.Category
import reactor.core.publisher.Mono

interface UpdateCategory {
    fun execute(idCategory: Long,  domain: Category): Mono<Category>
}