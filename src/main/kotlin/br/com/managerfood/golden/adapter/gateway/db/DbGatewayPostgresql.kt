package br.com.managerfood.golden.adapter.gateway.db

import br.com.managerfood.golden.domain.Category
import br.com.managerfood.golden.domain.Product
import org.springframework.data.relational.core.sql.Update
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DbGatewayPostgresql {
    fun findAllCategories(): Flux<Category>
    fun findCategoryById(idCategory: Long): Mono<Category>
    fun updateCategory(category: Category): Mono<Category>
    fun deleteCategory(idCategory: Long): Mono<Void>
    fun createNewCategory(domain : Category): Mono<Category>
    fun createNewProduct(domain: Product): Mono<Product>
    fun findAllProducts(): Flux<Product>
    fun findProductById(idProduct: Long): Mono<Product>
    fun updateProduct(product: Product) : Mono<Product>
    fun deleteProduct(idProduct: Long): Mono<Void>
}