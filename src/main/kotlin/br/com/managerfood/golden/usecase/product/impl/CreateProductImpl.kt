package br.com.managerfood.golden.usecase.product.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresqlImpl
import br.com.managerfood.golden.domain.Product
import br.com.managerfood.golden.usecase.product.CreateProduct
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateProductImpl constructor(
    private val dbGatewayPostgresql: DbGatewayPostgresqlImpl
) : CreateProduct {
    override fun execute(domain: Product): Mono<Product> {
        return Mono.just(domain).flatMap {
            dbGatewayPostgresql.createNewProduct(it)
        }
    }
}