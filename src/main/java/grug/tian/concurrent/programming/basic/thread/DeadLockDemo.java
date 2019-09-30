package grug.tian.concurrent.programming.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * 演示死锁 jps 查看当前java进程 jstack 查看Java进程的线程信息
 */
public class DeadLockDemo {

  private static final String LOCK_A = "A";
  private static final String LOCK_B = "B";

  private static void deadLock() {
    Thread thread1 = new Thread(() -> {
      synchronized (LOCK_A) {
        try {
          TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (LOCK_B) {
          System.out.println("thread1 finish");
        }
      }
    }, "lock 1 thread");

    Thread thread2 = new Thread(() -> {
      synchronized (LOCK_B) {
        try {
          TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (LOCK_A) {
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
