package com.example.footballleague.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballleague.domain.models.CompetitionsResponse
import com.example.footballleague.domain.repo.CompetitionsRepo
import com.example.footballleague.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionsViewModel @Inject constructor(
    private val competitionsRepo: CompetitionsRepo
) : ViewModel() {

    private val _competitions = MutableStateFlow<Resource<CompetitionsResponse>>(Resource.Loading)
    val competitions: Flow<Resource<CompetitionsResponse>> = _competitions

    fun getCompetitions() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _competitions.emit(
                    Resource.Success(
                        competitionsRepo.getCompetitions()
                    )
                )
            } catch (e: Exception) {
                _competitions.emit(
                    Resource.Error(e)
                )
            }
        }
    }

}