package com.example.huhai.badgeredview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import kotlin.math.max


/*
 *  @项目名：  BadgeView 
 *  @包名：    com.example.huhai.badgeredview
 *  @文件名:   BadgeView
 *  @创建者:   huhai
 *  @创建时间:  2018/12/12 17:15
 *  @描述：    
 */
class BadgeView : TextView {
    private val TAG: String = "BadgeView"
    var mPaint: Paint = Paint()
    var mTextPaint: Paint = Paint()
    var bgclor: Int = R.color.red
    var isshowfull: Boolean = true
    var showText: String = "0"


    constructor(context: Context?) : super(context) {
        init(context, null)
        initpaint()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
        initpaint()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        init(context, attrs)
        initpaint()

    }


    fun init(context: Context?, attrs: AttributeSet?) {
        val typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.BadgeView)
        isshowfull = typedArray.getBoolean(R.styleable.BadgeView_isShowAllNumber, true)
        bgclor = typedArray.getColor(R.styleable.BadgeView_bgcolor, this.getResources().getColor(R.color.red))
        Log.d(TAG, isshowfull.toString());
        typedArray.recycle()
    }


    fun initpaint() {
        mPaint = Paint();
        mPaint.strokeWidth = 5.0f
        mPaint.style = Paint.Style.FILL

        mTextPaint = paint
        mTextPaint.style = Paint.Style.FILL
        mTextPaint.color = this.currentTextColor
        mTextPaint.setTextAlign(Paint.Align.CENTER)
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d(TAG, "onDraw  " + isshowfull)
        if (this.text.toString().length > 2) {
            if (isshowfull) {
                showText = this.text.toString()
            } else {
                showText = "99+"
            }
        } else {
            showText = this.text.toString()
        }
        canvas!!.drawText(showText, (this.width / 2).toFloat(), (this.height / 2).toFloat() + getFontHeight(mTextPaint), mTextPaint)
    }


    /*根据paint获取绘制文字的宽高*/
    fun getFontHeight(paint: Paint): Float {

        var fm = paint.getFontMetrics()

        return fm.descent / 2 - fm.top / 2 - fm.bottom

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (this.text.toString().length <= 1) {
            var rectShape = this.Oval()
            val shapeDrawable = ShapeDrawable(rectShape as Shape)
            shapeDrawable.paint.color = bgclor
            this.setBackgroundDrawable(shapeDrawable)

        } else {
            val ra = this.height / 2  //外矩形 左上、右上、右下、左下的圆角半径
            val outerR = floatArrayOf(ra.toFloat(), ra.toFloat(), ra.toFloat(), ra.toFloat(), ra.toFloat(), ra.toFloat(), ra.toFloat(), ra.toFloat())
            val rectShape = RoundRectShape(outerR, null as RectF?, null as FloatArray?)
            val shapeDrawable = ShapeDrawable(rectShape as Shape)
            shapeDrawable.paint.color = bgclor
            this.setBackgroundDrawable(shapeDrawable)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (this.text.toString().length <= 1) {
            setMeasuredDimension(max(this.measuredHeight, this.measuredWidth), max(this.measuredHeight, this.measuredWidth))

        }

    }


    private inner class Oval : OvalShape() {
        override fun draw(canvas: Canvas, paint: Paint) {
            val viewWidth = this.getWidth()
            val viewHeight = this.getHeight()
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, max(viewWidth / 2, viewHeight / 2), paint)
        }
    }

}