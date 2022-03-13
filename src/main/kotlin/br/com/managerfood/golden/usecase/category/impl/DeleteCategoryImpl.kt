package br.com.managerfood.golden.usecase.category.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresql
import br.com.managerfood.golden.usecase.category.DeleteCategory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DeleteCategoryImpl (
    private val dbGatewayPostgresql: DbGatewayPostgresql
        ): DeleteCategory {
    override fun execute(idCategory: Long): Mono<Void> {
       return dbGatewayPostgresql.deleteCategory(idCategory)
    }
}