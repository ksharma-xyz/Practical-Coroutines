package flows

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // uniqueEvents()
    flowToSharedFlowCollectingAfterEmissionReplay1()

     // flowToSharedFlowCollectingAfterEmissionReplay0()
    // flowToSharedFlowCollectingAfterEmissionReplay0_Lazily()

    //flowToSharedFlow()

}

fun flowToSharedFlowCollectingAfterEmissionReplay1() {
    runBlocking {
        val sharedFlow: SharedFlow<Int> = coldFlow().shareIn(
            scope = this,
            started = SharingStarted.Eagerly,
            replay = 1,
        )

        val job = launch {
            println("Wait before collecting..")
            delay(4000)
            println("\nNow start collecting.. Only the Last emitted item (one item) will be collected because replay is 1")
            sharedFlow.collect {// Will print the last emitted value , because replay is 1
                println("Collected: $it")
            }
        }
        delay(10000) // let it collect
        job.cancel()
    }
}

fun flowToSharedFlowCollectingAfterEmissionReplay0() {
    runBlocking {
        val sharedFlow: SharedFlow<Int> = coldFlow().shareIn(
            scope = this,
            started = SharingStarted.Eagerly,
            replay = 0,
        )

        val job = launch {
            delay(4000)
            println("\nNow start collecting.. but nothing will be collected because replay is 0")
            sharedFlow.collect {// Nothing will be collected because replay is 0
                println("Collected: $it")
            }
        }
        delay(6000) // let it collect
        job.cancel()
    }
}

fun flowToSharedFlowCollectingAfterEmissionReplay0_Lazily() {
    runBlocking {
        val sharedFlow: SharedFlow<Int> = coldFlow().shareIn(
            scope = this,
            started = SharingStarted.Lazily,
            replay = 0,
        )

        val job = launch {
            println("LAZY - emit only when collect called. Wait 2 seconds before calling collect..")
            delay(2000)
            println("\nNow start collecting..")
            sharedFlow.collect {// Nothing will be collected because replay is 0
                println("Collected: $it")
            }
        }
        delay(10000) // let it collect
        job.cancel()
    }
}


private fun uniqueEvents() {
    // Even though same items are emitted multiple times, only the unique values will be emitted and only once.
    val sharedFlow = MutableSharedFlow<String>( // does not take a default, initial value
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    runBlocking {
        val job = launch {
            println("1st consumer collecting..")
            sharedFlow.collect {// Will get only unique values as BufferOverflow.DROP_OLDEST and replay is 1
                println("Collected[1] Value: $it")
            }
        }
        val job2 = launch {
            delay(5000)
            println("2nd consumer collecting..") // Since this started consuming later will get one (replay is 1) most recent value.
            sharedFlow.collect {
                println("Collected[2] Value: $it")
            }
        }

        launch {
            println("Collection will not start unless emitted something..")

            sharedFlow.emit("1")
            delay(1000)
            sharedFlow.emit("1")
            sharedFlow.emit("2")
            sharedFlow.emit("2")

            delay(5000) //let it collect
            job.cancel()
            job2.cancel()
        }
    }
}