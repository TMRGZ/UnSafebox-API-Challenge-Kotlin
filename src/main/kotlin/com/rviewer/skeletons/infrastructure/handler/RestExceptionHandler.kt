package com.rviewer.skeletons.infrastructure.handler

import com.rviewer.skeletons.domain.exception.SafeboxAlreadyExistsException
import com.rviewer.skeletons.domain.exception.SafeboxDoesNotExistException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(SafeboxDoesNotExistException::class)
    fun safeboxNotFound() = ResponseEntity.notFound().build<Unit>()

    @ExceptionHandler(SafeboxAlreadyExistsException::class)
    fun safeboxAlreadyExists() = ResponseEntity.status(HttpStatus.CONFLICT).build<Unit>()

}