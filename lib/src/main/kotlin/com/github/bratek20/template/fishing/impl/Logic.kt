package com.github.bratek20.template.fishing.impl

import com.github.bratek20.template.fishing.api.*

class FishingApiLogic: FishingApi {
    override fun catchFish(): Fish {
        return Fish("Szczupak", 666)
    }
}