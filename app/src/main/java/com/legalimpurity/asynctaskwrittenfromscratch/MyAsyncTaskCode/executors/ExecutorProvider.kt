package com.legalimpurity.asynctaskwrittenfromscratch.MyAsyncTaskCode.executors

import java.util.concurrent.*

object ExecutorProvider
{
    private val NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()
    private var backgroundTasksThreadFactory: ThreadFactory = MyThreadFactory()

    var backgroundTaskExecutor: ThreadPoolExecutor
    var mainThreadTaskExecutor: Executor

    init {

        backgroundTaskExecutor = ThreadPoolExecutor(NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                LinkedBlockingDeque<Runnable>(),
                backgroundTasksThreadFactory
        )
        mainThreadTaskExecutor = MainThreadExecutor()
    }
}