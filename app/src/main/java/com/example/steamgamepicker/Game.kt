package com.example.steamgamepicker

import android.text.Editable

data class Game(
    val gameName: Editable,
    val isChecked: Boolean = false
)