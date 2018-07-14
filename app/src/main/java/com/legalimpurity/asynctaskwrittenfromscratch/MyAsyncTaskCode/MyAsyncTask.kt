package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode

import com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.executors.ExecutorProvider
import java.util.concurrent.Callable
import java.util.concurrent.Future

abstract class MyAsyncTask(){

    // Functions to be implemented by the user.
    abstract fun doInBackground()
    abstract fun onPreExecute()
    abstract fun onPostExecute()

    fun execute() {
        onPreExecute()

        ExecutorProvider.backgroundTaskExecutor?.let {
            val future : Future<Boolean> = it.submit(Callable<Boolean>
            {
                doInBackground()
                true
            })
            future.get()
        }

        onPostExecute()
    }
}