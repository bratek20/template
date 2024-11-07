package com.github.bratek20.template.fishing.context

import com.github.bratek20.architecture.context.api.ContextBuilder
import com.github.bratek20.architecture.context.api.ContextModule

import com.github.bratek20.template.fishing.api.*
import com.github.bratek20.template.fishing.impl.*

class FishingImpl: ContextModule {
    override fun apply(builder: ContextBuilder) {
        builder
            .setImpl(FishingApi::class.java, FishingApiLogic::class.java)
    }
}