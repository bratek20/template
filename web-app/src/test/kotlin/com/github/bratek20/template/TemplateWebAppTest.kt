package com.github.bratek20.template

import com.github.bratek20.architecture.context.someContextBuilder
import com.github.bratek20.infrastructure.httpclient.context.HttpClientImpl
import com.github.bratek20.infrastructure.httpclient.fixtures.httpClientConfig
import com.github.bratek20.template.helloworld.api.HelloWorldApi
import com.github.bratek20.template.helloworld.context.HelloWorldWebClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TemplateWebAppTest {
    @Test
    fun `hello world endpoint is exposed`() {
        main()

        val api = someContextBuilder()
            .withModules(
                HttpClientImpl(),

                HelloWorldWebClient(httpClientConfig {
                    baseUrl = "http://localhost:8080"
                })
            )
            .get(HelloWorldApi::class.java)

        assertThat(api.sayHello()).isEqualTo("Hello World!")
    }
}