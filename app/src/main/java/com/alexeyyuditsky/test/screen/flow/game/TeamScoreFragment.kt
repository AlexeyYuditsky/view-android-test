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
import kotlinx.coroutines.launch

class TeamScoreFragment :
    AbstractFragment<FragmentTeamScoreBinding>(R.layout.fragment_team_score), UiActions {

    private val viewModel by viewModels<TeamScoreViewModel>()
    override fun bind(view: View) = FragmentTeamScoreBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.viewTreeObserver.addOnPreDrawListener {
            log("FINISH DRAW", "a")
            true
        }
    }

    override fun onResume() {
        super.onResume()
        log("onResume", "a")
    }

    override fun showWinner(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}