package br.com.managerfood.golden.adapter.gateway.mapper

import br.com.managerfood.golden.adapter.database.entity.ProductEntity
import br.com.managerfood.golden.domain.Product
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ProductMapperDomainAndEntity {

    fun convertListEntityToDomain(
        product: Flux<ProductEntity>
    ): Flux<Product> {
        return product.map { productEntity ->
            Product(
                productEntity.id,
                productEntity.name!!,
                productEntity.description!!,
                productEntity.price!!,
                productEntity.idCategory

            )
        }
    }

    fun convertEntityToDomain(
        product: Mono<ProductEntity>
    ): Mono<Product> {
        return product.map { productEntity ->
            Product(
                productEntity.id,
                productEntity.name!!,
                productEntity.description!!,
                productEntity.price!!,
                productEntity.idCategory
            )
        }
    }

    fun convertDomainToEntity(
        domain: Product
    ): ProductEntity {
        return ProductEntity(
            id = null,
            name = domain.name,
            description = domain.description,
            price = domain.price,
            idCategory = domain.idCategory!!
        )

    }
}