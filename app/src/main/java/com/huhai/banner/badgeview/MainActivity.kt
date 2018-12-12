package com.huhai.banner.badgeview

import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val TAG: String = "MainActivity"

    var number = 10
    var number2 = 20

    override fun bindlayoutId(): Int {
        return R.layout.activity_main

    }

    override fun init() {
        text1.setOnClickListener {
            number = text1.text.toString().toInt()
            number = number + 1
            Log.d(TAG, number.toString())
            text1.text = number.toString()
        }
        text2.setOnClickListener {
            number2 = text2.text.toString().trim().toInt()
            number2 = number2 - 1
            Log.d(TAG, number2.toString())
            text2.text = number2.toString()

        }
//        text3.setOnClickListener {
//            var number = text3.text.toString().toInt()
//            text3.text = (number++).toString()
//        }
    }


}
