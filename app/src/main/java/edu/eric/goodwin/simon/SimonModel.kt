package edu.eric.goodwin.simon

import android.util.Log
import kotlin.random.Random

const val Red = 0
const val Blue = 1
const val Yellow = 2
const val Green = 3

const val Testing = 2
const val Easy = 3
const val Regular = 5
const val Hard = 10
const val Ultra = 50

class SimonModel {
    /*gameModes
    Testing = 2
    Easy = 3
    Regular = 5
    Hard = 10
    Ultra = 50
     */

    private var gameMode: Int = 2

    private var wasPlayerAnswerCorrect: Boolean? = null
    private var expectedAnswerIs: Int = 0
    private var receivedAnswer: Int? = null
    private var currentPlayerPosition: Int = 0
    private var gameBoardColors: List<Int> = emptyList()
    private var playerScore: Int = 0


    val round: Int = 0

    fun determineIfExpectedAnswerWasGiven() {
        expectedAnswerIs = gameBoardColors[currentPlayerPosition]
        if (receivedAnswer == expectedAnswerIs) {
            // award points
            // advance position
            currentPlayerPosition.plus(1)
            // continue game
        } else {
            //load new fragment
            //game over
        }
    }

    fun getPlayerScore(): Int {
        return playerScore
    }

    fun getPlayerAnswer() {


    }

    fun calculateScore() {
        playerScore = playerScore + (10 * gameMode)
        Log.e("TAG", "score is " + playerScore)

    }

    fun createAGameBoard(gameMode: Int): List<Int>? {

        if (gameMode == 2) {
            gameBoardColors = List(Testing) { Random.nextInt(0, 4) }
        }
        if (gameMode == 3) {
            gameBoardColors = List(Easy) { Random.nextInt(0, 4) }
        }
        if (gameMode == 5) {
            gameBoardColors = List(Regular) { Random.nextInt(0, 4) }
        }
        if (gameMode == 10) {
            gameBoardColors = List(Hard) { Random.nextInt(0, 4) }
        }
        if (gameMode == 50) {
            gameBoardColors = List(Ultra) { Random.nextInt(0, 4) }
        } else {
            Log.e("TAG", "Error - gameMode not selected.")
        }

        return gameBoardColors
    }

    fun setDifficulty(difficulty: String) {
        if (difficulty == "Easy") {
            gameMode = Easy
        }
        if (difficulty == "Regular") {
            gameMode = Regular
        }
        if (difficulty == "Hard") {
            gameMode = Hard
        }
        if (difficulty == "Ultra") {
            gameMode = Ultra
        }
        Log.e("TAG", "Gamemode changed to " + gameMode)
    }
}

