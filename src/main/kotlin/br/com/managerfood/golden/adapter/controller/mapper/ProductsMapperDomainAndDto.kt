package br.com.managerfood.golden.adapter.controller.mapper

import br.com.managerfood.golden.adapter.controller.dto.request.ProductRequest
import br.com.managerfood.golden.adapter.controller.dto.response.ProductResponse
import br.com.managerfood.golden.domain.Product
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class ProductsMapperDomainAndDto {

    fun convertListDomainToResponse(domain: Flux<Product>): Flux<ProductResponse> {
        return domain.map { products ->
            ProductResponse(
                products.id!!,
                products.name,
                products.description,
                products.price,
                mutableListOf()
            )
        }
    }

    fun convertDomainToResponse(domain: Mono<Product>): Mono<ProductResponse> {
        return domain.map { products ->
            ProductResponse(
                products.id!!,
                products.name,
                products.description,
                products.price,
                mutableListOf()

            )

        }
    }

    fun convertRequestToDomain(requestProducts: ProductRequest): Product {
        return Product(
            null,
            requestProducts.name,
            requestProducts.description,
            requestProducts.price,
            mutableListOf()
        )
    }

}