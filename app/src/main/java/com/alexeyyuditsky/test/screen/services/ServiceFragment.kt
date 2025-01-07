package com.alexeyyuditsky.test.screen.services

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentServiceBinding
import com.alexeyyuditsky.test.service.BoundService
import com.alexeyyuditsky.test.service.StartedService

class ServiceFragment :
    AbstractFragment<FragmentServiceBinding>(R.layout.fragment_service), ServiceConnection {

    private var boundService: BoundService? = null
    private var isBound = false

    override fun bind(view: View) = FragmentServiceBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTextView.text = "started value"

        println("startedService: start service")
        val startedIntent = StartedService.createServiceIntent(context = context, title = "Hello")
        requireContext().startService(startedIntent)

        println("boundService: start service")
        val boundIntent = BoundService.createServiceIntent(context = context, title = "Hi")
        requireContext().bindService(boundIntent, this, Context.BIND_AUTO_CREATE)

        binding.startBoundServiceButton.setOnClickListener {
            if (!isBound) {
                requireContext().bindService(boundIntent, this, Context.BIND_AUTO_CREATE)
                isBound = true
                boundService?.performBackgroundTask(::updateTittleTextView)
            }
            boundService?.performBackgroundTask(::updateTittleTextView)
        }

        binding.titleTextView.setOnClickListener {
            if (isBound) {
                requireContext().unbindService(this)
                isBound = false
            }
        }
    }

    fun updateTittleTextView(title: String) {
        binding.titleTextView.text = title
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        boundService = (service as BoundService.LocalBinder).getService()
        isBound = true
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        boundService = null
        isBound = false
    }

}