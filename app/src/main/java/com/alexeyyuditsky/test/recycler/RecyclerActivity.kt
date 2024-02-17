package com.alexeyyuditsky.test.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.R

class RecyclerActivity : AppCompatActivity(R.layout.activity_recycler) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RecyclerFragment())
                .commit()
        }
    }
}