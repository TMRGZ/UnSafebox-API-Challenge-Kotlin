package com.rviewer.skeletons.domain.repository

import com.rviewer.skeletons.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun findBySafeboxId(safeboxId: Long): Flow<Item>

    suspend fun save(item: Item): Item?

}