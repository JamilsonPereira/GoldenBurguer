package br.com.managerfood.golden.domain

import java.math.BigDecimal

class Product(

    var id: Long? = null,
    var name: String,
    var description: String? ="",
    var price: BigDecimal? = BigDecimal.ZERO,
    var idCategory: Long? = 0
)