package br.com.managerfood.golden.adapter.database.repository

import br.com.managerfood.golden.adapter.database.entity.CategoryEntity
import br.com.managerfood.golden.adapter.database.entity.ProductEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
@Transactional
interface ProductRepository: ReactiveCrudRepository<ProductEntity, Long> {
    @Query("SELECT name, description, id FROM manager.tb_product")
    fun findAllProducts(): Flux<ProductEntity>

    @Query("SELECT * FROM \"manager\".tb_product tc WHERE (tc.id = :id")
    fun findCategoryById(
        @Param("id") idProduct: Long
    ): Mono<ProductEntity>

}