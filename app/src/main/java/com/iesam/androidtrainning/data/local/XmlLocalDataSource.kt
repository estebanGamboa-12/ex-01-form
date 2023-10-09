package com.iesam.androidtrainning.data.local

import android.content.Context
import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.domain.SaveUserUseCase
import com.iesam.androidtrainning.domain.User
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right
import java.lang.Exception

class XmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)

    fun saveUser(input: SaveUserUseCase.Input): Either<ErrorApp, Boolean> {
        return try {
            with(sharedPref.edit()) {
                putInt("id", (1..100).random())
                putString("username", input.username)
                putString("surname", input.surname)

                apply()
            }
            true.right()
        } catch (ex: Exception) {
            ErrorApp.UnknowError.left()
        }
    }

    fun findUser(): Either<ErrorApp, User> {
        return try {
            User(
                sharedPref.getInt("id", 0),
                sharedPref.getString("username", "")!!,
                sharedPref.getString("surname", "")!!

            ).right()
        } catch (ex: Exception) {
            return ErrorApp.UnknowError.left()
        }
    }
}