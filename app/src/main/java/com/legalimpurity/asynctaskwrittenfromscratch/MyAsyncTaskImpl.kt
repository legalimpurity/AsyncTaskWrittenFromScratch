package com.legalimpurity.asynctaskwrittenfromscratch

import android.util.Log
import com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.MyAsyncTask
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URL

class MyAsyncTaskImpl(private val weakReferenceMainActivity : WeakReference<MainActivity>, private val urlString:String) : MyAsyncTask<String>()
{
    val LOG_TAG = "MyAsyncTask_Logs"

    override fun doInBackground(): String {
        Log.d(LOG_TAG,"doInBackgroundCalledOn: "+Thread.currentThread().name)
        var returnString = "ERRORSTRING"
        val url = URL(urlString)
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val inputStream = BufferedInputStream(urlConnection.inputStream)

            val bufferedReader  = BufferedReader(InputStreamReader(inputStream) as Reader?)
            returnString = bufferedReader.readLine()

        }finally {
            urlConnection.disconnect()
        }
        return returnString    }

    override fun onPreExecute() {
        Log.d(LOG_TAG,"onPreExecuteCalledOn: "+Thread.currentThread().name)
    }

    override fun onPostExecute(valueFromDoInBackground: String) {
        Log.d(LOG_TAG,"onPostExecuteCalledOn: "+Thread.currentThread().name)
        Log.d(LOG_TAG, "taskOutput: $valueFromDoInBackground")
        weakReferenceMainActivity.get()?.asyncTaskOutputTextView?.text = valueFromDoInBackground
    }

}