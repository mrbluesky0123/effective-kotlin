package me.mrbluesky.effectivekotlin.item1

class Person {
    var firstName: String = "Randy"
    var lastName: String = "Rhoads"
    val fullName: String
        get() = "$firstName $lastName"

    // bakcing properties
    var counter = 0
        set(value) {
            if (value < 0)
                field = value
                // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }

    private var _familyName: String? = null
    val familyName: String
        get() {
            if(_familyName == null) {
                _familyName = "Kang"
            }
            return _familyName ?: throw AssertionError("Set to null by another thread")
        }

}