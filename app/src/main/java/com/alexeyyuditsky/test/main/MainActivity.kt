package com.alexeyyuditsky.test.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ResultReceiver
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.screen.animation.AnimationActivity
import com.alexeyyuditsky.test.screen.recycler.RecyclerActivity
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.screen.customView.CustomViewActivity
import com.alexeyyuditsky.test.databinding.ActivityMainBinding
import com.alexeyyuditsky.test.screen.flow.FlowActivity
import com.alexeyyuditsky.test.screen.lifecycle.LifeCycleActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("MainActivity onCreate")

        setContentView(binding.root)

        with(binding) {
            openLifeCycleActivityButton.setOnClickListener { onOpenLifeCycleActivityButtonPressed() }
            openRecyclerActivityButton.setOnClickListener { onOpenRecyclerActivityButtonPressed() }
            openAnimationActivityButton.setOnClickListener { onOpenAnimationActivityButtonPressed() }
            openCustomViewActivityButton.setOnClickListener { onOpenCustomViewActivityButtonPressed() }
            openFlowActivityButton.setOnClickListener { onOpenFlowActivityButtonPressed() }
        }
    }

    private fun onOpenFlowActivityButtonPressed() {
        startActivity(Intent(this, FlowActivity::class.java))
    }

    private fun onOpenCustomViewActivityButtonPressed() {
        startActivity(Intent(this, CustomViewActivity::class.java))
    }

    private fun onOpenAnimationActivityButtonPressed() {
        startActivity(Intent(this, AnimationActivity::class.java))
    }

    private fun onOpenRecyclerActivityButtonPressed() {
        startActivity(Intent(this, RecyclerActivity::class.java))
    }

    private fun onOpenLifeCycleActivityButtonPressed() {
        startActivity(
            Intent(this, LifeCycleActivity::class.java).apply {
                putExtra("receiver", object : ResultReceiver(Handler(Looper.getMainLooper())) {
                    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                        binding.textView.text = resultData?.getString("sample", "empty")
                    }
                })
            })
    }

    override fun onStart() {
        super.onStart()
        log("MainViewModelHashCode: ${viewModel.hashCode()}")
        log("MainActivity onStart")

    }

    override fun onResume() {
        super.onResume()
        log("MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        log("MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        log("MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("MainActivity onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        log("MainActivity onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("MainActivity onSaveInstanceState")
    }
}