package me.mrbluesky.effectivekotlin.item2.controller

import me.mrbluesky.effectivekotlin.item2.fold
import me.mrbluesky.effectivekotlin.item2.primeNumbers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/item2")
class Item2Controller {

    @GetMapping("/primeNumbers")
    fun getPrimeNumbers(): String {
        val a: List<Int> = primeNumbers()
        return a.toString()
    }

    @GetMapping("/lambda/{dummy}")
    fun getLambda(@PathVariable dummy: String) {
        println(dummy.toInt() > 9)
        require(dummy.toInt() > 9) {"Path variable should be under 9"}
        val items = listOf<Int>(1, 2, 3, 4, 5)
        items.fold(0) { acc: Int, i: Int ->
            print("acc = $acc, i = $i")
            val result = acc + i
            println("result = $result")
            result
        }
        val joinedToString = items.fold("Elements: ") { acc, i -> "$acc $i" }
        println(joinedToString)
        val product = items.fold(1, Int::times)
        println(product)

    }
}