package com.alexeyyuditsky.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("MainActivity2 onCreate")
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Fragment1())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        log("MainActivity2 onStart")
    }

    override fun onResume() {
        super.onResume()
        log("MainActivity2 onResume")
    }

    override fun onPause() {
        super.onPause()
        log("MainActivity2 onPause")
    }

    override fun onStop() {
        super.onStop()
        log("MainActivity2 onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("MainActivity2 onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("MainActivity2 onDestroy")
    }
}