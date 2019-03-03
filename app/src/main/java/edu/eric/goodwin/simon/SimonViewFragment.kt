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
    }

    var listener: StateListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_simon, container, false)

        view.startButton.setOnClickListener {
            listener?.startButtonPressed()

        }

        return view
    }

    fun runUIUpdate(args: ArrayList<Int>?) {

        activity?.let {activity ->
            for (index in args.orEmpty()) {
                val view = when (index) {
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


                if (index == 0){
                    redButtonAnimator?.startDelay = (index * 400).toLong()
                    redButtonAnimator?.start()
                }

                if (index == 1){
                    blueButtonAnimator?.startDelay = (index * 400).toLong()
                    blueButtonAnimator?.start()
                }

                if (index == 2){
                    yellowButtonAnimator?.startDelay = (index * 400).toLong()
                    yellowButtonAnimator?.start()
                }

                if (index == 3){
                    greenButtonAnimator?.startDelay = (index * 400).toLong()
                    greenButtonAnimator?.start()
                }


            }
        }
    }
}
