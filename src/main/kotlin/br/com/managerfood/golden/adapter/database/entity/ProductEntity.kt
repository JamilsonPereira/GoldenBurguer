package br.com.managerfood.golden.adapter.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("manager.tb_product")
class ProductEntity(
    @Id
    @Column("id_product")
    var id: Long? = null,

    @Column("name")
    var name: String? = "",

    @Column("description")
    var description: String? = "",

    @Column("price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column("idCategory")
    var idCategory: Long? = null
)