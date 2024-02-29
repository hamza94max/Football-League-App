package com.example.footballleague.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballleague.domain.models.Competition
import com.example.footballleague.domain.usecase.GetCompetitionsUseCase
import com.example.footballleague.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionsViewModel @Inject constructor(
    private val getCompetitionsUseCase: GetCompetitionsUseCase
) : ViewModel() {

    init {
        getCompetitionsFrom()
    }

    private val _competitionsFromApi =
        MutableStateFlow<Resource<List<Competition>>>(Resource.Loading)
    val competitionsFromApi: Flow<Resource<List<Competition>>> = _competitionsFromApi

    private fun getCompetitionsFrom() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val competitions = getCompetitionsUseCase()
                _competitionsFromApi.value = Resource.Success(competitions.first())
            } catch (e: Exception) {
                _competitionsFromApi.value = Resource.Error(e)
            }
        }
    }

}