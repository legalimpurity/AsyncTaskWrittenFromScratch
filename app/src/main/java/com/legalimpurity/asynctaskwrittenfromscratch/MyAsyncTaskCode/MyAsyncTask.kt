package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode

abstract class MyAsyncTask(){

    // Functions to be implemented by the user.
    abstract fun doInBackground()
    abstract fun onPreExecute()
    abstract fun onPostExecute()

    fun execute() {

    }
}