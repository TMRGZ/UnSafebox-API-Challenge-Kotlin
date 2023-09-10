package com.rviewer.skeletons.infrastructure.persistence.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("ITEM")
data class ItemDao(
    @Id @Column("_ID") val id: Long,
    @Column("_CONTENT") val content: String,
    @Column("SAFEBOX_ID") val safeboxId: Long
)
