package com.legalimpurity.asynctaskwrittenfromscratch

import android.os.AsyncTask
import android.util.Log

class AndroidAsyncTaskImpl : AsyncTask<Void, Void, Void>() {

    val LOG_TAG = "AndroidAsyncTask_Logs"

    override fun onPreExecute() {
        super.onPreExecute()
        Log.d(LOG_TAG,"onPreExecuteCalledOn: "+Thread.currentThread().name)
    }

    override fun doInBackground(vararg aurl: Void?): Void? {
        Log.d(LOG_TAG,"doInBackgroundCalledOn: "+Thread.currentThread().name)
        return null
    }

    override fun onProgressUpdate(vararg progress: Void?) {
        Log.d(LOG_TAG,"onProgressUpdateCalledOn: "+Thread.currentThread().name)
    }

    override fun onPostExecute(unused: Void?) {
        Log.d(LOG_TAG,"onPostExecuteCalledOn: "+Thread.currentThread().name)
    }
}