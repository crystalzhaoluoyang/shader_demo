package com.yuxi.shader.bitmap_shader

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import com.yuxi.shader.R

class MirrorView :View{
    lateinit var paint :Paint
    lateinit var mSrcBitmap:Bitmap
    lateinit var mRefBitmap :Bitmap
    lateinit var mDufferMode:PorterDuffXfermode

    constructor(context: Context,attributeSet: AttributeSet?):this(context,attributeSet,0){

    }
    var screenWidth=1
    var scale = 0f
    lateinit var shader:LinearGradient
    lateinit var scaledBitmap:Bitmap
    constructor(context:Context,attributeSet:AttributeSet?,defStyle:Int):super(context,attributeSet,defStyle){
        paint = Paint()
       val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        screenWidth=windowManager.defaultDisplay?.width?:1
        mSrcBitmap = BitmapFactory.decodeResource(resources, R.mipmap.view_pic)
        scale =screenWidth.toFloat()/mSrcBitmap.width
        scaledBitmap = Bitmap.createScaledBitmap(mSrcBitmap,screenWidth,(mSrcBitmap.height*scale).toInt(),true)
        shader = LinearGradient(0f,mSrcBitmap.height*scale,0f,mSrcBitmap.height*scale*2f,
            0xf0000000.toInt(),0x00000000.toInt(),Shader.TileMode.CLAMP)
        val matrix = Matrix()
        matrix.setScale(1f,-1f)
        mRefBitmap = Bitmap.createBitmap(scaledBitmap,0,0,screenWidth,(mSrcBitmap.height*scale).toInt(),matrix,true)

        mDufferMode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
      //  canvas?.drawColor(Color.BLACK)
        canvas?.drawBitmap(scaledBitmap,0f,0f,null)
        canvas?.drawBitmap(mRefBitmap,0f,mSrcBitmap.height.toFloat()*scale,null)
        paint.xfermode = mDufferMode
        paint.shader = shader
        canvas?.drawRect(0f,mSrcBitmap.height*scale,screenWidth.toFloat(),mSrcBitmap.height.toFloat()*scale*2f,paint)
        paint.xfermode = null
      /*  paint.shader=null
        paint.color = Color.WHITE
        canvas?.drawRect(0f,mSrcBitmap.height.toFloat()*scale,screenWidth.toFloat(),mSrcBitmap.height.toFloat(),paint)*/
    }
}