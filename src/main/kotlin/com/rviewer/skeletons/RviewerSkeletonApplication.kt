package com.rviewer.skeletons

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RviewerSkeletonApplication {

    fun main(args: Array<String>) {
        runApplication<RviewerSkeletonApplication>(*args)
    }
}