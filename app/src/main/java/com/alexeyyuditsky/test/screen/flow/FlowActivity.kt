package com.alexeyyuditsky.test.screen.flow

import android.app.NotificationManager
import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.log

class FlowActivity : AppCompatActivity(R.layout.activity_container) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FlowFragment())
                .commit()
        }

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        //log("NotificationManager ${notificationManager.hashCode()}", "555")
        //log("LocationManager ${locationManager.hashCode()}", "555")

        val notificationManager2 = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val locationManager2 = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        //log("NotificationManager ${notificationManager2.hashCode()}", "555")
        //log("LocationManager ${locationManager2.hashCode()}", "555")

        val sharedPref1 = this.getSharedPreferences("1", MODE_PRIVATE)
        val sharedPref2 = applicationContext.getSharedPreferences("1", MODE_PRIVATE)
        //log("SharedPreferences1 ${sharedPref1.hashCode()}", "555")
        //log("SharedPreferences2 ${sharedPref2.hashCode()}", "555")
    }
}