package com.iesam.androidtrainning.app

sealed class ErrorApp {
    object UnknowError : ErrorApp()
}