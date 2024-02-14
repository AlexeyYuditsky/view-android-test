package com.alexeyyuditsky.test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ResultReceiver
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        log("MainActivity onCreate")

        binding.openMainActivity2Button.setOnClickListener { onOpenMainActivity2ButtonPressed() }
        binding.openRecyclerViewButton.setOnClickListener { onOpenRecyclerViewButtonPressed() }
    }

    private fun onOpenRecyclerViewButtonPressed() {
        startActivity(Intent(this, MainActivity3::class.java))
    }

    private fun onOpenMainActivity2ButtonPressed() {
        startActivity(
            Intent(this, MainActivity2::class.java).apply {
                putExtra("receiver", object : ResultReceiver(Handler(Looper.getMainLooper())) {
                    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                        super.onReceiveResult(resultCode, resultData)
                    }
                })
            })
    }

    override fun onStart() {
        super.onStart()
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