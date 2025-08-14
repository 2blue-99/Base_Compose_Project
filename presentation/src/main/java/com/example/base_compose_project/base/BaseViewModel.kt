package com.example.base_compose_project.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import timber.log.Timber

interface UIState
interface UIEffect
interface UIEvent

abstract class BaseViewModel<State: UIState, Event: UIEvent, Effect: UIEffect>: ViewModel() {
    //**********************************************************************************************
    // Mark: Variable
    //**********************************************************************************************
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    val modelScope = viewModelScope + exceptionHandler()
    val ioScope = CoroutineScope(Dispatchers.IO) + exceptionHandler()


    //**********************************************************************************************
    // Mark: Initialization
    //**********************************************************************************************
    init {
        subScribeEvents()
    }


    //**********************************************************************************************
    // Mark: Function
    //**********************************************************************************************
    private fun subScribeEvents(){
        modelScope.launch {
            event.collect { event ->
                handleEvent(event)
            }
        }
    }

    abstract fun handleEvent(event : Event)

    fun setEvent(event: Event) {
        modelScope.launch {
            _event.emit(event)
        }
    }

    protected fun setState(state: State){
        _uiState.value = state
    }

    protected fun setEffect(effect: Effect){
        modelScope.launch {
            _effect.send(effect)
        }
    }

    private fun exceptionHandler() = CoroutineExceptionHandler { coroutineContext, throwable ->
        Timber.e("ERR : $throwable")
    }
}