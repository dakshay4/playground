package org.r7d.threading;

import java.util.concurrent.TimeUnit;


public class LabTestWorker {


    public static void main(String[] args) {
        System.out.println("Main start");
        MultiThreadPoolLab lab = new MultiThreadPoolLab(
                2, 4, 5, TimeUnit.MINUTES, 20
        );
        for(int i=0;i<1000;i++) {
            lab.execute(LabTestWorker::worker);
        }
        System.out.println("Main End");

    }

    public static void worker() {
        System.out.println("Worker is working - Thread Name" + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Worker is working - Thread Name" + Thread.currentThread().getName());

    }
}
