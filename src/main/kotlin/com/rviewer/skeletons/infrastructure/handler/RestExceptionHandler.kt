package com.rviewer.skeletons.infrastructure.handler

import com.rviewer.skeletons.domain.exception.SafeboxAlreadyExistsException
import com.rviewer.skeletons.domain.exception.SafeboxDoesNotExistException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler
    fun safeboxNotFound(exception: SafeboxDoesNotExistException) =
        ResponseEntity.notFound().build<Unit>()

    @ExceptionHandler
    fun safeboxAlreadyExists(exception: SafeboxAlreadyExistsException) =
        ResponseEntity.status(HttpStatus.CONFLICT).build<Unit>()

}