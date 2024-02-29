package com.example.footballleague.ui.competitionDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.footballleague.R
import com.example.footballleague.base.BaseFragment
import com.example.footballleague.databinding.FragmentCompetitionDetailsBinding
import com.example.footballleague.domain.models.Competition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionDetailsFragment : BaseFragment<FragmentCompetitionDetailsBinding>() {

    private val args: CompetitionDetailsFragmentArgs by navArgs()

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCompetitionDetailsBinding
        get() = FragmentCompetitionDetailsBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {

        setUpCompetitionData(args.competition)
    }

    @SuppressLint("SetTextI18n")
    private fun setUpCompetitionData(competition: Competition) {
        binding.apply {
            Glide
                .with(context!!)
                .load(competition.emblem)
                .placeholder(R.drawable.ball)
                .into(emblemImageView)

            Glide
                .with(context!!)
                .load(competition.area?.flag)
                .into(areaImageView)

            nameTextView.text = "${competition.name} - ${competition.code ?: ""}"
            areaValueTextView.text = "${competition.area?.name} - ${competition.area?.code}"
            typeValueTextView.text = competition.type
            planValueTextView.text = competition.plan
            startDateValueTextView.text = competition.currentSeason?.startDate
            endDateValueTextView.text = competition.currentSeason?.endDate
            matchdayValueTextView.text = competition.currentSeason?.currentMatchday.toString()
            numberOfAvailableSeasonsValueTextView.text =
                competition.numberOfAvailableSeasons.toString()
        }
    }


}