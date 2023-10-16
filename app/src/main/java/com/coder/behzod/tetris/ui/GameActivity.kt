package com.coder.behzod.tetris.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.coder.behzod.tetris.R
import com.coder.behzod.tetris.databinding.ActivityGameBinding
import com.coder.behzod.tetris.models.AppModel
import com.coder.behzod.tetris.storage.sharedPrefernces.AppPreferences
import com.coder.behzod.tetris.view.TetrisView

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding
    var preferences :AppPreferences?=null
    lateinit var tetrisView:TetrisView
    private val appModel:AppModel=AppModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        mainController()

    }

    private fun initViews() {
        tetrisView=findViewById(R.id.tetrisView)
        preferences= AppPreferences(this)
        appModel.setPreferences(preferences)
    }

    private fun mainController() {

        binding.apply {
            tetrisView.setActivity(this@GameActivity)
            tetrisView.setModel(appModel)
        }
        updateHighScore()
        updateCurrentScore()
        listeners()

    }

    private fun listeners() {
        binding.apply {
            btnRestart.setOnClickListener {onBtnRestart()}
            tetrisView.setOnTouchListener(this@GameActivity::onTetrisViewTouch)
        }
    }
    private fun onBtnRestart(){
        appModel.restartGame()
    }
    private fun onTetrisViewTouch(view: View, event:MotionEvent) :Boolean{
        if (appModel.isGameOver() || appModel.isGameAwaitingStart()){
            appModel.startGame()
            binding.tetrisView.setGameCommandWithDelay(AppModel.Motions.DOWN)
        }else if (appModel.isGameActive()){
            when(resolveTouchDirection(view,event)){
                0->moveTetramino(AppModel.Motions.LEFT)
                1->moveTetramino(AppModel.Motions.ROTATE)
                2->moveTetramino(AppModel.Motions.DOWN)
                3->moveTetramino(AppModel.Motions.RIGHT)
            }
        }
        return true
    }

    fun updateHighScore() {
        binding.tvHighScore.text = "${preferences?.getHighScore()}"
    }
    private fun resolveTouchDirection(view: View,event: MotionEvent):Int{
        val x =  event.x/view.width
        val y = event.y/view.height
        val direction:Int
        direction=if (y>x){
            if(x>1-y) 2 else 0
        }else{
            if (x>1-y) 3 else 1
        }
        return direction
    }
    private fun moveTetramino(motion:AppModel.Motions){
        if(appModel.isGameActive()){
            tetrisView.setGameCommand(motion)
        }
    }
    fun updateCurrentScore() {
        binding.tvCurrentScore.text = "0"
    }

}