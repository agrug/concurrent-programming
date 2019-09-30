package grug.tian.concurrent.programming.basic.notify;

import java.util.concurrent.TimeUnit;

/**
 * @author Grug.Tian
 * @date 2019/9/30 19:27
 */
public class T2 extends Thread  {

  @Override
  public void run() {
    try {
      TimeUnit.MILLISECONDS.sleep(50L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (NotifyDemo.getLockObj()) {
      System.out.println("T2线程获取到锁，start");
      System.out.println("T2线程开始唤醒T1线程");
      NotifyDemo.getLockObj().notify();
      try {
        TimeUnit.SECONDS.sleep(2L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("T2线程开始交还锁");
    }
  }
}
