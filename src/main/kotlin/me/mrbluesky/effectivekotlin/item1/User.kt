package me.mrbluesky.effectivekotlin.item1

class User(val name: String, val surname: String) {
    fun withSurname(surname: String) = User(name, surname)
}

data class DataUser(val name: String, val surname: String)