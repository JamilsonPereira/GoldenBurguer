package br.com.managerfood.golden.adapter.controller.dto.response

import java.time.LocalDate

class OrderResponse(
    var id: Long,
    var dataPedido: LocalDate,
    var quantity: Long,
    var price: Float
)