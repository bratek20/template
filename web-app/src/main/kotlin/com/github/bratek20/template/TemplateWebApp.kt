package com.github.bratek20.template

import com.github.bratek20.architecture.properties.api.Properties
import com.github.bratek20.architecture.properties.context.PropertiesImpl
import com.github.bratek20.architecture.properties.sources.inmemory.InMemoryPropertiesSource
import com.github.bratek20.architecture.properties.sources.inmemory.InMemoryPropertiesSourceImpl
import com.github.bratek20.logs.context.Slf4jLogsImpl
import com.github.bratek20.spring.webapp.SpringWebApp
import com.github.bratek20.template.fishing.api.FISHERY_PROPERTY_KEY
import com.github.bratek20.template.fishing.api.FishContent
import com.github.bratek20.template.fishing.api.FishId
import com.github.bratek20.template.fishing.api.Fishery
import com.github.bratek20.template.fishing.context.FishingWebServer
import com.github.bratek20.template.helloworld.context.HelloWorldWebServer

fun main() {
    val c = SpringWebApp(
        modules = listOf(
            Slf4jLogsImpl(),

            HelloWorldWebServer(),
            FishingWebServer(),

            PropertiesImpl(),
            InMemoryPropertiesSourceImpl()
        ),
    ).run()

    c.get(InMemoryPropertiesSource::class.java).set(FISHERY_PROPERTY_KEY, Fishery.create(
        fishes = listOf(
            FishContent.create(
                id = FishId("abc"),
                name = "Szczupak",
                minPoints = 50,
                maxPoints = 100
            )
        )
    ))
}