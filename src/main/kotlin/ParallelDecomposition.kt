import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

/**
 * https://developer.android.com/kotlin/coroutines/coroutines-adv#parallel
 */
suspend fun fetchTwoDocs() =        // called on any Dispatcher (any thread, possibly Main)
    coroutineScope {
        val deferreds = listOf(     // fetch two docs at the same time
            async { fetchDoc(1) },  // async returns a result for the first doc
            async { fetchDoc(2) }   // async returns a result for the second doc
        )
        println("async launched")
        deferreds.awaitAll()        // use awaitAll to wait for both network requests
        println("ALL DONE")
    }

suspend fun fetchDoc(number: Int) {
    delay(1000L * number)
    println("Fetch $number complete")
}

