package grug.tian.concurrent.programming.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Grug.Tian
 * @date 2019-02-23 17:00
 */
public class App {

  private static ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
      new ArrayBlockingQueue<>(50),
      new ThreadFactoryBuilder().setNameFormat("threadPool-%d").build()
  );

  public static void main(String[] args) {
    for (int i = 0; i < 70; i++) {
      int count = i + 1;
      threadPool.execute(() -> {
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          System.out.println("意外中断");
        }
        System.out.println("第" + count + "次任务, 线程名: " + Thread.currentThread().getName());
      });
    }

    threadPool.shutdown();
  }

}
