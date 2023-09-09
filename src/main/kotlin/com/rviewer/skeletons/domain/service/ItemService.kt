package com.rviewer.skeletons.domain.service

import com.rviewer.skeletons.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemService {

    fun getItems(safeboxId: Long): Flow<Item>

    suspend fun save(safeboxId: Long, item: Item): Item?

}