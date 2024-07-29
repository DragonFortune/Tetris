package com.example.tetris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GameViewModel {

    private val game: GameModel = GameModel()
    private val _points = MutableLiveData<Int>()
    val points: LiveData<Int> = _points

    init {
        _points.value = game.points
    }

    fun loseALine(){
        game.loseAline()
        _points.value = game.points
    }
}