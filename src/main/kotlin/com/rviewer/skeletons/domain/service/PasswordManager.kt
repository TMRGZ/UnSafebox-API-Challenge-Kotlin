package com.rviewer.skeletons.domain.service

interface PasswordManager {

    fun encode(password: String): String

    fun matches(plainPassword: String, encodedPassword: String): Boolean

}