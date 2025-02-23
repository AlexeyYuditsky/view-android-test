package com.alexeyyuditsky.test.screen.graphql.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexeyyuditsky.test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraphQLActivity : AppCompatActivity(R.layout.activity_container) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, GraphQLFragment())
                .commit()
        }
    }

}