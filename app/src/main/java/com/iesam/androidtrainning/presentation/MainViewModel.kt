package com.iesam.androidtrainning.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.domain.GetUserUseCase
import com.iesam.androidtrainning.domain.SaveUserUseCase
import com.iesam.androidtrainning.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val saveUserUseCase: SaveUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun saveUser(name: String, surname: String) {
        saveUserUseCase(SaveUserUseCase.Input(name, surname)).fold(
            { responseError(it) },
            { responseSuccess(it) }
        )
    }

    fun loadUser(){
        viewModelScope.launch(Dispatchers.IO) {
            getUserUseCase().fold(
                { responseError(it) },
                { responseGetUserSuccess(it) }
            )
        }
    }

    private fun responseError(errorApp: ErrorApp) {

    }

    private fun responseSuccess(isOk: Boolean) {

    }

    private fun responseGetUserSuccess(user: User) {
        _uiState.postValue(UiState(user = user))
    }

    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val user: User? = null
    )
}