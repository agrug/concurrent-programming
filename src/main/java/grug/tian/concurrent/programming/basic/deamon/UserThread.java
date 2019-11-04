package grug.tian.concurrent.programming.basic.deamon;

import java.util.concurrent.TimeUnit;

/**
 * @author Grug.Tian
 * @date 2019/11/4 17:25
 */
public class UserThread extends Thread {

  @Override
  public void run() {
    while (true) {
      System.out.println("User thread is alive");
      try {
        TimeUnit.SECONDS.sleep(1L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
