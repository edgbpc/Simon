package edu.eric.goodwin.simon

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_score.*
import kotlinx.android.synthetic.main.fragment_score.view.*
import kotlinx.android.synthetic.main.fragment_simon.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class ScoreViewFragment : Fragment() {

    interface NewGameButtonListener {
        fun newGameButtonPressed()
    }

    var listener: NewGameButtonListener? = null

    private var param1: String? = null
    private var param2: String? = null

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

