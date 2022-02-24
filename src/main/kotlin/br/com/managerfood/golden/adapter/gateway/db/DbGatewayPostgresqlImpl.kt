package br.com.managerfood.golden.adapter.gateway.db

import br.com.managerfood.golden.adapter.database.repository.CategoryRepository
import br.com.managerfood.golden.adapter.gateway.mapper.CategoryMapperDomainAndEntity
import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.domain.Product
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class DbGatewayPostgresqlImpl constructor(
    private val categoryRepository: CategoryRepository,
    private val categoryMapperDomainAndEntity: CategoryMapperDomainAndEntity,

): DbGatewayPostgresql{
    override fun findAllCategories(): Flux<Category> {
        return categoryMapperDomainAndEntity.convertListEntityToDomain(categoryRepository.findAll())

    }

    override fun createNewCategory(domain: Category): Mono<Category> {
        return Mono
            .just(domain)
            .flatMap {
                var entity = categoryMapperDomainAndEntity.convertDomainToEntity(it)
                categoryMapperDomainAndEntity.convertEntityToDomain(categoryRepository.save(entity))
            }
    }

    override fun createNewProduct(domain: Product): Mono<Product> {
        return TODO("Not yet implemented")
    }

    override fun findAllProducts(): Flux<Product> {
        TODO("Not yet implemented")
    }
}