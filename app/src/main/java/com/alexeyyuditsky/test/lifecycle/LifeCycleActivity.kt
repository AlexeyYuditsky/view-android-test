package com.alexeyyuditsky.test.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.ActivityContainerBinding

class LifeCycleActivity : AppCompatActivity() {

    private val binding by lazy { ActivityContainerBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<LifeCycleActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("LifeCycleActivity onCreate")

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LifeCycle1Fragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        log("LifeCycleViewModelHashCode: ${viewModel.hashCode()}")
        log("LifeCycleActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        log("LifeCycleActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        log("LifeCycleActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        log("LifeCycleActivity onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("LifeCycleActivity onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("LifeCycleActivity onDestroy")
    }
}