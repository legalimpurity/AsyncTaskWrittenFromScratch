package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode

import com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.executors.ExecutorProvider

abstract class MyAsyncTask(){

    // Functions to be implemented by the user.
    abstract fun doInBackground()
    abstract fun onPreExecute()
    abstract fun onPostExecute()

    fun execute() {
        ExecutorProvider.mainThreadTaskExecutor?.execute {
            onPreExecute()
        }
        ExecutorProvider.backgroundTaskExecutor?.execute {
            doInBackground()
        }
        ExecutorProvider.mainThreadTaskExecutor?.execute {
            onPostExecute()
        }
    }
}