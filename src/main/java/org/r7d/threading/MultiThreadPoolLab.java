package org.r7d.threading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreadPoolLab extends ThreadPoolExecutor {


    public MultiThreadPoolLab(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, int queueSize) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<>(queueSize), new RejectionHandlerLab());
    }
}
