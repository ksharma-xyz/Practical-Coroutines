package practice

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.seconds

/**
 * Practice File 4: Dispatchers and Scheduling Work
 *
 * Learning Objectives:
 * - Understanding different dispatchers and their use cases
 * - Switching contexts appropriately
 * - CPU-intensive vs IO-bound work
 * - Custom dispatchers and thread pools
 */

// TODO 1: Demonstrate different dispatchers
suspend fun demonstrateDispatchers() {
    // TODO: Create tasks that run on different dispatchers:
    // 1. CPU-intensive work on Dispatchers.Default
    // 2. IO work (file/network simulation) on Dispatchers.IO
    // 3. UI updates on Dispatchers.Main (simulate with Main.immediate)
    // 4. Unconfined dispatcher behavior
    // Print current thread name in each task
    TODO("Show how different dispatchers work and when to use each")
}

// TODO 2: Implement context switching
suspend fun contextSwitching() {
    // TODO: Start work on one dispatcher, switch to another
    // Example: Fetch data on IO dispatcher, process on Default, "update UI" on Main
    // Use withContext to switch between dispatchers
    // Measure performance impact of context switching
    TODO("Implement proper context switching between dispatchers")
}

// TODO 3: Create CPU-intensive work comparison
suspend fun cpuIntensiveWork() {
    // TODO: Create a CPU-heavy task (calculate prime numbers up to 100000)
    // Run it on different dispatchers and compare performance:
    // 1. Dispatchers.Default
    // 2. Dispatchers.IO
    // 3. Single thread dispatcher
    // Measure execution time for each
    TODO("Compare CPU-intensive work on different dispatchers")
}

// TODO 4: Implement IO-bound work patterns
suspend fun ioBoundWorkPatterns() {
    // TODO: Simulate multiple IO operations:
    // 1. File reading (use delay to simulate)
    // 2. Network calls (use delay to simulate)
    // 3. Database queries (use delay to simulate)
    // Show how IO dispatcher handles many concurrent IO operations
    TODO("Demonstrate IO-bound work patterns")
}

// TODO 5: Create a custom dispatcher
suspend fun customDispatcherExample() {
    // TODO: Create a custom dispatcher with limited thread pool (2 threads)
    // Run multiple tasks on it and show thread reuse
    // Compare with unlimited dispatcher behavior
    // Don't forget to close the dispatcher when done
    TODO("Create and use custom dispatcher with limited threads")
}

// TODO 6: Implement dispatcher debugging
suspend fun dispatcherDebugging() {
    // TODO: Create nested coroutines with different dispatchers
    // Add logging to show:
    // - Current thread name
    // - Current dispatcher
    // - Parent-child dispatcher inheritance
    // Use coroutineContext[CoroutineDispatcher] to get current dispatcher
    TODO("Add debugging to understand dispatcher behavior in nested coroutines")
}

// TODO 7: Handle dispatcher exceptions and fallbacks
suspend fun dispatcherExceptionHandling() {
    // TODO: Create scenarios where dispatcher might fail or be unavailable
    // Implement fallback strategies
    // Show how exceptions in one dispatcher affect others
    TODO("Handle dispatcher exceptions and implement fallbacks")
}

// Helper functions for CPU-intensive work
fun calculatePrimesUpTo(n: Int): List<Int> {
    val primes = mutableListOf<Int>()
    for (num in 2..n) {
        var isPrime = true
        for (i in 2 until num) {
            if (num % i == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) primes.add(num)
    }
    return primes
}

// Helper function to get current thread info
fun getCurrentThreadInfo(): String {
    return "Thread: ${Thread.currentThread().name}"
}

// Simulate IO operations
suspend fun simulateFileRead(fileName: String): String {
    delay(200) // Simulate IO delay
    return "Content of $fileName"
}

suspend fun simulateNetworkCall(url: String): String {
    delay(300) // Simulate network delay
    return "Response from $url"
}

suspend fun simulateDatabaseQuery(query: String): List<String> {
    delay(150) // Simulate DB delay
    return listOf("Result1", "Result2", "Result3")
}

// QUESTIONS TO ANSWER:
/*
Q1: What's the difference between Dispatchers.Default, IO, Main, and Unconfined? When should you use each?
A1: TODO - Write your answer here

Q2: What happens when you perform blocking operations on the wrong dispatcher?
A2: TODO - Write your answer here

Q3: How does context switching between dispatchers affect performance?
A3: TODO - Write your answer here

Q4: When would you create a custom dispatcher? What are the considerations?
A4: TODO - Write your answer here

Q5: How do dispatchers relate to thread pools? What's the relationship?
A5: TODO - Write your answer here

Q6: What's the difference between runBlocking and withContext?
A6: TODO - Write your answer here
*/

// Test function
suspend fun main() {
    println("=== Dispatchers and Scheduling Work Practice ===")

    // Uncomment to test your implementations
//     println("\n1. Different Dispatchers:")
//     demonstrateDispatchers()

//     println("\n2. Context Switching:")
//     contextSwitching()

//     println("\n3. CPU-Intensive Work:")
//     cpuIntensiveWork()

//     println("\n4. IO-Bound Work:")
//     ioBoundWorkPatterns()

//     println("\n5. Custom Dispatcher:")
//     customDispatcherExample()

//     println("\n6. Dispatcher Debugging:")
//     dispatcherDebugging()

//     println("\n7. Exception Handling:")
//     dispatcherExceptionHandling()
}
