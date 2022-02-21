package br.com.managerfood.golden.adapter.gateway.db

import br.com.managerfood.golden.adapter.database.entity.CategoryEntity
import br.com.managerfood.golden.adapter.database.repository.CategoryRepository
import br.com.managerfood.golden.adapter.gateway.mapper.CategoryMapperDomainAndEntity
import br.com.managerfood.golden.domain.Category
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class DbGatewayPostgresqlImpl constructor(
    private val categoryRepository: CategoryRepository,
    private val categoryMapperDomainAndEntity: CategoryMapperDomainAndEntity
): DbGatewayPostgresql{
    override fun findAllCategories(): Flux<CategoryEntity> {
        return  categoryRepository.findAll()
    }

    override fun createNewCategory(domain: Category): Mono<Category> {
        return Mono
            .just(domain)
            .flatMap {
                var entity = categoryMapperDomainAndEntity.convertDomainToEntity(it)
                categoryMapperDomainAndEntity.convertEntityToDomain(categoryRepository.save(entity))
            }
    }
}