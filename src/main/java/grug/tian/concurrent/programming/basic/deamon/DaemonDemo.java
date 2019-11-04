package grug.tian.concurrent.programming.basic.deamon;

/**
 * 当进程中只剩守护线程是，进程会结束
 *
 * @author Grug.Tian
 * @date 2019/11/4 17:21
 */
public class DaemonDemo {

  public static void main(String[] args) {
    DaemonThread daemonThread = new DaemonThread();
    daemonThread.setDaemon(true);
    daemonThread.start();
  }

}
