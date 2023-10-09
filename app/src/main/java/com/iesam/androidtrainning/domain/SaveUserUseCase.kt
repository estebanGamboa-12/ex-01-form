package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.data.UserDataRepository
import com.iesam.kotlintrainning.Either

class SaveUserUseCase(private val repository: UserRepository) {

    operator fun invoke(input: Input): Either<ErrorApp, Boolean> {
        return repository.save(input);
    }

    data class Input(val username: String, val surname: String)
}