package com.github.bratek20.template.fishing.tests

import com.github.bratek20.architecture.context.stableContextBuilder
import com.github.bratek20.architecture.properties.PropertiesMock
import com.github.bratek20.architecture.properties.PropertiesMocks
import com.github.bratek20.template.fishing.api.FISHERY_PROPERTY_KEY
import com.github.bratek20.template.fishing.api.FishingApi
import com.github.bratek20.template.fishing.context.FishingImpl
import com.github.bratek20.template.fishing.fixtures.assertCaughtFish
import com.github.bratek20.template.fishing.fixtures.fishery
import com.github.bratek20.template.fishing.fixtures.lure
import org.junit.jupiter.api.Test

class FishingImplTest {
    @Test
    fun `should catch fish`() {
        val c = stableContextBuilder()
            .withModules(
                FishingImpl(),

                PropertiesMocks()
            ).build()

        val api = c.get(FishingApi::class.java)
        val propertiesMock = c.get(PropertiesMock::class.java)
        propertiesMock.set(FISHERY_PROPERTY_KEY, fishery {
            fishes = listOf({
                id = "szczupak"
                name = "Szczupak"
                minPoints = 666
                maxPoints = 666
            },{
                id = "abc"
                name = "Abc"
            })
        })

        val fish = api.catchFish(lure {
            fishId = "szczupak"
        })

        assertCaughtFish(fish) {
            id = "szczupak"
            name = "Szczupak"
            points = 666
        }

        // fishId is taken from lure
        val fish2 = api.catchFish(lure {
            fishId = "abc"
        })

        assertCaughtFish(fish2) {
            id = "abc"
            name = "Abc"
        }
    }
}