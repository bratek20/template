package com.github.bratek20.template

import com.github.bratek20.logs.context.Slf4jLogsImpl
import com.github.bratek20.spring.webapp.SpringWebApp
import com.github.bratek20.template.helloworld.context.HelloWorldWebServer

fun main() {
    SpringWebApp(
        modules = listOf(
            Slf4jLogsImpl(),

            HelloWorldWebServer()
        ),
    ).run()
}