package br.com.managerfood.golden.usecase.product.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresql
import br.com.managerfood.golden.usecase.product.DeleteProduct
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DeleteProductImpl(
    private val dbGatewayPostgresql: DbGatewayPostgresql
): DeleteProduct {
    override fun execute(idProduct: Long): Mono<Void> {
        return dbGatewayPostgresql.deleteProduct(idProduct)
    }

}