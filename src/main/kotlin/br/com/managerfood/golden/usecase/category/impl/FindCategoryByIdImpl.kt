package br.com.managerfood.golden.usecase.category.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresql
import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.usecase.category.FindCategoryById
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FindCategoryByIdImpl constructor(
    private val dbGatewayPostgresql: DbGatewayPostgresql
): FindCategoryById {
    override fun execute(id: Long): Mono<Category> {
        return Mono.just(id)
            .flatMap {
                dbGatewayPostgresql.findCategoryById(it)
            }

    }
}