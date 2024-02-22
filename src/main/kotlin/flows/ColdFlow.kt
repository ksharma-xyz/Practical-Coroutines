package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Cold Flow")
        val flow = coldFlow()
        delay(1000)
        println("Cold Flow did not execute..Let's start collecting now..")
        delay(1000)
        flow.collect { value ->
            println("\tCollect Value: $value")
        }

        delay(500)
        println("Collecting again, and same values will be emitted because it's cold")
        flow.collect { value ->
            println("\tCollect Value: $value")
        }
        println("Finish")

    }
}

fun coldFlow() = flow {
    println("Emit 5 Numbers:")
    for (i in 1..5) {
        println("\tEmit: $i")
        emit(i)
        delay(500)
    }
}