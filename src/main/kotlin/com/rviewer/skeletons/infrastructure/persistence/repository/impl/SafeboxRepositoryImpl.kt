package com.rviewer.skeletons.infrastructure.persistence.repository.impl

import com.rviewer.skeletons.domain.model.Safebox
import com.rviewer.skeletons.domain.repository.SafeboxRepository
import com.rviewer.skeletons.infrastructure.mapper.SafeboxMapper
import com.rviewer.skeletons.infrastructure.persistence.repository.ReactiveSafeboxRepository
import org.springframework.stereotype.Component

@Component
class SafeboxRepositoryImpl(
    private val reactiveSafeboxRepository: ReactiveSafeboxRepository,
    private val safeboxMapper: SafeboxMapper
) : SafeboxRepository {
    override suspend fun findById(id: Long): Safebox? =
        reactiveSafeboxRepository.findById(id)?.run(safeboxMapper::map)

    override suspend fun findByNameIgnoreCase(name: String): Safebox? =
        reactiveSafeboxRepository.findByNameIgnoreCase(name)?.run(safeboxMapper::map)

    override suspend fun save(safebox: Safebox): Safebox =
        safeboxMapper.map(safebox)
            .run { reactiveSafeboxRepository.save(this) }
            .run(safeboxMapper::map)
}