package com.rviewer.skeletons.infrastructure.persistence.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("ITEM")
data class ItemDao(
    @Id @Column("_ID") private val id: Long,
    @Column("_CONTENT") private val content: String,
    @Column("SAFEBOX_ID") private val safeboxId: Long
)
