package me.mrbluesky.effectivekotlin.item2

fun <T, R> Collection<T>.fold(initial: R, combine: (acc: R, nextElement: T) -> R): R {
    var accumulator: R = initial
    for(element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

val a = { i: Int -> i + 1 }

class IntTransformer: (Int) -> Int {
    override operator fun invoke(x: Int): Int = TODO()
}

val intFunction: (Int) -> Int = IntTransformer()


val repeatFun: String.(Int) -> String = {times -> this.repeat(times)}

val twoParams: (String, Int) -> String = repeatFun
fun runTransformation(f: (String, Int) -> String) : String {
    return f("hello", 3)
}
val result = runTransformation(repeatFun)