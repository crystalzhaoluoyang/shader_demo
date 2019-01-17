package com.yuxi.shader.bitmap_shader

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yuxi.shader.R

class BitmapTileMode:View {
    constructor(context:Context):this(context,null){}
    constructor(context: Context,attributeSet: AttributeSet?):this(context,attributeSet,0){

    }
    lateinit var mPaint:Paint
    constructor(context:Context,attributeSet: AttributeSet?,defStyle:Int):super(context,attributeSet,defStyle){
        val mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
        val mBitmapShader = BitmapShader(mBitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.shader = mBitmapShader


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(width/2f,height/2f,200f,mPaint)
    }
}