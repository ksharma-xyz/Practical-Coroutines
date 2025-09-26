package practice

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Duration.Companion.milliseconds

/**
 * Practice File 3: Parallel Work and Async/Await
 *
 * Learning Objectives:
 * - Understanding async vs launch
 * - Parallel decomposition patterns
 * - Structured concurrency with async
 * - Exception handling in parallel work
 */

// Sample data classes for practice
data class User(val id: Int, val name: String)
data class UserProfile(val userId: Int, val email: String, val bio: String)
data class UserPosts(val userId: Int, val posts: List<String>)

// Simulated network calls
suspend fun fetchUser(id: Int): User {
    delay(500) // Simulate network delay
    return User(id, "User$id")
}

suspend fun fetchUserProfile(userId: Int): UserProfile {
    delay(300)
    return UserProfile(userId, "user$userId@email.com", "Bio for user $userId")
}

suspend fun fetchUserPosts(userId: Int): UserPosts {
    delay(400)
    return UserPosts(userId, listOf("Post1 by user$userId", "Post2 by user$userId"))
}

// TODO 1: Implement sequential vs parallel data fetching
suspend fun sequentialVsParallelFetching(userId: Int) {
    // TODO: First implement sequential fetching (one after another)
    // Measure time taken
    // Then implement parallel fetching using async/await
    // Compare the performance difference
    TODO("Compare sequential vs parallel data fetching")
}

// TODO 2: Implement parallel processing of multiple users
suspend fun fetchMultipleUsersData(userIds: List<Int>) {
    // TODO: Fetch user data for multiple users in parallel
    // For each user, fetch: User info, Profile, and Posts concurrently
    // Use async for each user's data fetching
    // Print results as they become available
    TODO("Fetch data for multiple users in parallel")
}

// TODO 3: Handle exceptions in parallel work
suspend fun parallelWithExceptionHandling(userIds: List<Int>) {
    // TODO: Simulate some network calls failing
    // Use supervisorScope to prevent one failure from cancelling others
    // Handle individual failures gracefully
    // Return partial results for successful calls
    TODO("Handle exceptions in parallel async operations")
}

// TODO 4: Implement timeout for parallel operations
suspend fun parallelWithTimeouts() {
    // TODO: Create multiple async operations with different delays
    // Some operations take 1s, others take 3s
    // Set overall timeout of 2s using withTimeout
    // Handle TimeoutCancellationException properly
    TODO("Implement parallel operations with timeout")
}

// TODO 5: Create a parallel batch processor
suspend fun batchProcessor(items: List<Int>, batchSize: Int = 3) {
    // TODO: Process items in batches of specified size
    // Within each batch, process items in parallel
    // Wait for each batch to complete before starting next batch
    // Each item processing should take random time (100-500ms)
    TODO("Create batch processor with parallel processing within batches")
}

// TODO 6: Implement racing pattern (first result wins)
suspend fun racingPattern() {
    // TODO: Create 3 async operations that fetch the same data from different sources
    // Source 1: Fast but unreliable (50% chance of failure, 200ms delay)
    // Source 2: Medium speed, reliable (800ms delay)
    // Source 3: Slow but always works (1500ms delay)
    // Return result from whichever completes first successfully
    TODO("Implement racing pattern - first successful result wins")
}

// Simulated unreliable network call for racing pattern
suspend fun fetchFromUnreliableSource(sourceId: Int): String {
    delay(when(sourceId) {
        1 -> 200
        2 -> 800
        else -> 1500
    })
    if (sourceId == 1 && kotlin.random.Random.nextBoolean()) {
        throw Exception("Source $sourceId failed")
    }
    return "Data from source $sourceId"
}

// QUESTIONS TO ANSWER:
/*
Q1: When should you use async vs launch? What's the key difference?
A1: TODO - Write your answer here

Q2: What happens if one async operation fails? How does it affect other parallel operations?
A2: TODO - Write your answer here

Q3: What's the difference between coroutineScope and supervisorScope for parallel work?
A3: TODO - Write your answer here

Q4: How can you limit the number of concurrent operations when processing large lists?
A4: TODO - Write your answer here

Q5: What are the benefits and drawbacks of parallel processing?
A5: TODO - Write your answer here
*/

// Test function
suspend fun main() {
    println("=== Parallel Work and Async/Await Practice ===")

    // Uncomment to test your implementations
//     println("\n1. Sequential vs Parallel:")
//     sequentialVsParallelFetching(1)

//     println("\n2. Multiple Users Data:")
//     fetchMultipleUsersData(listOf(1, 2, 3))

//     println("\n3. Exception Handling:")
//     parallelWithExceptionHandling(listOf(1, 2, 3, 4))

//     println("\n4. Parallel with Timeouts:")
//     parallelWithTimeouts()

//     println("\n5. Batch Processing:")
//     batchProcessor((1..10).toList(), 3)

//     println("\n6. Racing Pattern:")
//     println("Winner: ${racingPattern()}")
}
