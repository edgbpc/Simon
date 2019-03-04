package edu.eric.goodwin.simon

import android.util.Log
import android.widget.Toast
import kotlin.random.Random

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

    private var gameMode: Int = 0

    private var expectedAnswerIs: Int = 0
    private var currentPlayerPosition: Int = 0
    private var gameBoardColors = ArrayList<Int>()
    private var playerScore: Int = 0
    private var numCorrectAnswersGiven: Int = 0
    private var gameWinner: Int = -1
    private var roundWinner: Int = -1
    private var numCorrectAnswersForARound: Int = 0
    private var finalScore: Int = 0


    private var round: Int = 0

    fun addToGameBoardColors() {
        if (gameBoardColors.size < gameMode){
            gameBoardColors.add(Random.nextInt(0,4))
        }

    }

    fun scoreAccumulator(){
        finalScore += playerScore


    }

    fun resetGame(){
        expectedAnswerIs = 0
        gameBoardColors = ArrayList<Int>()
        currentPlayerPosition = 0
   //     playerScore = 0
        numCorrectAnswersGiven = 0
        gameWinner = -1
        roundWinner = -1
        round = 0
        numCorrectAnswersForARound = 0
    }

    fun resetScore(){
        playerScore = 0
        finalScore = 0
    }

    fun prepareForNewRound(){
        currentPlayerPosition = 0
        roundWinner = -1
        numCorrectAnswersForARound = 0
        addToGameBoardColors()
        playerScore = 0

    }

    fun determineIfExpectedAnswerWasGiven(receivedAnswer: Int) {
        expectedAnswerIs = gameBoardColors[currentPlayerPosition]
        if (receivedAnswer == expectedAnswerIs) {
            // award points
            calculateScore()
            // advance position
            currentPlayerPosition++
            numCorrectAnswersForARound = numCorrectAnswersForARound + 1
            // continue game
        } else {
            gameWinner = 0
            //game over
        }
        if (numCorrectAnswersForARound == gameBoardColors.size){
            roundWinner = 1
            round++
            // player must win a round to get points, not just get a correct color in a round
            scoreAccumulator()
        }

        if (round == gameMode){
            gameWinner = 1
        }
    }

    fun getFinalScore(): Int{
        return finalScore
    }

    fun isAWinner(): Int{
        return gameWinner
    }

    fun getPlayerScore(): Int {
        return playerScore
    }

    fun getGameBoard(): List<Int> {
        return gameBoardColors

    }

    fun isARoundWinner(): Int {
        return roundWinner
    }

    fun calculateScore() {
        playerScore = playerScore + (10 * gameMode)
        Log.e("TAG", "score is " + playerScore)
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
    }
}

