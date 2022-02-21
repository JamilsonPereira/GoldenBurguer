package br.com.managerfood.golden.adapter.controller.mapper

import br.com.managerfood.golden.adapter.controller.dto.request.CategoryRequest
import br.com.managerfood.golden.adapter.controller.dto.response.CategoryResponse
import br.com.managerfood.golden.domain.Category
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.annotation.Generated

@Component
class CategoryMapperDomainAndDto {

    fun convertListDomainToResponse(
        category: Flux<Category>
    ): Flux<CategoryResponse> {
        return category.map {
            CategoryResponse(
                it.id,
                it.name,
                it.description
            )
        }

    }

    fun convertDomainToResponse(
        category: Mono<Category>
    ): Mono<CategoryResponse> {
        return category.map {
            CategoryResponse(
                it.id,
                it.name,
                it.description
            )
        }
    }
    fun convertRequestToDomain(
        categoryRequest: CategoryRequest
    ): Category{
        return Category(
            null,
            categoryRequest.name,
            categoryRequest.description
        )
    }
}