package br.com.managerfood.golden.usecase.category

import reactor.core.publisher.Mono

interface DeleteCategory {
    fun execute(idCategory: Long): Mono<Void>
}