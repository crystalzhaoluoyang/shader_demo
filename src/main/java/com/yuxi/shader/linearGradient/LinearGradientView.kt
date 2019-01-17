package com.yuxi.shader.linearGradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class LinearGradientView:View {
    constructor(context: Context):this(context,null){}
    constructor(context: Context, attributeSet: AttributeSet?):this(context,attributeSet,0){

    }
    lateinit var mPaint: Paint
    constructor(context: Context, attributeSet: AttributeSet?, defStyle:Int):super(context,attributeSet,defStyle){

        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(mPaint.shader==null)
            mPaint.shader = LinearGradient(0f,height/2f,width/10f,height/2f, Color.BLACK, Color.BLUE, Shader.TileMode.MIRROR)
        canvas?.drawCircle(width/2f,height/2f,height/3f,mPaint)

    }

}