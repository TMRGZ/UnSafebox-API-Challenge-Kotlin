package com.rviewer.skeletons.application.service

import com.rviewer.skeletons.application.model.CreatedSafeboxResponseDto
import com.rviewer.skeletons.application.model.SafeboxRequestDto
import org.springframework.http.ResponseEntity

fun interface SafeboxApplicationService {

    suspend fun createSafebox(safeboxRequestDto: SafeboxRequestDto): ResponseEntity<CreatedSafeboxResponseDto>

}