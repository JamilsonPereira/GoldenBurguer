package br.com.managerfood.golden.adapter.controller

import br.com.managerfood.golden.adapter.controller.dto.request.CategoryRequest
import br.com.managerfood.golden.adapter.controller.dto.request.ProductRequest
import br.com.managerfood.golden.adapter.controller.dto.response.CategoryResponse
import br.com.managerfood.golden.adapter.controller.dto.response.ProductResponse
import br.com.managerfood.golden.adapter.controller.mapper.ProductMapperDomainAndDto
import br.com.managerfood.golden.adapter.database.entity.ProductEntity
import br.com.managerfood.golden.adapter.database.repository.ProductRepository
import br.com.managerfood.golden.usecase.product.CreateProduct
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/products")
class ProductController(
    private val productRepository: ProductRepository,
    private val productMapperDomainAndDto: ProductMapperDomainAndDto,
    private val createProduct: CreateProduct

) {
    @GetMapping
    fun listAll(): Flux<ProductEntity>{
        return productRepository.findAllProducts()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): Mono<ProductEntity>{
        return productRepository.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCategory(@RequestBody request : ProductRequest): Mono<ProductResponse>{
        return Mono.just(request)
            .flatMap {
                productMapperDomainAndDto.convertDomainToResponse(
                    createProduct.execute(productMapperDomainAndDto.convertRequestToDomain(it) )
                )
            }
    }

}