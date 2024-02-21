import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {


    // Parallel Decomposition
    runBlocking {
        println(fetchTwoDocs())
    }

    runBlocking {

    }

}

