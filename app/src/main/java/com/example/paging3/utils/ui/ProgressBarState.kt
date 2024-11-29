package com.example.paging3.utils.ui

sealed class ProgressBarState {

    data object Loading: ProgressBarState()

    data object Idle: ProgressBarState()

}