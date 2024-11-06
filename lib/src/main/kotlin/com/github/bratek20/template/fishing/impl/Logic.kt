package com.github.bratek20.template.fishing.impl

import com.github.bratek20.architecture.properties.api.Properties
import com.github.bratek20.template.fishing.api.*
import kotlin.random.Random

class FishingApiLogic(
    private val properties: Properties
): FishingApi {
    override fun catchFish(lure: Lure): CaughtFish {
        val fishContent = properties.get(FISHERY_PROPERTY_KEY).getFishes().first { it.getId() == lure.getFishId() }
        val points = Random.nextInt(fishContent.getMinPoints(), fishContent.getMaxPoints())
        return CaughtFish.create(
            id = lure.getFishId(),
            name = fishContent.getName(),
            points = points
        )
    }
}