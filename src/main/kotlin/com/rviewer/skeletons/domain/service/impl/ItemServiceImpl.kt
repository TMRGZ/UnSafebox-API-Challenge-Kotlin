package com.rviewer.skeletons.domain.service.impl

import com.rviewer.skeletons.domain.exception.SafeboxDoesNotExistException
import com.rviewer.skeletons.domain.model.Item
import com.rviewer.skeletons.domain.repository.ItemRepository
import com.rviewer.skeletons.domain.service.ItemService
import com.rviewer.skeletons.domain.service.SafeboxService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemServiceImpl(
    private val itemRepository: ItemRepository,
    private val safeboxService: SafeboxService
) : ItemService {

    override fun getItems(safeboxId: Long): Flow<Item> = flow {
        safeboxService.getSafebox(safeboxId)?.let {
            itemRepository.findBySafeboxId(safeboxId)
        } ?: throw SafeboxDoesNotExistException()
    }

    override suspend fun save(safeboxId: Long, item: Item): Item =
        safeboxService.getSafebox(safeboxId)?.let {
            itemRepository.save(item.copy(safeboxId = it.id))
        } ?: throw SafeboxDoesNotExistException()
}