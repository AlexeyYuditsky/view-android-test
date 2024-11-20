package com.alexeyyuditsky.test.example.other.systemDesign.oneTask

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import org.jetbrains.annotations.NotNull
import kotlin.properties.Delegates

class MyFragment : Fragment() {
    private val viewModel =
        VM(CommandExecutorImpl(BleDevice.Base()))

    init {
        viewModel.runQuery()
        viewModel.liveData.observe(viewLifecycleOwner) {
            // setValue on UI
        }
    }
}

class VM(
    private val commandExecutor: CommandExecutor
) : ViewModel() {

    val liveData = MutableLiveData<String>()

    fun runQuery() {
        val url = "battery_status"
        commandExecutor.requestAsync(url, ::request)
    }

    fun request(value: String) {
        liveData.value = value
    }

}

class CommandExecutorImpl(
    private val bleDevice: BleDevice
) : CommandExecutor {

    private val mutex = Mutex()
    private val responseCache = mutableMapOf<String, String>()
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var lastExecutionTime: Long = 0
    private val minIntervalMs = 5000

    override fun requestAsync(
        url: String,
        onResponse: (String) -> Unit
    ) {
        scope.launch {
            try {
                val response = getResponse(url)
                withContext(Dispatchers.Default) { // будет Main для андроид приложения
                    onResponse(response)
                }
            } catch (e: Exception) {
                onResponse(e.message ?: "Unknown error")
            } finally {
                responseCache.clear()
            }
        }
    }

    private suspend fun getResponse(url: String): String = mutex.withLock {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastExecutionTime >= minIntervalMs) {
            lastExecutionTime = currentTime
            responseCache[url] = bleDevice.requestSync(url)
        }
        responseCache[url] ?: throw IllegalStateException("No response available")
    }
}