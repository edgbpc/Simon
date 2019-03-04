package edu.eric.goodwin.simon

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_simon.*
import kotlinx.android.synthetic.main.fragment_simon.view.*

class SimonViewFragment: Fragment() {

    interface StateListener {
        fun startButtonPressed()
        fun redButtonPressed()
        fun blueButtonPressed()
        fun yellowButtonPressed()
        fun greenButtonPressed()
    }

    var listener: StateListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_simon, container, false)

        view.startButton.setOnClickListener {
            listener?.startButtonPressed()
            startButton.setEnabled(false)
            enableColorButtons()
        }
        view.redButton.setOnClickListener {
            listener?.redButtonPressed()

        }
        view.blueButton.setOnClickListener {
            listener?.blueButtonPressed()
        }
        view.yellowButton.setOnClickListener {
            listener?.yellowButtonPressed()
        }
        view.greenButton.setOnClickListener {
            listener?.greenButtonPressed()
        }

        view.redButton.setEnabled(false)
        view.blueButton.setEnabled(false)
        view.greenButton.setEnabled(false)
        view.yellowButton.setEnabled(false)

       return view


    }

    fun runUIUpdate(args: List<Int>?) {

        activity?.let {activity ->
            for (element in 0 until args!!.size ) {
                val view = when (args[element]) {
                    0 -> redButton
                    1 -> blueButton
                    2 -> yellowButton
                    else -> greenButton
                }

                val originalColor = view.background as? ColorDrawable
                val redColorFlash = ContextCompat.getColor(activity, R.color.colorRedFlash)
                val blueColorFlash = ContextCompat.getColor(activity, R.color.colorBlueFlash)
                val yellowColorFlash = ContextCompat.getColor(activity, R.color.colorYellowFlash)
                val greenColorFlash = ContextCompat.getColor(activity, R.color.colorGreenFlash)


                val redButtonAnimator = ValueAnimator.ofObject(
                    ArgbEvaluator(), originalColor?.color, redColorFlash,
                    originalColor?.color
                )
                redButtonAnimator.addUpdateListener { valueAnimator ->
                    (valueAnimator.animatedValue as? Int)?.let {
                        view.setBackgroundColor(it)
                    }
                }

                val blueButtonAnimator = ValueAnimator.ofObject(
                    ArgbEvaluator(), originalColor?.color, blueColorFlash,
                    originalColor?.color
                )
                blueButtonAnimator.addUpdateListener { valueAnimator ->
                    (valueAnimator.animatedValue as? Int)?.let {
                        view.setBackgroundColor(it)
                    }
                }
                val yellowButtonAnimator = ValueAnimator.ofObject(
                    ArgbEvaluator(), originalColor?.color, yellowColorFlash,
                    originalColor?.color
                )
                yellowButtonAnimator.addUpdateListener { valueAnimator ->
                    (valueAnimator.animatedValue as? Int)?.let {
                        view.setBackgroundColor(it)
                    }
                }
                val greenButtonAnimator = ValueAnimator.ofObject(
                    ArgbEvaluator(), originalColor?.color, greenColorFlash,
                    originalColor?.color
                )
                greenButtonAnimator.addUpdateListener { valueAnimator ->
                    (valueAnimator.animatedValue as? Int)?.let {
                        view.setBackgroundColor(it)
                    }
                }

                if (args[element] == 0){
                    redButtonAnimator?.startDelay = (element * 400).toLong()
                    redButtonAnimator?.setDuration(400)
                    redButtonAnimator?.start()

                }

                if (args[element] == 1){
                    blueButtonAnimator?.startDelay = (element * 400).toLong()
                    blueButtonAnimator?.setDuration(400)
                    blueButtonAnimator?.start()
                }

                if (args[element] == 2){
                    yellowButtonAnimator?.startDelay = (element * 400).toLong()
                    yellowButtonAnimator.setDuration(400)
                    yellowButtonAnimator?.start()
                }

                if (args[element] == 3){
                    greenButtonAnimator?.startDelay = (element * 400).toLong()
                    greenButtonAnimator?.setDuration(400)
                    greenButtonAnimator?.start()
                }

            }
        }
    }

    fun enableStartButton(){
        startButton.setEnabled(true)
    }


    fun enableColorButtons(){
        redButton.setEnabled(true)
        blueButton.setEnabled(true)
        greenButton.setEnabled(true)
        yellowButton.setEnabled(true)
    }
    fun disableColorButtons(){
        redButton.setEnabled(false)
        blueButton.setEnabled(false)
        greenButton.setEnabled(false)
        yellowButton.setEnabled(false)
    }

}
