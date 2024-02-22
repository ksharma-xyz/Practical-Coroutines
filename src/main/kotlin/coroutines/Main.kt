package coroutines

import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {


    // Parallel Decomposition
    runBlocking {
        println(fetchTwoDocs())
    }

    runBlocking {

    }

}

