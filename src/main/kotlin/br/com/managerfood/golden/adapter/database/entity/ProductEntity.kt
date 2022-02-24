package br.com.managerfood.golden.adapter.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("manager.tb_products")
class ProductEntity(
    @Id
    @Column("id_products")
    var id: Long,

    @Column("name")
    var name: String,

    @Column("description")
    var description: String,

    @Column("price")
    var price: Float
)