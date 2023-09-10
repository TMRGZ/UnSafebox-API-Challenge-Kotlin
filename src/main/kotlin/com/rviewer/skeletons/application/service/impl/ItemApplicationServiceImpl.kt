package com.rviewer.skeletons.application.service.impl

import com.rviewer.skeletons.application.mapper.ItemDtoMapper
import com.rviewer.skeletons.application.model.SafeboxItemDto
import com.rviewer.skeletons.application.service.ItemApplicationService
import com.rviewer.skeletons.domain.service.ItemService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ItemApplicationServiceImpl(
    private val itemService: ItemService,
    private val itemDtoMapper: ItemDtoMapper
) : ItemApplicationService {
    override fun getSafeboxItems(id: Long): ResponseEntity<Flow<SafeboxItemDto>> =
        itemService.getItems(id)
            .map(itemDtoMapper::map)
            .run { ResponseEntity.ok(this) }

    override fun saveSafeboxItems(id: Long, safeboxItemDto: Flow<SafeboxItemDto>): ResponseEntity<Unit> {
        safeboxItemDto.map(itemDtoMapper::map).map { itemService.save(id, it) }
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}