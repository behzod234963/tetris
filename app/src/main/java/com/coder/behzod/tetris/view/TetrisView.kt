package com.coder.behzod.tetris.view

import android.graphics.Paint
import android.view.View
import com.coder.behzod.tetris.models.AppModel
import com.coder.behzod.tetris.ui.GameActivity

class TetrisView: View {

    private val paint= Paint()
    private var lastMove:Long=0
    private var model:AppModel?=null
    private var activity:GameActivity?=null
    private val viewHandler = ViewHandler(this)

}