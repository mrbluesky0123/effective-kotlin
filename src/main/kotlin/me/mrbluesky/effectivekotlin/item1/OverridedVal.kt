package me.mrbluesky.effectivekotlin.item1

interface OverridedVal {
    val active: Boolean
}
class OverridedValImpl: OverridedVal  {
    override var active: Boolean = false
}