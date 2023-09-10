package com.rviewer.skeletons.infrastructure.mapper

import com.rviewer.skeletons.domain.model.Safebox
import com.rviewer.skeletons.infrastructure.persistence.dao.SafeboxDao
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface SafeboxMapper {

    fun map(safebox: Safebox): SafeboxDao

    fun map(safeboxDao: SafeboxDao): Safebox

}