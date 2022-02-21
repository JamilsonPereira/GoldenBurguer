package br.com.managerfood.golden.adapter.controller.dto.response

import br.com.managerfood.golden.domain.Category

class ProductResponse(
    var id: Long,
    var name: String,
    var description: String,
    var price: Float,
    var category: MutableList<CategoryResponse> = mutableListOf()
)