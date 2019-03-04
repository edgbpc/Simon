package edu.eric.goodwin.simon

import android.os.Bundle
import android.support.v4.app.Fragment



class SimonModelFragment: Fragment() {

    var listener: Listener? = null

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



}