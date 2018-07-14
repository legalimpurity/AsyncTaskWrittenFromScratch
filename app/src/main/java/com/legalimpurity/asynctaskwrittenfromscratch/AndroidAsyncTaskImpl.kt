package com.legalimpurity.asynctaskwrittenfromscratch

import android.os.AsyncTask
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URL

class AndroidAsyncTaskImpl(mainActivity : MainActivity) : AsyncTask<String, Void, String>() {

    private val activityReference: WeakReference<MainActivity> = WeakReference(mainActivity)

    val LOG_TAG = "AndroidAsyncTask_Logs"
    override fun onPreExecute() {
        super.onPreExecute()
        Log.d(LOG_TAG,"onPreExecuteCalledOn: "+Thread.currentThread().name)
    }

    override fun doInBackground(vararg urlString: String): String {

        Log.d(LOG_TAG,"doInBackgroundCalledOn: "+Thread.currentThread().name)
        var returnString = "ERRORSTRING"
        val url = URL(urlString[0])
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val inputStream = BufferedInputStream(urlConnection.inputStream)

            val bufferedReader  = BufferedReader(InputStreamReader(inputStream) as Reader?)
            returnString = bufferedReader.readLine()

        }finally {
            urlConnection.disconnect()
        }
        return returnString
    }

    override fun onProgressUpdate(vararg progress: Void?) {
        Log.d(LOG_TAG,"onProgressUpdateCalledOn: "+Thread.currentThread().name)
    }

    override fun onPostExecute(output: String) {
        Log.d(LOG_TAG,"onPostExecuteCalledOn: "+Thread.currentThread().name)
        Log.d(LOG_TAG, "taskOutput: $output")
        activityReference.get()?.asyncTaskOutputTextView?.text = output
    }
}