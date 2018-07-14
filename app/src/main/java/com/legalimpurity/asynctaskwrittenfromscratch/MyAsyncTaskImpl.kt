package com.legalimpurity.asynctaskwrittenfromscratch

import android.util.Log
import com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.MyAsyncTask

class MyAsyncTaskImpl : MyAsyncTask<String>()
{
    val LOG_TAG = "MyAsyncTask_Logs"

    override fun doInBackground(): String {
        Log.d(LOG_TAG,"doInBackgroundCalledOn: "+Thread.currentThread().name)
        return ""
    }

    override fun onPreExecute() {
        Log.d(LOG_TAG,"onPreExecuteCalledOn: "+Thread.currentThread().name)
    }

    override fun onPostExecute(valueFromDoInBackground: String) {
        Log.d(LOG_TAG,"onPostExecuteCalledOn: "+Thread.currentThread().name)
    }

}