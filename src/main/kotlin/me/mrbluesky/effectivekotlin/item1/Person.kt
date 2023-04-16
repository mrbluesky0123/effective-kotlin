package me.mrbluesky.effectivekotlin.item1

class Person {
    var firstName: String = "Randy"
    var lastName: String = "Rhoads"
    val fullName: String
        get() = "$firstName $lastName"
}