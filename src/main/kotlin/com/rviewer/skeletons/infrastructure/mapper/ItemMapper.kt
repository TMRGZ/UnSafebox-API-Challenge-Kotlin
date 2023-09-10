package com.rviewer.skeletons.infrastructure.mapper

import com.rviewer.skeletons.domain.model.Item
import com.rviewer.skeletons.infrastructure.persistence.dao.ItemDao
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ItemMapper {

    fun map(item: Item): ItemDao

    fun map(itemDao: ItemDao): Item

}