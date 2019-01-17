package com.yuxi.shader.bitmap_shader

import android.annotation.TargetApi
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.yuxi.shader.R


class CircleShaderView:View {
    lateinit var mBitmap:Bitmap
    lateinit var mBitmapShader:BitmapShader
    lateinit var mPaint :Paint
    constructor(context:Context):super(context){
        init()
    }
    constructor(context: Context,attributeSet: AttributeSet?):super(context,attributeSet){
        init()
    }
    constructor(context: Context,attributeSet: AttributeSet?,defStyleAttr:Int):super(context,attributeSet,defStyleAttr){
        init()
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int, defStyleRes:Int):super(context,attributeSet,defStyleAttr,defStyleRes){
        init()
    }

    fun init(){
        mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.icon_1)
        mBitmapShader = BitmapShader(mBitmap,Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mPaint = Paint()
        mPaint.flags = Paint.ANTI_ALIAS_FLAG
        mPaint.shader = mBitmapShader

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(width/2f,height/2f,height/3f,mPaint)

    }

}