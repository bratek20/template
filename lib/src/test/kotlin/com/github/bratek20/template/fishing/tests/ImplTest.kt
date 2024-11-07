package com.github.bratek20.template.fishing.tests

import com.github.bratek20.architecture.context.someContextBuilder
import com.github.bratek20.template.fishing.api.FishingApi
import com.github.bratek20.template.fishing.context.FishingImpl
import com.github.bratek20.template.fishing.fixtures.assertCaughtFish
import com.github.bratek20.template.fishing.fixtures.lure
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FishingImplTest {
    @Test
    fun `should catch fish`() {
        val api = someContextBuilder()
            .withModules(
                FishingImpl()
            )
            .get(FishingApi::class.java)

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
        }
    }
}