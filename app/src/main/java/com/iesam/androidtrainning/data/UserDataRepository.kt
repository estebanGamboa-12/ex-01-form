package com.iesam.androidtrainning.data

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.data.local.XmlLocalDataSource
import com.iesam.androidtrainning.domain.SaveUserUseCase
import com.iesam.androidtrainning.domain.User
import com.iesam.androidtrainning.domain.UserRepository
import com.iesam.kotlintrainning.Either

class UserDataRepository(private val localDataSource: XmlLocalDataSource) : UserRepository {

    override fun save(input: SaveUserUseCase.Input): Either<ErrorApp, Boolean> {
        return localDataSource.saveUser(input)
    }

    override fun obtain(): Either<ErrorApp, User> {
        return localDataSource.findUser()
    }
}