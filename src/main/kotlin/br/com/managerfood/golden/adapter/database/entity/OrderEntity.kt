package br.com.managerfood.golden.adapter.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("manager.tb_order")
class OrderEntity(

    @Id
    @Column("id_order")
    var id: Long,

    @Column("date_order")
    var dateOrder: LocalDate,

    @Column("quantity")
    var quantity: Long,

    @Column("price")
    var price: Float
)
