package br.com.managerfood.golden.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

class Category(
    var id: Long? = null,
    var name: String? = "",
    var description: String? = ""
)