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
import com.alexeyyuditsky.test.databinding.FragmentTeamScoreBinding
import kotlinx.coroutines.launch

class TeamScoreFragment : AbstractFragment<FragmentTeamScoreBinding>(R.layout.fragment_team_score) {

    private val viewModel by viewModels<TeamScoreViewModel>()
    override fun bind(view: View) = FragmentTeamScoreBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teamOneLogoTextView.setOnClickListener { viewModel.increaseTeamOneScore() }
        binding.teamTwoLogoTextView.setOnClickListener { viewModel.increaseTeamTwoScore() }

        lifecycleScope.launch {
            viewModel.state
                .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collect {
                    when (it) {
                        is TeamScoreState.Game -> {
                            binding.teamOneScoreTextView.text = it.score1.toString()
                            binding.teamTwoScoreTextView.text = it.score2.toString()
                        }

                        is TeamScoreState.Winner -> {
                            binding.teamOneScoreTextView.text = it.score1.toString()
                            binding.teamTwoScoreTextView.text = it.score2.toString()
                            Toast.makeText(context, "Winner ${it.winnerTeam}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }

        /*viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is TeamScoreState.Game -> {
                    binding.teamOneScoreTextView.text = it.score1.toString()
                    binding.teamTwoScoreTextView.text = it.score2.toString()
                }

                is TeamScoreState.Winner -> {
                    binding.teamOneScoreTextView.text = it.score1.toString()
                    binding.teamTwoScoreTextView.text = it.score2.toString()
                    Toast.makeText(context, "Winner ${it.winnerTeam}", Toast.LENGTH_LONG).show()
                }
            }
        }*/
    }

}