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
import com.example.footballleague.domain.models.CompetitionsResponse
import com.example.footballleague.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val competitionsViewModel: CompetitionsViewModel by viewModels()

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {

        initUi()

    }

    private fun initUi() {
        competitionsViewModel.getCompetitions()


        observeResponse()
    }

    private fun observeResponse() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                competitionsViewModel.competitions.collect {
                    handleCompetitionsResponse(it)
                }
            }
        }
    }

    private fun handleCompetitionsResponse(resource: Resource<CompetitionsResponse>) {

        when (resource) {

            is Resource.Loading -> {}

            is Resource.Success -> {

                Log.d("hamzaCompetitions", "handleCompetitionsResponse: ${resource.data}")
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