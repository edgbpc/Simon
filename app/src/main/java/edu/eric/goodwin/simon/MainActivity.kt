package edu.eric.goodwin.simon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), SimonViewFragment.StateListener, SimonModelFragment.Listener {

    companion object
    {
        const val SIMON_FRAG_TAG = "SimonFragment"
    }

    private var viewFragment: SimonViewFragment? = null
    private var modelFragment: SimonModelFragment? = null
    private var gameModel: SimonModel? = SimonModel()



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewFragment = supportFragmentManager.findFragmentById(R.id.testContainer) as? SimonViewFragment
        if (viewFragment == null)
        {
            viewFragment = SimonViewFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.testContainer, viewFragment!!)
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

        viewFragment?.listener = this
        modelFragment?.listener = this


    }

    override fun startButtonPressed() {
       // modelFragment?.addToGamePlaySequence()
        modelFragment?.startSequence()
    }

    override fun sequenceTriggerd() {
        viewFragment?.runUIUpdate(gameModel?.createAGameBoard(Testing))
    }
}
