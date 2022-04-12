package br.com.managerfood.golden.usecase.product.impl

import br.com.managerfood.golden.adapter.gateway.db.DbGatewayPostgresql
import br.com.managerfood.golden.domain.Product
import br.com.managerfood.golden.usecase.product.UpdateProduct
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UpdateProductImpl(
    private val dbGatewayPostgresql: DbGatewayPostgresql
): UpdateProduct {
    override fun execute(idProduct: Long, domain: Product): Mono<Product> {
        return Mono.just(idProduct)
            .flatMap {
                dbGatewayPostgresql.findProductById(it)
                    .switchIfEmpty(Mono.error(NotFoundException()))
                    .flatMap {  productSaved ->
                        productSaved.idCategory = domain.idCategory
                        productSaved.price = domain.price
                        productSaved.name = domain.name
                        productSaved.description = domain.description

                        dbGatewayPostgresql.updateProduct(productSaved)
                    }
            }
    }
}