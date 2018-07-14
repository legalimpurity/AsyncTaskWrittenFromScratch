package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.executors

import android.os.Looper
import java.util.concurrent.Executor

class MainThreadExecutor : Executor
{
    private val handler = android.os.Handler(Looper.getMainLooper())

    override fun execute(runnable: Runnable?) {
        handler.post(runnable)
    }
}