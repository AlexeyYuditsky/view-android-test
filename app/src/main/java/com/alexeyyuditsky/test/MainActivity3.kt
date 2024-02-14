package com.alexeyyuditsky.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity(R.layout.activity_main3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RecyclerFragment())
                .commit()
        }
    }
}