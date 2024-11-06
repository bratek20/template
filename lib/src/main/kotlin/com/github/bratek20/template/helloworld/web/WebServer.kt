// DO NOT EDIT! Autogenerated by HLA tool

package com.github.bratek20.template.helloworld.web

import com.github.bratek20.architecture.serialization.api.Serializer
import com.github.bratek20.architecture.serialization.api.Struct
import com.github.bratek20.architecture.serialization.context.SerializationFactory

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.github.bratek20.template.helloworld.api.*

@RestController
@RequestMapping("/helloWorldApi")
class HelloWorldApiController(
    private val api: HelloWorldApi,
) {
    private val serializer: Serializer = SerializationFactory.createSerializer()

    @PostMapping("/sayHello")
    fun sayHello(): Struct {
        // no request needed
        return serializer.asStruct(HelloWorldApiSayHelloResponse(api.sayHello()))
    }
}
