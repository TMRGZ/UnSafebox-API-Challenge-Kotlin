package com.rviewer.skeletons.infrastructure.service.impl

import com.rviewer.skeletons.domain.service.PasswordManager
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class PasswordManagerImpl(
    private val passwordEncoder: PasswordEncoder
) : PasswordManager {
    override fun encode(password: String): String =
        passwordEncoder.encode(password)

    override fun matches(plainPassword: String, encodedPassword: String): Boolean =
        passwordEncoder.matches(plainPassword, encodedPassword)
}