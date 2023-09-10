package com.rviewer.skeletons.infrastructure.persistence.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("SAFEBOX")
data class SafeboxDao(
    @Id @Column("_ID") private val id: Long,
    @Column("_NAME") private val name: String,
    @Column("_PASSWORD") private val password: String
)
