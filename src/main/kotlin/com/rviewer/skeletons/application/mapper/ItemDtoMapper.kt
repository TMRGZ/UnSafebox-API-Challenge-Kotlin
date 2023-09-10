package com.rviewer.skeletons.application.mapper

import com.rviewer.skeletons.application.model.SafeboxItemDto
import com.rviewer.skeletons.domain.model.Item
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ItemDtoMapper {

    fun map(safeboxItemDto: SafeboxItemDto): Item

    fun map(item: Item): SafeboxItemDto

}