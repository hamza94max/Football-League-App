package com.example.footballleague.ui.home


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.footballleague.base.BaseFragment
import com.example.footballleague.databinding.FragmentHomeBinding
import com.example.footballleague.domain.models.Competition
import com.example.footballleague.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val competitionsAdapter by lazy { CompetitionsAdapter() }

    private val competitionsViewModel: CompetitionsViewModel by viewModels()

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {

        initUi()

    }

    private fun initUi() {
        binding.competitionsRecyclerView.adapter = competitionsAdapter



        observeResponse()
    }

    private fun observeResponse() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                competitionsViewModel.competitionsFromApi.collect {
                    handleCompetitionsResponse(it)
                }
            }
        }
    }

    private fun handleCompetitionsResponse(resource: Resource<List<Competition>>) {

        when (resource) {

            is Resource.Loading -> {}

            is Resource.Success -> {
                competitionsAdapter.differ.submitList(resource.data)
                Log.d("hamzaCompetitions", "handleCompetitionsResponse: ${resource.data.size}")
            }

            is Resource.Error -> {

                showErrorToast(resource.exception.message.toString() + " ")
                Log.e(
                    "hamzaCompetitions",
                    "handleCompetitionsResponse: ${resource.exception.message}"
                )
            }
        }


    }


}