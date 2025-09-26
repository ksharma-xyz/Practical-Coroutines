package practice

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

/**
 * Practice File 1: Flow Basics and Cancellation
 *
 * Learning Objectives:
 * - Understanding cold vs hot flows
 * - Flow cancellation mechanisms
 * - Flow lifecycle and cleanup
 */

// TODO 1: Complete the cold flow implementation
fun createColdFlow(): Flow<Int> {
    // TODO: Create a flow that emits numbers 1-5 with 1 second delays
    // The flow should print "Emitting: $number" before each emission
    // Remember: Cold flows start fresh for each collector
    TODO("Implement cold flow that emits 1-5 with delays")
}

// TODO 2: Implement flow cancellation handling
suspend fun demonstrateFlowCancellation() {
    // TODO: Create a flow that emits infinite numbers
    // Collect it with a timeout of 3 seconds
    // Handle the TimeoutCancellationException properly
    // Print how many items were collected before cancellation
    TODO("Implement flow with timeout and cancellation handling")
}

// TODO 3: Create a flow with proper cleanup
fun flowWithCleanup(): Flow<String> {
    // TODO: Create a flow that:
    // 1. Opens a "resource" (just print "Opening resource")
    // 2. Emits 3 items: "data1", "data2", "data3"
    // 3. Uses onCompletion to cleanup (print "Closing resource")
    // 4. Handle both normal completion and cancellation
    TODO("Implement flow with onCompletion cleanup")
}

// TODO 4: Implement exception handling in flows
fun flowWithExceptionHandling(): Flow<Int> {
    // TODO: Create a flow that:
    // 1. Emits numbers 1, 2, 3
    // 2. Throws an exception after emitting 3
    // 3. Use catch operator to handle the exception
    // 4. Emit a fallback value (-1) when exception occurs
    TODO("Implement flow with exception handling using catch")
}

// QUESTIONS TO ANSWER:
/*
Q1: What's the difference between cold and hot flows? When would you use each?
A1: TODO - Write your answer here

Q2: What happens when a flow collector is cancelled? How does onCompletion help?
A2: TODO - Write your answer here

Q3: When should you use the catch operator vs try-catch around collect()?
A3: TODO - Write your answer here

Q4: How does flow cancellation relate to structured concurrency?
A4: TODO - Write your answer here
*/

// Test function - uncomment and run to test your implementations
suspend fun main() {
    println("=== Flow Basics and Cancellation Practice ===")

    // Test cold flow
//     println("\n1. Testing Cold Flow:")
//     createColdFlow().collect { println("Collected: $it") }

    // Test cancellation
//     println("\n2. Testing Flow Cancellation:")
//     demonstrateFlowCancellation()

    // Test cleanup
//     println("\n3. Testing Flow Cleanup:")
//     flowWithCleanup().collect { println("Received: $it") }

    // Test exception handling
//     println("\n4. Testing Exception Handling:")
//     flowWithExceptionHandling().collect { println("Got: $it") }
}
