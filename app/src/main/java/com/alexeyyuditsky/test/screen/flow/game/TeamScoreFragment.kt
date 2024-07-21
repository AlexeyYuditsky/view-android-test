package com.alexeyyuditsky.test.screen.flow.game

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentTeamScoreBinding
import kotlinx.coroutines.launch

class TeamScoreFragment :
    AbstractFragment<FragmentTeamScoreBinding>(R.layout.fragment_team_score), UiActions {

    private val viewModel by viewModels<TeamScoreViewModel>()
    override fun bind(view: View) = FragmentTeamScoreBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teamOneLogoTextView.setOnClickListener { viewModel.increaseTeamOneScore() }
        binding.teamTwoLogoTextView.setOnClickListener { viewModel.increaseTeamTwoScore() }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.state.collect {
                    when (it) {
                        is TeamScoreState.Game -> {
                            binding.teamOneScoreTextView.text = it.score1.toString()
                            binding.teamTwoScoreTextView.text = it.score2.toString()
                        }

                        is TeamScoreState.Winner -> {
                            binding.teamOneScoreTextView.text = it.score1.toString()
                            binding.teamTwoScoreTextView.text = it.score2.toString()
                        }
                    }
                }
            }


        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.action.collect { uiAction ->
                    uiAction.apply(this@TeamScoreFragment)
                }
            }
        }
    }

    override fun showWinner(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}