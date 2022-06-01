package br.com.managerfood.golden.adapter.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.annotation.Generated

@Table("manager.tb_category")
class CategoryEntity(
    @Id
    @Column("id_category")
    @Generated
    var id: Long? = null,

    @Column("name")
    var name: String? = "",

    @Column("description")
    var description: String? = "",

    @Column("date_insert")
    var dateInsert: OffsetDateTime = OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC),

    @Column("date_update")
    var dateUpdate: OffsetDateTime = OffsetDateTime.now()



)