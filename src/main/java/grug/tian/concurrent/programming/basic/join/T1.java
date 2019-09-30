package grug.tian.concurrent.programming.basic.join;

/**
 * @author Grug.Tian
 * @date 2019/9/30 21:01
 */
public class T1 extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      JoinDemo.getCount().addAndGet(1);
    }
  }
}
