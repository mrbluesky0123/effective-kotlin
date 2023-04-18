package me.mrbluesky.effectivekotlin.item2

// 선언과 동시에 초기화하라
class User(val value: String) {

}

// nice!
const val hasValue: Boolean = true
val user: User = if(hasValue) {
    User("B")
} else {
    User("A")
}

// bad!
//val user2: User = TODO()
//if(hasValue) {
//    user2 = User("A")
//} else {
//    user2 = User("B")
//}

fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 5 -> "cold" to "Blue"
        degrees < 23 -> "mild" to "Yellow"
        else -> "hot" to "Red"
    }

}

// 변수의 스코프가 넓으면 위험하다!

fun primeNumbers(): List<Int> {
    // ver 1
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while(numbers.isNotEmpty()) {
        val prime = numbers.first()
        println(prime)
        primes.add(prime)
        numbers = numbers.filter {it % prime != 0}
    }

    // ver 2
    val primes2: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }
        while(true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter {it % prime != 0}
        }
    }
    print(primes.take(10).toList())
    return primes
}