package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.executors

import java.util.concurrent.ThreadFactory

class MyThreadFactory : ThreadFactory
{
    override fun newThread(runnable: Runnable?) = Thread(runnable)
}