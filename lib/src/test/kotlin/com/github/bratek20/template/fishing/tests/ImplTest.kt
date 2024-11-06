package com.github.bratek20.template.fishing.tests

import com.github.bratek20.architecture.context.someContextBuilder
import com.github.bratek20.architecture.exceptions.assertApiExceptionThrown
import com.github.bratek20.architecture.properties.PropertiesMock
import com.github.bratek20.architecture.properties.PropertiesMocks
import com.github.bratek20.template.fishing.api.FISHERY_PROPERTY_KEY
import com.github.bratek20.template.fishing.api.FishNotFound
import com.github.bratek20.template.fishing.api.FishingApi
import com.github.bratek20.template.fishing.context.FishingImpl
import com.github.bratek20.template.fishing.fixtures.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FishingImplTest {
    @Test
    fun `should catch fish`() {
        val c = someContextBuilder()
            .withModules(
                FishingImpl(),
                PropertiesMocks()
            )
            .build()

        val api = c.get(FishingApi::class.java)
        val propertiesMock = c.get(PropertiesMock::class.java)
        propertiesMock.set(FISHERY_PROPERTY_KEY, fishery {
            fishes = listOf {
                id = "szcz"
                name = "Szczupak"
                minPoints = 50
                maxPoints = 100
            }
        })

        val fish = api.catchFish(lure{
            fishId = "szcz"
        })

        assertCaughtFish(fish) {
            id = "szcz"
            name = "Szczupak"
        }

        assertThat(fish.getPoints()).isBetween(50, 100)

        assertApiExceptionThrown(
            {api.catchFish(lure{ fishId = "abc" }) },
            {
                type = FishNotFound::class
                message = "Fish with id abc not found"
            }
        )
    }
}