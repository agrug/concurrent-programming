package grug.tian.concurrent.programming.basic.waitnotify;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Grug.Tian
 * @date 2019/9/30 19:27
 */
@Slf4j
public class T2 extends Thread  {

  @Override
  public void run() {
    try {
      TimeUnit.MILLISECONDS.sleep(50L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (WaitNotifyDemo.getLockObj()) {
      log.info("T2线程获取到锁，start");
      log.info("T2线程开始唤醒T1线程");
      WaitNotifyDemo.getLockObj().notify();
      try {
        TimeUnit.SECONDS.sleep(2L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.info("T2线程开始交还锁");
    }
  }
}
