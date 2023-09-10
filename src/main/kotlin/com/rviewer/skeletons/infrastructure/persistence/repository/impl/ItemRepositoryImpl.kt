package com.rviewer.skeletons.infrastructure.persistence.repository.impl

import com.rviewer.skeletons.domain.model.Item
import com.rviewer.skeletons.domain.repository.ItemRepository
import com.rviewer.skeletons.infrastructure.mapper.ItemMapper
import com.rviewer.skeletons.infrastructure.persistence.repository.ReactiveItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Component

@Component
class ItemRepositoryImpl(
    private val reactiveItemRepository: ReactiveItemRepository,
    private val itemMapper: ItemMapper
) : ItemRepository {
    override fun findBySafeboxId(safeboxId: Long): Flow<Item> =
        reactiveItemRepository.findBySafeboxId(safeboxId)
            .map(itemMapper::map)

    override suspend fun save(item: Item): Item =
        itemMapper.map(item)
            .run { reactiveItemRepository.save(this) }
            .run(itemMapper::map)
}