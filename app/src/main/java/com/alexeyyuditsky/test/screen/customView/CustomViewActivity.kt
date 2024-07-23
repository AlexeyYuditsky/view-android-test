package com.alexeyyuditsky.test.screen.customView

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.os.PowerManager
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.ActivityCustomViewBinding
import com.alexeyyuditsky.test.screen.customView.ball.BallViewFragment
import com.alexeyyuditsky.test.screen.customView.circleDiagram.CirceDiagramFragment
import com.alexeyyuditsky.test.screen.customView.drawCircle.DrawCircleViewFragment
import com.alexeyyuditsky.test.screen.customView.pyramid.PyramidViewFragment

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

        binding.circleDiagramView.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CirceDiagramFragment())
                .commit()
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        log("NotificationManager ${notificationManager.hashCode()}", "555")
        log("LocationManager ${locationManager.hashCode()}", "555")

        val sharedPref1 = this.getSharedPreferences("1", MODE_PRIVATE)
        val sharedPref2 = applicationContext.getSharedPreferences("1", MODE_PRIVATE)
        log("SharedPreferences1 ${sharedPref1.hashCode()}", "555")
        log("SharedPreferences2 ${sharedPref2.hashCode()}", "555")
    }
}