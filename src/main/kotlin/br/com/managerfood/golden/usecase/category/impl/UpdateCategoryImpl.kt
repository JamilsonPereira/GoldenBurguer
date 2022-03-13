package br.com.managerfood.golden.usecase.category.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresql
import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.usecase.category.UpdateCategory
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UpdateCategoryImpl(
    private val dbGatewayPostgresql: DbGatewayPostgresql
): UpdateCategory {
    override fun execute(idCategory: Long, domain: Category): Mono<Category> {
        return Mono.just(idCategory)
            .flatMap {
                dbGatewayPostgresql.findCategoryById(it).switchIfEmpty(
                    Mono.error(NotFoundException()))
                    .flatMap { categorySaved ->
                        categorySaved.name = domain.name
                        categorySaved.description = domain.description

                        dbGatewayPostgresql.updateCategory(categorySaved)
                    }
            }
    }
}