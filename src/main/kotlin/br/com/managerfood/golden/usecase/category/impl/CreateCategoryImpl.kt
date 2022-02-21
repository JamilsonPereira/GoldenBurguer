package br.com.managerfood.golden.usecase.category.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresqlImpl
import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.usecase.category.CreateCategory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateCategoryImpl constructor(
    private val dbGatewayPostgresql: DbGatewayPostgresqlImpl
): CreateCategory {
    override fun execute(category: Category): Mono<Category> {
        return Mono.just(category).flatMap {
            dbGatewayPostgresql.createNewCategory(it)
        }
    }
}