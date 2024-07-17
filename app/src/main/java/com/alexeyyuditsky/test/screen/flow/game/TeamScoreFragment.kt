package com.alexeyyuditsky.test.screen.flow.game

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentTeamScoreBinding

class TeamScoreFragment : AbstractFragment<FragmentTeamScoreBinding>(R.layout.fragment_team_score) {

    private val viewModel by viewModels<TeamScoreViewModel>()
    override fun bind(view: View) = FragmentTeamScoreBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teamOneLogoTextView.setOnClickListener { viewModel.increaseScore(Team.TEAM_1) }
        binding.teamTwoLogoTextView.setOnClickListener { viewModel.increaseScore(Team.TEAM_2) }

        viewModel.state.observe(viewLifecycleOwner) {
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

}