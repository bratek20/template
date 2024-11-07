package com.github.bratek20.template.fishing.impl

import com.github.bratek20.template.fishing.api.*

class FishingApiLogic: FishingApi {
    override fun catchFish(lure: Lure): Fish {
        return Fish.create(lure.getFishId(),"Szczupak", 666)
    }
}