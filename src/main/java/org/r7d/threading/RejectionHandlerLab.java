package org.r7d.threading;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectionHandlerLab implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            BlockingQueue<Runnable> runningQueue = executor.getQueue();
            boolean canOffer = runningQueue.offer(r);
            if (canOffer) {
                System.out.println("I got the space inside queue and offering the task to it");
            } else {
                System.out.println("Executor active count - " + executor.getActiveCount());
                System.out.println("Executor completed task - " + executor.getCompletedTaskCount());
                System.out.println("Executor task count - " + executor.getTaskCount());
                Thread.sleep(3000);
                rejectedExecution(r, executor);
            }
        }catch (Exception ex) {
            System.out.println("Exceptin " + ex );
        }
    }
}
