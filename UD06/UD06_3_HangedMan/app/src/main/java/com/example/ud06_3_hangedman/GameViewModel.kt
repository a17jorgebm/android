package com.example.ud06_3_hangedman

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words= listOf("Calamar","Android","Caballo")
    var targetWord = words.random().uppercase()

    var targetWordHidden=""
    var lives=7

    //cousas raras con esto, non me pon o espacio
    init {
        targetWordHidden = targetWord.map { "_" }.joinToString(" ")
    }
    fun showTargetWordHidden(charAttempt: Char = ' '):String {
        targetWordHidden = targetWord
            .map {
                if (it==' ') return ' '.toString()
                if (targetWordHidden.contains(it)) return it.toString()
                if(it.equals(charAttempt)) charAttempt else '_'
            }.joinToString(" ")
        return targetWordHidden
    }

    fun guess(charAttempt : Char):Int{
        if (targetWord.contains(charAttempt)){
            showTargetWordHidden(charAttempt)
        }else{
            return --lives
        }
        return lives
    }
}