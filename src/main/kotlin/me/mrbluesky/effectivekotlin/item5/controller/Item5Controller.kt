package me.mrbluesky.effectivekotlin.item5.controller

import me.mrbluesky.effectivekotlin.item2.primeNumbers
import me.mrbluesky.effectivekotlin.item5.factorial
import me.mrbluesky.effectivekotlin.item5.speak
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/item5")
class Item5Controller {

    @GetMapping("/factorial/{n}")
    fun getFactorial(@PathVariable n: Int): String {
        val a = factorial(n)
        return a.toString()
    }

    @GetMapping("/speech/{isInitialized}")
    fun speech(@PathVariable isInitialized: Boolean): String {
        val a = speak(isInitialized)
        return a.toString()
    }

    @GetMapping("/say")
    fun say(@RequestParam something: String?): String {
        val a = me.mrbluesky.effectivekotlin.item5.say(something)
        return a.toString()
    }

}