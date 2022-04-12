package br.com.managerfood.golden.adapter.controller.dto.request

import java.math.BigDecimal

class ProductRequest(
    var name: String? = "",
    var description: String? = "",
    var price: BigDecimal? = BigDecimal.ZERO,
    var idCategory: Long? = null
)