package edu.eric.goodwin.simon

import android.util.Log
import android.widget.Toast
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
    //private var receivedAnswer: Int? = null
    private var currentPlayerPosition: Int = 0
    private var gameBoardColors: List<Int> = emptyList()
    private var playerScore: Int = 0
    private var numCorrectAnswersGiven: Int = 0
    private var gameWinner: Int = -1


    val round: Int = 0

    fun resetGame(){
        gameBoardColors = emptyList()
        currentPlayerPosition = 0
        playerScore = 0
        numCorrectAnswersGiven = 0
        gameWinner = -1

    }

    fun determineIfExpectedAnswerWasGiven(receivedAnswer: Int) {
        expectedAnswerIs = gameBoardColors[currentPlayerPosition]
        if (receivedAnswer == expectedAnswerIs) {
            Log.e("TAG", "Correct Answer Given")
            // award points
            // advance position
            currentPlayerPosition++
            numCorrectAnswersGiven++
            // continue game
        } else {
            Log.e("TAG", "Incorrect Answer Given")
            gameWinner = 0
            //game over
        }
        if (numCorrectAnswersGiven == gameBoardColors.size){
            gameWinner = 1
            Log.e("TAG", "All colors given")
        }
    }

    fun isAWinner(): Int{
        return gameWinner
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

    fun createAGameBoard(): List<Int>? {
        Log.e("tag", "creating gameboard with difficulity " + gameMode)
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

