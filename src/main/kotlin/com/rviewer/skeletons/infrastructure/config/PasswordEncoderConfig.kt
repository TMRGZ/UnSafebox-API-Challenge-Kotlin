package com.rviewer.skeletons.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
open class PasswordEncoderConfig {

    @Bean
    open fun passwordEncoder() = BCryptPasswordEncoder()

}