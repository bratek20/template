// DO NOT EDIT! Autogenerated by HLA tool

package com.github.bratek20.template.helloworld.web

import com.github.bratek20.infrastructure.httpclient.api.HttpClientConfig

import com.github.bratek20.template.helloworld.api.*

class HelloWorldWebClientConfig(
    val value: HttpClientConfig
) {
}
class HelloWorldApiSayHelloResponse(
    private val value: String
) {
    fun getValue(): String {
        return value
    }
}