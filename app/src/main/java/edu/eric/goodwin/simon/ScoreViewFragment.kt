package edu.eric.goodwin.simon


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_score.view.*

class ScoreViewFragment : Fragment() {

    interface NewGameButtonListener {
        fun newGameButtonPressed()
    }

    var listener: NewGameButtonListener? = null

    private var score: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_score, container, false)

        view.newGameButton.setOnClickListener {
            listener?.newGameButtonPressed()
            Log.e("TAG", "New Game button pressed- from onCreateView")
        }

        var textView = view.findViewById(R.id.playerScoreTextView) as TextView
        textView.setText(score.toString())

        return view
        }

    fun receieveScore(receivedScore: Int){
        score = receivedScore
        Log.e("TAG", "score is " + score )


    }
    }

