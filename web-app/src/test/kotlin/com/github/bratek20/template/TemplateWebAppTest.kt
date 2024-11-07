package com.github.bratek20.template

import com.github.bratek20.architecture.context.someContextBuilder
import com.github.bratek20.infrastructure.httpclient.context.HttpClientImpl
import com.github.bratek20.infrastructure.httpclient.fixtures.httpClientConfig
import com.github.bratek20.template.fishing.api.FishingApi
import com.github.bratek20.template.fishing.context.FishingWebClient
import com.github.bratek20.template.fishing.fixtures.lure
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

                FishingWebClient(httpClientConfig {
                    baseUrl = "http://localhost:8080"
                })
            )
            .get(FishingApi::class.java)

        api.catchFish(lure { fishId = "abc" })
    }
}