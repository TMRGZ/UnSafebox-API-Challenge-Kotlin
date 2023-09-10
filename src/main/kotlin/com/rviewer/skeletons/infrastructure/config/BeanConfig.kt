package com.rviewer.skeletons.infrastructure.config

import com.rviewer.skeletons.domain.repository.ItemRepository
import com.rviewer.skeletons.domain.repository.SafeboxRepository
import com.rviewer.skeletons.domain.service.PasswordManager
import com.rviewer.skeletons.domain.service.SafeboxService
import com.rviewer.skeletons.domain.service.impl.ItemServiceImpl
import com.rviewer.skeletons.domain.service.impl.SafeboxServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BeanConfig {

    @Bean
    open fun safeboxService(safeboxRepository: SafeboxRepository, passwordManager: PasswordManager) =
        SafeboxServiceImpl(safeboxRepository, passwordManager)

    @Bean
    open fun itemService(itemRepository: ItemRepository, safeboxService: SafeboxService) =
        ItemServiceImpl(itemRepository, safeboxService)

}