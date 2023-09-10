package com.rviewer.skeletons.infrastructure.controller.impl

import com.rviewer.skeletons.application.model.CreatedSafeboxResponseDto
import com.rviewer.skeletons.application.model.SafeboxItemDto
import com.rviewer.skeletons.application.model.SafeboxRequestDto
import com.rviewer.skeletons.application.service.ItemApplicationService
import com.rviewer.skeletons.application.service.SafeboxApplicationService
import com.rviewer.skeletons.infrastructure.controller.SafeboxApi
import kotlinx.coroutines.flow.Flow
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class SafeboxApiController(
    private val safeboxApplicationService: SafeboxApplicationService,
    private val itemApplicationService: ItemApplicationService
) : SafeboxApi {
    override suspend fun createSafebox(safeboxRequestDto: SafeboxRequestDto): ResponseEntity<CreatedSafeboxResponseDto> =
        safeboxApplicationService.createSafebox(safeboxRequestDto)

    override fun getSafeboxItems(id: Long): ResponseEntity<Flow<SafeboxItemDto>> =
        itemApplicationService.getSafeboxItems(id)

    override suspend fun saveSafeboxItems(id: Long, safeboxItemDto: Flow<SafeboxItemDto>): ResponseEntity<Unit> =
        itemApplicationService.saveSafeboxItems(id, safeboxItemDto)
}