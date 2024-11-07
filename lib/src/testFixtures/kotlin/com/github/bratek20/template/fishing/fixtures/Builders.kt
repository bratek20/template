// DO NOT EDIT! Autogenerated by HLA tool

package com.github.bratek20.template.fishing.fixtures

import com.github.bratek20.template.fishing.api.*

fun fishId(value: String = "someValue"): FishId {
    return FishId(value)
}

data class FishDef(
    var id: String = "someValue",
    var name: String = "someValue",
    var points: Int = 0,
)
fun fish(init: FishDef.() -> Unit = {}): Fish {
    val def = FishDef().apply(init)
    return Fish.create(
        id = FishId(def.id),
        name = def.name,
        points = def.points,
    )
}

data class LureDef(
    var fishId: String = "someValue",
)
fun lure(init: LureDef.() -> Unit = {}): Lure {
    val def = LureDef().apply(init)
    return Lure.create(
        fishId = FishId(def.fishId),
    )
}