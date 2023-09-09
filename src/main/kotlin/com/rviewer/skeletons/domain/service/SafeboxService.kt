package com.rviewer.skeletons.domain.service

import com.rviewer.skeletons.domain.model.Safebox

interface SafeboxService {

    suspend fun createSafebox(safeboxName: String, safeboxPassword: String): Safebox?

    suspend fun getSafebox(id: Long): Safebox?

    suspend fun getSafebox(name: String): Safebox?

}