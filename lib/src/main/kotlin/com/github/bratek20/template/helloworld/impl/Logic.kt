package com.github.bratek20.template.helloworld.impl

import com.github.bratek20.logs.api.Logger
import com.github.bratek20.template.helloworld.api.*

class HelloWorldApiLogic(
    private val logger: Logger
): HelloWorldApi {
    override fun sayHello(): String {
        val message = "Hello World!"
        logger.info(message, this)
        return message
    }
}