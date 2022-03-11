package br.com.managerfood.golden.usecase.category.impl

import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.usecase.category.UpdateCategory
import reactor.core.publisher.Mono

class UpdateCategoryImpl(): UpdateCategory {
    override fun execute(idCategory: Long, domain: Category): Mono<Category> {
        TODO("Not yet implemented")
    }
}