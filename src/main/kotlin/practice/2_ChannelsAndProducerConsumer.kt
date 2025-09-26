package practice

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Practice File 2: Channels and Producer-Consumer Patterns
 *
 * Learning Objectives:
 * - Channel types and their use cases
 * - Producer-consumer patterns
 * - Channel cancellation and closing
 * - Buffering strategies
 */

// TODO 1: Create a simple producer-consumer with Channel
suspend fun basicProducerConsumer() {
    // TODO: Create a channel of Int
    // Launch a producer coroutine that sends numbers 1-10
    // Launch a consumer coroutine that receives and prints them
    // Don't forget to close the channel when done producing
    TODO("Implement basic producer-consumer pattern")
}

// TODO 2: Implement a buffered channel example
suspend fun bufferedChannelExample() {
    // TODO: Create a buffered channel with capacity 3
    // Producer should send 5 items quickly (no delay)
    // Consumer should receive slowly (500ms delay each)
    // Observe how buffering affects the flow
    TODO("Create buffered channel with capacity 3")
}

// TODO 3: Create a fan-out pattern (one producer, multiple consumers)
suspend fun fanOutPattern() {
    // TODO: Create one producer that generates random numbers (1-100)
    // Create 3 consumer coroutines that compete for the data
    // Each consumer should process data differently:
    // Consumer 1: Print even numbers only
    // Consumer 2: Print odd numbers only
    // Consumer 3: Print numbers > 50 only
    // Use produce builder for the producer
    TODO("Implement fan-out pattern with one producer, three consumers")
}

// TODO 4: Create a fan-in pattern (multiple producers, one consumer)
suspend fun fanInPattern() {
    // TODO: Create 3 producers:
    // Producer 1: Sends "A1", "A2", "A3"...
    // Producer 2: Sends "B1", "B2", "B3"...
    // Producer 3: Sends "C1", "C2", "C3"...
    // One consumer collects from all and prints in order received
    // Use select expression or merge multiple channels
    TODO("Implement fan-in pattern with multiple producers, one consumer")
}

// TODO 5: Implement channel cancellation and cleanup
suspend fun channelCancellationDemo() {
    // TODO: Create a producer that sends infinite data
    // Start consuming in a separate coroutine
    // Cancel the consumer after 2 seconds
    // Properly handle cancellation and cleanup
    // Show what happens to unprocessed items
    TODO("Demonstrate channel cancellation and cleanup")
}

// TODO 6: Create a pipeline using channels
suspend fun channelPipeline() {
    // TODO: Create a 3-stage pipeline:
    // Stage 1: Generate numbers 1-10
    // Stage 2: Square each number
    // Stage 3: Filter even numbers and print
    // Each stage should be a separate coroutine with its own channel
    TODO("Create a 3-stage pipeline using channels")
}

// Helper function for creating a producer (you can use this)
fun CoroutineScope.createNumberProducer(start: Int, count: Int, delayMs: Long = 100) = produce {
    repeat(count) {
        delay(delayMs)
        send(start + it)
    }
}

// QUESTIONS TO ANSWER:
/*
Q1: What's the difference between Channel, BroadcastChannel, and Flow? When to use each?
A1: TODO - Write your answer here

Q2: What happens when you send to a full unbuffered channel? What about a full buffered channel?
A2: TODO - Write your answer here

Q3: How does channel closing affect producers and consumers? What about cancellation?
A3: TODO - Write your answer here

Q4: When would you choose channels over flows for communication between coroutines?
A4: TODO - Write your answer here

Q5: What's the difference between produce builder and manually creating channels?
A5: TODO - Write your answer here
*/

// Test function
suspend fun main() {
    println("=== Channels and Producer-Consumer Practice ===")

    // Uncomment to test your implementations
//     println("\n1. Basic Producer-Consumer:")
//     basicProducerConsumer()

//     println("\n2. Buffered Channel:")
//     bufferedChannelExample()

//     println("\n3. Fan-Out Pattern:")
//     fanOutPattern()

//     println("\n4. Fan-In Pattern:")
//     fanInPattern()

//     println("\n5. Channel Cancellation:")
//     channelCancellationDemo()

//     println("\n6. Channel Pipeline:")
//     channelPipeline()
}
