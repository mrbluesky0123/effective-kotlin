package me.mrbluesky.effectivekotlin.item8

import kotlin.properties.Delegates

class Printer(var name: String?)

fun nullSafety(value: Int) {
    val printer: Printer? = if (value >= 1) Printer("default") else null
    val printerName1 = printer?.name ?: "Unnamed"
    val printerName2 = printer?.name ?: return
    val printerName3 = printer.name ?: throw Error("Name is null")

    val list: List<String>? = if(value >= 1) arrayListOf("1", "2", "3") else null
    list.orEmpty()

    val a = "qqqq"
    a.isNullOrEmpty()

//    var notNull: Boolean by Delegates.notNull<>()
}