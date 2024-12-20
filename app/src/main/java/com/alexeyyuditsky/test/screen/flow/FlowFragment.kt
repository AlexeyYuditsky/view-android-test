package com.alexeyyuditsky.test.screen.flow

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.os.Debug
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.FragmentChangeScreenBinding
import com.alexeyyuditsky.test.screen.flow.crypto.CryptoFragment
import com.alexeyyuditsky.test.screen.flow.game.TeamScoreFragment
import com.alexeyyuditsky.test.screen.flow.user.UsersFragment

class FlowFragment :
    AbstractFragment<FragmentChangeScreenBinding>(R.layout.fragment_change_screen) {

    override fun bind(view: View) = FragmentChangeScreenBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, UsersFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.cryptoButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CryptoFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.teamScoreButton.setOnClickListener {
            logMemoryDetails(requireContext().applicationContext)
            log("Click on teamScoreButton at ${System.currentTimeMillis()}", "flow")

            val transactionStartTime = System.currentTimeMillis()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, TeamScoreFragment())
                .addToBackStack(null)
                .commit()
            log(
                "Transaction committed at ${System.currentTimeMillis() - transactionStartTime}ms",
                "flow"
            )
            logMemoryDetails(requireContext().applicationContext)
        }
    }

    companion object {
        fun logMemoryDetails(context: Context) {
            logMemoryUsage(context)
            logHeapMemoryUsage()
            logDeviceMemoryInfo(context)
        }

        fun logMemoryUsage(context: Context) {
            val activityManager =
                context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val memoryInfo = Debug.MemoryInfo()
            Debug.getMemoryInfo(memoryInfo)

            val totalPrivateDirty = memoryInfo.totalPrivateDirty // Память приложения (KB)
            val totalSharedDirty =
                memoryInfo.totalSharedDirty // Общая память, разделяемая с другими процессами (KB)
            val totalPss =
                memoryInfo.totalPss // Общая физическая память, учитывающая разделяемую (KB)

            log(
                "Memory usage: totalPrivateDirty=${totalPrivateDirty / 1024}MB, " +
                        "totalSharedDirty=${totalSharedDirty / 1024}MB, " +
                        "totalPss=${totalPss / 1024}MB", "myMemory"
            )
        }

        fun logHeapMemoryUsage() {
            val runtime = Runtime.getRuntime()
            val maxMemory = runtime.maxMemory() // Максимальный размер памяти для приложения (байты)
            val totalMemory = runtime.totalMemory() // Всего выделено JVM (байты)
            val freeMemory = runtime.freeMemory() // Доступная память в рамках выделенного JVM (байты)
            val usedMemory = totalMemory - freeMemory // Используемая память

            log(
                "Heap memory usage: maxMemory=${maxMemory / (1024 * 1024)}MB, " +
                        "totalMemory=${totalMemory / (1024 * 1024)}MB, " +
                        "freeMemory=${freeMemory / (1024 * 1024)}MB, " +
                        "usedMemory=${usedMemory / (1024 * 1024)}MB", "myMemory"
            )
        }

        fun logDeviceMemoryInfo(context: Context) {
            val activityManager =
                context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val memoryInfo = ActivityManager.MemoryInfo()
            activityManager.getMemoryInfo(memoryInfo)

            log(
                "Device memory info: " +
                        "totalMemory=${memoryInfo.totalMem / (1024 * 1024)}MB, " +
                        "availableMemory=${memoryInfo.availMem / (1024 * 1024)}MB, " +
                        "lowMemory=${memoryInfo.lowMemory}", "myMemory"
            )
        }
    }

}