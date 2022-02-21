package br.com.managerfood.golden.adapter.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import javax.annotation.Generated

@Table("manager.tb_category")
class CategoryEntity(
    @Id
    @Column("id")
    @Generated
    var id: Long? = null,

    @Column("name")
    var name: String? = "",

    @Column("description")
    var description: String? = ""

)