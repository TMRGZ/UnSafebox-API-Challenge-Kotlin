package com.rviewer.skeletons.infrastructure.persistence.repository

import com.rviewer.skeletons.infrastructure.persistence.dao.ItemDao
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactiveItemRepository : CoroutineCrudRepository<ItemDao, Long> {

    fun findBySafeboxId(safeboxId: Long): Flow<ItemDao>

}