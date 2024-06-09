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
        getCompetitions()
    }

    private val _competitions =
        MutableStateFlow<Resource<List<Competition>>>(Resource.Loading)
    val competitions: Flow<Resource<List<Competition>>> = _competitions

    private fun getCompetitions() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val competitions = getCompetitionsUseCase()
                _competitions.value = Resource.Success(competitions.first())
            } catch (e: Exception) {
                _competitions.value = Resource.Error(e)
            }
        }
    }

}