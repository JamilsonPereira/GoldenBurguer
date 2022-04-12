package br.com.managerfood.golden.adapter.gateway.db

import br.com.managerfood.golden.adapter.database.repository.CategoryRepository
import br.com.managerfood.golden.adapter.database.repository.ProductRepository
import br.com.managerfood.golden.adapter.gateway.mapper.CategoryMapperDomainAndEntity
import br.com.managerfood.golden.adapter.gateway.mapper.ProductMapperDomainAndEntity
import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.domain.Product
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Component
class DbGatewayPostgresqlImpl constructor(
    private val categoryRepository: CategoryRepository,
    private val categoryMapperDomainAndEntity: CategoryMapperDomainAndEntity,
    private val productMapperDomainAndEntity: ProductMapperDomainAndEntity,
    private val productRepository: ProductRepository

) : DbGatewayPostgresql {
    override fun findAllCategories(): Flux<Category> {
        return categoryMapperDomainAndEntity.convertListEntityToDomain(
            categoryRepository.findAll()
        )

    }

    override fun findCategoryById(idCategory: Long): Mono<Category> {
        return categoryMapperDomainAndEntity.convertEntityToDomain(
            categoryRepository.findById(idCategory)
        )

    }

    override fun updateCategory(category: Category): Mono<Category> {
        return Mono.just(category).flatMap {
            categoryMapperDomainAndEntity.convertEntityToDomain(
                categoryRepository.save(
                    categoryMapperDomainAndEntity.convertDomainToEntity(it)
                )
            )
        }
    }

    override fun deleteCategory(idCategory: Long): Mono<Void> {
        return categoryRepository.deleteById(idCategory)
    }

    override fun createNewCategory(domain: Category): Mono<Category> {
        return Mono.just(domain).flatMap {
            var entity = categoryMapperDomainAndEntity.convertDomainToEntity(it)
            categoryMapperDomainAndEntity.convertEntityToDomain(categoryRepository.save(entity))
        }
    }

    override fun createNewProduct(domain: Product): Mono<Product> {
        return Mono.just(domain).flatMap {
            productMapperDomainAndEntity.convertEntityToDomain(
                productRepository.save(productMapperDomainAndEntity.convertDomainToEntity(it))
            )

        }
    }


    override fun findAllProducts(): Flux<Product> {
        return productMapperDomainAndEntity.convertListEntityToDomain(
            productRepository.findAllProducts()
        )
    }

    override fun findProductById(idProduct: Long): Mono<Product> {
        return productMapperDomainAndEntity.convertEntityToDomain(productRepository.findById(idProduct))
    }

    override fun updateProduct(product: Product): Mono<Product> {

        return Mono.just(product).flatMap {
            productMapperDomainAndEntity.convertEntityToDomain(
                productRepository.save(
                    productMapperDomainAndEntity.convertDomainToEntity(it)
                )
            )
        }
    }

    override fun deleteProduct(idProduct: Long): Mono<Void> {
        return productRepository.deleteById(idProduct)
    }
}