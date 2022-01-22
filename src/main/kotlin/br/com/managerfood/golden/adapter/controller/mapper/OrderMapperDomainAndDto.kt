package br.com.managerfood.golden.adapter.controller.mapper

import br.com.managerfood.golden.adapter.controller.dto.request.OrderRequest
import br.com.managerfood.golden.adapter.controller.dto.response.OrderResponse
import br.com.managerfood.golden.domain.Order
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate

class OrderMapperDomainAndDto {

    fun convertListDomainToResponse(
        domain: Flux<Order>
    ): Flux<OrderResponse> {
        return domain.map {
            OrderResponse(
                it.id!!,
                it.dateOrder!!,
                it.quantity!!,
                it.price!!
            )
        }
    }

    fun convertDomainToResponse(
        domain: Mono<Order>
    ): Mono<OrderResponse> {
        return domain.map { order ->
            OrderResponse(
                order.id!!,
                order.dateOrder!!,
                order.quantity!!,
                order.price!!
            )
        }
    }

    fun convertRequestToDomain(requestOrder: OrderRequest): Order {
        return Order(
            null,
            LocalDate.now(),
            requestOrder.quantity,
            requestOrder.price
        )
    }

}