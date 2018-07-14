package com.legalimpurity.asynctaskwrittenfromscratch

import android.util.Log
import com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.MyAsyncTask

class MyAsyncTaskImpl : MyAsyncTask()
{
    val LOG_TAG = "MyAsyncTask_Logs"

    override fun doInBackground() {
        Log.d(LOG_TAG,"doInBackgroundCalledOn: "+Thread.currentThread().name)
    }

    override fun onPreExecute() {
        Log.d(LOG_TAG,"onPreExecuteCalledOn: "+Thread.currentThread().name)
    }

    override fun onPostExecute() {
        Log.d(LOG_TAG,"onPostExecuteCalledOn: "+Thread.currentThread().name)
    }

}