package grug.tian.concurrent.programming.basic.waitnotify;

/**
 * 1. wait()前必须拿到锁
 * 2. wait()会释放锁，并让当前线程处于等待状态
 * 3. 其它线程通过notify()唤醒当前等待中的线程
 * 4. 当前线程必须得获得锁才能完成唤醒，开始执行
 * 5. sleep()和wait最大的不同是sleep不会让出资源
 *
 * @author Grug.Tian
 * @date 2019/9/30 19:15
 */
public class WaitNotifyDemo {

  private static Object lockObj = new Object();

  static Object getLockObj() {
    return lockObj;
  }

  public static void main(String[] args) {
    T1 t1 = new T1();
    T2 t2 = new T2();
    t1.start();
    t2.start();
  }

}
