package grug.tian.concurrent.programming.basic.notify;

/**
 * @author Grug.Tian
 * @date 2019/9/30 19:15
 */
public class NotifyDemo {

  private static Object lockObj = new Object();

  public static Object getLockObj() {
    return lockObj;
  }

  public static void main(String[] args) {
    T1 t1 = new T1();
    T2 t2 = new T2();
    t1.start();
    t2.start();
  }

}
