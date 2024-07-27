package com.github.bratek20.template

import com.github.bratek20.architecture.context.spring.SpringContextBuilder
import com.github.bratek20.template.helloworld.api.HelloWorldApi
import com.github.bratek20.template.helloworld.context.HelloWorldImpl

fun main() {
    val api = SpringContextBuilder()
        .withModules(
            HelloWorldImpl()
        )
        .get(HelloWorldApi::class.java)

    api.sayHello()
}