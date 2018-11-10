package grug.tian.concurrent.programming.basic;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    private static final String lockA = "A";
    private static final String lockB = "B";

    private static void deadLock() {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println("thread1 finish");
                }
            }
        }, "lock 1 thread");

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println("thread2 finish");
                }
            }
        }, "lock 2 thread");

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        deadLock();
    }
}
