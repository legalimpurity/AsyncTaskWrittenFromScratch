package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode

import com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.executors.ExecutorProvider
import java.util.concurrent.Callable
import java.util.concurrent.Future

abstract class MyAsyncTask<ResultTypeWeWantOnPostExecute>{

    // Functions to be implemented by the user.
    abstract fun doInBackground() : ResultTypeWeWantOnPostExecute
    abstract fun onPreExecute()
    abstract fun onPostExecute(valueFromDoInBackground: ResultTypeWeWantOnPostExecute)

    fun execute() {
        onPreExecute()

        val future: Future<ResultTypeWeWantOnPostExecute> = ExecutorProvider.backgroundTaskExecutor.submit(Callable<ResultTypeWeWantOnPostExecute>
        {
            doInBackground()
        })
        val valueFromDoInBackground = future.get()

        onPostExecute(valueFromDoInBackground)
    }
}