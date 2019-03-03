package edu.eric.goodwin.simon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log



class SimonModelFragment: Fragment() {

    var listener: Listener? = null
    var testSetList: ArrayList<Int> = arrayListOf<Int>()
    var gamePlaySequence: MutableList<Int> = mutableListOf<Int>()

    interface Listener {
        fun sequenceTriggerd()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

     }

    fun startSequence() {
        listener?.sequenceTriggerd()

    }

    /*
    fun addToGamePlaySequence() {
        var nextInt = (0..3).random()
        gamePlaySequence.add(nextInt)
    }
    */

}