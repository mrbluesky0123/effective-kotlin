package me.mrbluesky.effectivekotlin.item3

class DoNotUsePlatformType {
}

var users: List<String?> = mutableListOf(null, "1")
var notNullUsers = users.filterNotNull()