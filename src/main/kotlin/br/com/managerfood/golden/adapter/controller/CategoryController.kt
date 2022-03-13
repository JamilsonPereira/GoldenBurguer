package br.com.managerfood.golden.adapter.controller

import br.com.managerfood.golden.adapter.controller.dto.request.CategoryRequest
import br.com.managerfood.golden.adapter.controller.dto.response.CategoryResponse
import br.com.managerfood.golden.adapter.controller.mapper.CategoryMapperDomainAndDto
import br.com.managerfood.golden.adapter.database.entity.CategoryEntity
import br.com.managerfood.golden.adapter.database.repository.CategoryRepository
import br.com.managerfood.golden.usecase.category.CreateCategory
import br.com.managerfood.golden.usecase.category.DeleteCategory
import br.com.managerfood.golden.usecase.category.UpdateCategory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryRepository: CategoryRepository,
    private val categoryMapperDomainAndDto: CategoryMapperDomainAndDto,
    private val createCategory: CreateCategory,
    private val updateCategory: UpdateCategory,
    private val deleteCategory: DeleteCategory

) {
    @GetMapping
    fun listAll(): Flux<CategoryEntity>{
        return categoryRepository.findAllCategories()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): Mono<CategoryEntity>{
        return categoryRepository.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCategory(@RequestBody request : CategoryRequest): Mono<CategoryResponse>{
        return Mono.just(request)
            .flatMap {
                categoryMapperDomainAndDto.convertDomainToResponse(
                    createCategory.execute(categoryMapperDomainAndDto.convertRequestToDomain(it) )
                )
            }
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCategory(
        @PathVariable("id") idCategory: Long,
        @RequestBody request: CategoryRequest): Mono<CategoryResponse>{
        return Mono.just(request)
            .flatMap {
                categoryMapperDomainAndDto.convertDomainToResponse(
                    updateCategory.execute(idCategory, categoryMapperDomainAndDto.convertRequestToDomain(it))
                )
            }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(
        @PathVariable("id") idCategory: Long,
    ):Mono<Void>{
       return deleteCategory.execute(idCategory)
    }
}