package br.com.managerfood.golden.usecase.product.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresql
import br.com.managerfood.golden.domain.Product
import br.com.managerfood.golden.usecase.product.FindProductById
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FindProductByIdImpl constructor(
    private val dbGatewayPostgresql: DbGatewayPostgresql
): FindProductById {
    override fun execute(idProduct: Long): Mono<Product> {
        return Mono.just(idProduct)
            .flatMap {
              dbGatewayPostgresql.findProductById(it)
            }
    }
}