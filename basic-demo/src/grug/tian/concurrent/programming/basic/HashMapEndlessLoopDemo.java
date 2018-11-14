package grug.tian.concurrent.programming.basic;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * HashMap线程不安全示例
 *
 * @author Grug.Tian
 * @date 2018/11/14 10:00 PM
 */
public class HashMapEndlessLoopDemo {

  private static final int PUT_COUNT = 10000;
  private static ExecutorService executorService = Executors.newFixedThreadPool(200);

  public static void main(String[] args) throws InterruptedException {
    final HashMap<String, String> map = new HashMap<>();
    for (int i = 0; i < PUT_COUNT; i++) {
      executorService.execute(() -> map.put(UUID.randomUUID().toString(), ""));
    }
    executorService.shutdown();
    executorService.awaitTermination(10, TimeUnit.SECONDS);

    //观察此处打印的keySet长度和put次数的差异
    System.out.println("PUT_COUNT: " + PUT_COUNT + ", map keySet size: " + map.keySet().size());
  }
}
