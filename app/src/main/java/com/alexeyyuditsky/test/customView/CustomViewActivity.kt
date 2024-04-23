package com.alexeyyuditsky.test.customView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.customView.ball.BallViewFragment
import com.alexeyyuditsky.test.customView.drawCircle.DrawCircleViewFragment
import com.alexeyyuditsky.test.customView.pyramid.PyramidViewFragment
import com.alexeyyuditsky.test.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCustomViewBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ballView.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, BallViewFragment())
                .commit()
        }

        binding.pyramidView.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PyramidViewFragment())
                .commit()
        }

        binding.circleView.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DrawCircleViewFragment())
                .commit()
        }
    }
}