package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.data.UserDataRepository
import com.iesam.kotlintrainning.Either

class GetUserUseCase(private val repository: UserRepository) {

    operator fun invoke(): Either<ErrorApp, User> {
        return repository.obtain()
    }
}