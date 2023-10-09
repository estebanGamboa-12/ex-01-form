package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface UserRepository {

    fun save(input: SaveUserUseCase.Input): Either<ErrorApp, Boolean>
    fun obtain(): Either<ErrorApp, User>
}