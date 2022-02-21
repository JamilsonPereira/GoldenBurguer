package br.com.managerfood.golden.adapter.controller.dto.request

import br.com.managerfood.golden.adapter.controller.dto.response.CategoryResponse

class ProductRequest(
    var name: String,
    var description: String,
    var price: Float,
    var category: MutableList<CategoryResponse> = mutableListOf()
)