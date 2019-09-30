package grug.tian.concurrent.programming.basic.waitnotify;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Grug.Tian
 * @date 2019/9/30 19:25
 */
@Slf4j
public class T1 extends Thread {

  @Override
  public void run() {
    synchronized (WaitNotifyDemo.getLockObj()) {
      log.info("T1线程获取到锁，start");
      try {
        log.info("T1线程wait(), 交出锁");
        WaitNotifyDemo.getLockObj().wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.info("T1线程重新获取到锁");
      log.info("T1线程end");
    }

  }
}
