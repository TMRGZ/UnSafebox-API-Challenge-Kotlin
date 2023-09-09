package com.rviewer.skeletons.domain.service.impl

import com.rviewer.skeletons.domain.exception.SafeboxAlreadyExistsException
import com.rviewer.skeletons.domain.model.Safebox
import com.rviewer.skeletons.domain.repository.SafeboxRepository
import com.rviewer.skeletons.domain.service.PasswordManager
import com.rviewer.skeletons.domain.service.SafeboxService

class SafeboxServiceImpl(
    private val safeboxRepository: SafeboxRepository,
    private val passwordManager: PasswordManager
) : SafeboxService {

    override suspend fun createSafebox(safeboxName: String, safeboxPassword: String): Safebox? =
        getSafebox(safeboxName)?.let {
            throw SafeboxAlreadyExistsException()
        } ?: safeboxRepository.save(generateEncodedSafebox(safeboxName, safeboxPassword))


    private fun generateEncodedSafebox(safeboxName: String, safeboxPassword: String): Safebox =
        Safebox(name = safeboxName, password = passwordManager.encode(safeboxPassword))

    override suspend fun getSafebox(id: Long): Safebox? = safeboxRepository.findById(id)

    override suspend fun getSafebox(name: String): Safebox? = safeboxRepository.findByNameIgnoreCase(name)
}