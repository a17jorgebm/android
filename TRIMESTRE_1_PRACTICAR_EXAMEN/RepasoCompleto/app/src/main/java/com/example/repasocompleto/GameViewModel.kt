package com.example.repasocompleto

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words: List<String> = listOf("Paco","Calamar","Mochila")
    var targetWord: String
    var targetWordHidden: String
    var lives = 7

    init {
        targetWord = words.random().uppercase()
        targetWordHidden = targetWord.map { "_" }.joinToString { " " }
    }


}