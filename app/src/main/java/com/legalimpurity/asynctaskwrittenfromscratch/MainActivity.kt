package com.legalimpurity.asynctaskwrittenfromscratch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        androidAsyncTaskButton.setOnClickListener {
            AndroidAsyncTaskImpl(this).execute("http://www.mocky.io/v2/5b49ac2b3100005a008bc03b")
        }
        myAsyncTaskButton.setOnClickListener {
            MyAsyncTaskImpl(WeakReference(this),"http://www.mocky.io/v2/5b49ac2b3100005a008bc03b").execute()
        }
    }
}
