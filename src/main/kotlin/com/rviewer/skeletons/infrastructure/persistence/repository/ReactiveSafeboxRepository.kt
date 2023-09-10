package com.rviewer.skeletons.infrastructure.persistence.repository

import com.rviewer.skeletons.infrastructure.persistence.dao.SafeboxDao
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactiveSafeboxRepository : CoroutineCrudRepository<SafeboxDao, Long> {

    suspend fun findByNameIgnoreCase(name: String): SafeboxDao?

}