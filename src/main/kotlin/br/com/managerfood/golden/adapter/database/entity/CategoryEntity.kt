package br.com.managerfood.golden.adapter.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("golden.tb_category")
class CategoryEntity(
    @Id
    @Column("id_category")
    var id: Long,

    @Column("name")
    var name: String,

    @Column("description")
    var description: String

)