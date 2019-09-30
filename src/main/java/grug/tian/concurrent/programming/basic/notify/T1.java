package grug.tian.concurrent.programming.basic.notify;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Grug.Tian
 * @date 2019/9/30 19:25
 */
@Slf4j
public class T1 extends Thread {

  @Override
  public void run() {
    synchronized (NotifyDemo.getLockObj()) {
      log.info("T1线程获取到锁，start");
      try {
        System.out.println("T1线程交出锁");
        NotifyDemo.getLockObj().wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("T1线程重新获取到锁");
      System.out.println("T1线程end");
    }

  }
}
