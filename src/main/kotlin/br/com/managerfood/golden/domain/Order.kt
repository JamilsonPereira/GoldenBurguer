package br.com.managerfood.golden.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDate

class Order(
    var id: Long? = null,
    var dateOrder: LocalDate? = null,
    var quantity: Long? = null,
    var price: Float? = null
)