package com.huhai.banner.badgeview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


/*
 *  @项目名：  BadgeView 
 *  @包名：    com.huhai.banner.badgeview
 *  @文件名:   BaseActivity
 *  @创建者:   huhai
 *  @创建时间:  2018/12/12 9:25
 *  @描述：    
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindlayoutId())
        init()
    }


    abstract fun bindlayoutId(): Int

    abstract fun init()
}