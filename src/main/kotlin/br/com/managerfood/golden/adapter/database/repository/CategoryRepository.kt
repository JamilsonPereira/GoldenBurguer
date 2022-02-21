package br.com.managerfood.golden.adapter.database.repository

import br.com.managerfood.golden.adapter.database.entity.CategoryEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux

@Repository
@Transactional
interface CategoryRepository: ReactiveCrudRepository<CategoryEntity, Long> {
    @Query("SELECT name, description, id FROM manager.tb_category")
    fun findAllCategories(): Flux<CategoryEntity>


}