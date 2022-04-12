package br.com.managerfood.golden.adapter.gateway.mapper

import br.com.managerfood.golden.adapter.database.entity.CategoryEntity
import br.com.managerfood.golden.domain.Category
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CategoryMapperDomainAndEntity {

    fun convertListEntityToDomain(
        category: Flux<CategoryEntity>
    ): Flux<Category>{
        return category.map { categoryEntity ->
            Category(
                categoryEntity.id,
                categoryEntity.name,
                categoryEntity.description
            )
        }
    }

    fun convertEntityToDomain(
        category: Mono<CategoryEntity>
    ): Mono<Category>{
        return  category.map {  categoryEntity ->
            Category(
                categoryEntity.id,
                categoryEntity.name,
                categoryEntity.description
            )
        }
    }

    fun convertDomainToEntity(
        domain: Category
    ): CategoryEntity{
        return CategoryEntity(
            null,
            domain.name!!,
            domain.description!!,

        )
    }
}