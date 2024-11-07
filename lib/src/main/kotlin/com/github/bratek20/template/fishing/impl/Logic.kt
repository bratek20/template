package com.github.bratek20.template.fishing.impl

import com.github.bratek20.template.fishing.api.*

class FishingApiLogic: FishingApi {
    override fun catchFish(lure: Lure): CaughtFish {
        return CaughtFish.create(lure.getFishId(),"Szczupak", 666)
    }
}