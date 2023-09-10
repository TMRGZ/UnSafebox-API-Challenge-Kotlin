package com.rviewer.skeletons.application.service.impl

import com.rviewer.skeletons.application.model.CreatedSafeboxResponseDto
import com.rviewer.skeletons.application.model.SafeboxRequestDto
import com.rviewer.skeletons.application.service.SafeboxApplicationService
import com.rviewer.skeletons.domain.service.SafeboxService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class SafeboxApplicationServiceImpl(
    private val safeboxService: SafeboxService
) : SafeboxApplicationService {
    override suspend fun createSafebox(safeboxRequestDto: SafeboxRequestDto): ResponseEntity<CreatedSafeboxResponseDto> =
        safeboxService.createSafebox(safeboxRequestDto.name, safeboxRequestDto.password)
            ?.run { this.id }
            ?.run { CreatedSafeboxResponseDto(id = this) }
            .run { ResponseEntity.status(HttpStatus.CREATED).body(this) }

}