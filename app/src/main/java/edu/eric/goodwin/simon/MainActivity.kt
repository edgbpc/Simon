package edu.eric.goodwin.simon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SimonViewFragment.StateListener, SimonModelFragment.Listener {

    companion object
    {
        const val SIMON_FRAG_TAG = "SimonFragment"
        const val START_FRAG_TAG = "StartFragment"
    }

    private var simonViewFragment: SimonViewFragment? = null
    private var modelFragment: SimonModelFragment? = null

    private var gameModel: SimonModel? = SimonModel()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        difficultySelection.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Log.e("TAG", "User Selected " + radio.text)
            })

        playButton.setOnClickListener {
            var id: Int = difficultySelection.checkedRadioButtonId
            if (id != -1) {
                var radio: RadioButton = findViewById(id)
                var difficultyText: String = radio.text as String
                gameModel?.setDifficulty(difficultyText)
                difficultySelection.setVisibility(View.INVISIBLE)
                playButton.setVisibility(View.INVISIBLE)
                Log.e("TAG", "User CLicked on button " + radio.text)

                simonViewFragment = supportFragmentManager.findFragmentById(R.id.testContainer) as? SimonViewFragment
                if (simonViewFragment == null)
                {
                    simonViewFragment = SimonViewFragment()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.testContainer, simonViewFragment!!)
                        .commit()
                }

                modelFragment = supportFragmentManager.findFragmentByTag(SIMON_FRAG_TAG) as? SimonModelFragment
                if (modelFragment == null)
                {
                    modelFragment = SimonModelFragment()
                        supportFragmentManager.beginTransaction()
                        .add(modelFragment!!, SIMON_FRAG_TAG)
                            .commit()
                }
                simonViewFragment?.listener = this
                modelFragment?.listener = this


               } else {
                        Toast.makeText(applicationContext, "Select A Difficulty", Toast.LENGTH_SHORT).show()
                    }
                }



    }

    override fun startButtonPressed() {
       // modelFragment?.addToGamePlaySequence()
        modelFragment?.startSequence()
    }

    override fun sequenceTriggerd() {
        simonViewFragment?.runUIUpdate(gameModel?.createAGameBoard())
    }

    override fun redButtonPressed() {
        gameModel?.determineIfExpectedAnswerWasGiven(0)
        if (gameModel?.isAWinner() == 1){
            Toast.makeText(applicationContext, "YOU WIN", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()

        } else if (gameModel?.isAWinner() == 0){
            Toast.makeText(applicationContext, "YOU WIN", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()

        }
    }

    override fun blueButtonPressed() {
        gameModel?.determineIfExpectedAnswerWasGiven(1)
        if (gameModel?.isAWinner() == 1) {
            Toast.makeText(applicationContext, "YOU WIN", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()
        } else if(gameModel?.isAWinner() == 0){
            Toast.makeText(applicationContext, "YOU LOST. Play again", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()

        }
    }

    override fun yellowButtonPressed() {
        gameModel?.determineIfExpectedAnswerWasGiven(2)
        if (gameModel?.isAWinner() == 1){
            Toast.makeText(applicationContext, "YOU WIN", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()
        } else if (gameModel?.isAWinner() == 0){
            Toast.makeText(applicationContext, "YOU LOST. Play again", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()

        }
    }

    override fun greenButtonPressed() {
        gameModel?.determineIfExpectedAnswerWasGiven(3)
        if (gameModel?.isAWinner() == 1){
            Toast.makeText(applicationContext, "YOU WIN", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()
        } else if (gameModel?.isAWinner() == 0){
            Toast.makeText(applicationContext, "YOU LOST. Play again", Toast.LENGTH_SHORT).show()
            simonViewFragment?.enableStartButton()
            gameModel?.resetGame()

        }
    }
}
