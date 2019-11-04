package grug.tian.concurrent.programming.basic.deamon;

import java.util.concurrent.TimeUnit;

/**
 * @author Grug.Tian
 * @date 2019/11/4 17:22
 */
public class DaemonThread extends Thread {

  @Override
  public void run() {
    while (true) {
      System.out.println("Daemon thread is alive");
      try {
        TimeUnit.SECONDS.sleep(1L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
