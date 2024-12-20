package com.alexeyyuditsky.test.screen.flow.game

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.FragmentTeamScoreBinding
import com.alexeyyuditsky.test.screen.flow.FlowFragment.Companion.logMemoryDetails
import kotlinx.coroutines.launch

class TeamScoreFragment :
    AbstractFragment<FragmentTeamScoreBinding>(R.layout.fragment_team_score), UiActions {

    private val viewModel by viewModels<TeamScoreViewModel>()
    override fun bind(view: View) = FragmentTeamScoreBinding.bind(view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("TeamScoreFragment created at ${System.currentTimeMillis()}", "flow")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("onViewCreated start at ${System.currentTimeMillis()}", "flow")
        view.viewTreeObserver.addOnPreDrawListener {
            log("UI finished drawing at ${System.currentTimeMillis()}", "flow")
            logMemoryDetails(requireContext().applicationContext)
            true
        }
        log("onViewCreated end at ${System.currentTimeMillis()}", "flow")
    }

    override fun onResume() {
        super.onResume()
        log("onResume called at ${System.currentTimeMillis()}", "flow")
    }

    override fun showWinner(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}