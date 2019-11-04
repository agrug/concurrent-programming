package grug.tian.concurrent.programming.basic.deamon;

/**
 * 用户线程会一直存活
 *
 * @author Grug.Tian
 * @date 2019/11/4 17:28
 */
public class UserDemo {

  public static void main(String[] args) {
    UserThread userThread = new UserThread();
    userThread.start();
  }

}
