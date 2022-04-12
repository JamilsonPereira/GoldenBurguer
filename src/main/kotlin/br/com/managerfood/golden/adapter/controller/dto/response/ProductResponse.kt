package br.com.managerfood.golden.adapter.controller.dto.response

import br.com.managerfood.golden.domain.Category
import java.math.BigDecimal

class ProductResponse(
    var id: Long,
    var name: String,
    var description: String,
    var price: BigDecimal,
    var category: MutableList<CategoryResponse> = mutableListOf()
)