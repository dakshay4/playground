package org.r7d.misc;

public class VolatileTest {

    public static int COUNTER=0;

    public static class Thread1 extends Thread{
        @Override
        public void run(){
            while(COUNTER<200) {
                System.out.println("Incrementing in counter thread1: " + (COUNTER++));
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run(){
            while(COUNTER<200)
                System.out.println("Incrementing in counter thread2: " + (COUNTER++));
        }
    }

    public static void main(String[] args) {
        Runnable t1 = () -> {
            while(COUNTER<5)
                System.out.println("Incrementing in counter t1: " + (COUNTER++));

//            int local = COUNTER;
//            while(local<5){
//                if(local!=COUNTER){
//                    System.out.println("Got change in counter " + COUNTER);
//                    local = COUNTER;
//                }
//            }

        };

        Runnable r2 = () -> {
            while(COUNTER<5)

                System.out.println("Incrementing in counter t2: " + (COUNTER++));

//            int local = COUNTER;
//            while(COUNTER<5){
//                System.out.println("Incrementing in counter " + (local+1));
//                COUNTER = ++local;
//                try {
//                    Thread.sleep(500);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        };
        t1.run();
        r2.run();

        new Thread1().start();
        new Thread2().start();

    }


}


/*
arr = [2,3,4,5]
      1  2,6,24
        60,20,5  1
output = [60,40,30,24]



 */