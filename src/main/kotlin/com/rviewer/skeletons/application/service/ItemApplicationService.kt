package com.rviewer.skeletons.application.service

import com.rviewer.skeletons.application.model.SafeboxItemDto
import kotlinx.coroutines.flow.Flow
import org.springframework.http.ResponseEntity

interface ItemApplicationService {

    fun getSafeboxItems(id: Long): ResponseEntity<Flow<SafeboxItemDto>>

    fun saveSafeboxItems(id: Long, safeboxItemDto: Flow<SafeboxItemDto>): ResponseEntity<Unit>

}