package br.com.managerfood.golden.domain

import java.math.BigDecimal

class Product(

    var id: Long? = 0,
    var name: String? = null,
    var description: String? ="",
    var price: BigDecimal? = BigDecimal.ZERO,
    var idCategory: Long? = 0
)