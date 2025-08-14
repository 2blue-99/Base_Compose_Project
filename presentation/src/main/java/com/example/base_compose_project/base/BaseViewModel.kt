package com.example.base_compose_project.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.plus
import timber.log.Timber

interface UIState
interface UIEffect
interface UIEvent

open class BaseViewModel<Event: UIEvent, State: UIState, Effect: UIEffect>: ViewModel() {

    val modelScope = viewModelScope + exceptionHandler()
    val ioScope = CoroutineScope(Dispatchers.IO) + exceptionHandler()

    private fun exceptionHandler() = CoroutineExceptionHandler { coroutineContext, throwable ->
        Timber.e("ERR : $throwable")
    }
}