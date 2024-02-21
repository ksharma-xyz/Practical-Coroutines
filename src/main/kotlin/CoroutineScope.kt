import kotlinx.coroutines.*

/**
 * A cancelled scope cannot create more coroutines.
 *
 * Therefore, you should call scope.cancel() only when the class that controls its lifecycle is being destroyed.
 *
 * When using viewModelScope, the ViewModel class cancels the scope automatically for you in the ViewModel's
 * `onCleared()` method.
 *
 */

// Job and Dispatcher are combined into a CoroutineContext which
val scope = CoroutineScope(Job() + Dispatchers.IO)

fun main() {
    runBlocking {
        exampleMethod()
    }
}

suspend fun exampleMethod() {
    // Starts a new coroutine within the scope
    val job = scope.launch {
        // New coroutine that can call suspend functions
        fetchDocs()
    }


    println("Wait for 1 second..") // Will work in parallel to Job.
    delay(1000)
    println("Cancel fetching docs..")
    cleanUp()

    job.join() // Execution will not go further until [job] finishes or the job is cancelled.
    println("Will be printed only when job will complete or is cancelled")

    scope.launch {
        println("Trying to launch coroutine from a scope that has been cancelled. - This will never be printed because" +
                "A cancelled scope cannot create more coroutines.")
    }
}

suspend fun fetchDocs() {
    println("fetchDocs() will take 5 seconds to complete...")
    delay(5000)
    println("fetchDocs finish")
}

fun cleanUp() {
    // Cancel the scope to cancel ongoing coroutines work
    scope.cancel()
}