package com.rviewer.skeletons.domain.repository

import com.rviewer.skeletons.domain.model.Safebox

interface SafeboxRepository {

    suspend fun findById(id: Long): Safebox?

    suspend fun findByNameIgnoreCase(name: String): Safebox?

    suspend fun save(safebox: Safebox): Safebox?

}