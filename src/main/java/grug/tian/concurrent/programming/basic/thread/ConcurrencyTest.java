package grug.tian.concurrent.programming.basic.thread;

/**
 * 该示例演示了上下文切换引发的耗时大于计算本身耗时
 */
public class ConcurrencyTest {

  /** 循环次数较小的情况下，并发执行更加耗时 */
  private static final long COUNT = 100000L;

  public static void main(String[] args) throws InterruptedException {
    concurrency();
    serial();
  }

  private static void concurrency() throws InterruptedException {
    long start = System.currentTimeMillis();

    Thread thread = new Thread(() -> {
      long a = 0L;
      for (long i = 0; i < COUNT; i++) {
        a += 5;
      }
    });
    thread.start();

    long b = 0L;
    for (long i = 0; i < COUNT; i++) {
      b++;
    }
    //此处耗时为 上下文切换耗时 + b累加耗时
    long duration = System.currentTimeMillis() - start;

    thread.join(); //等待子线程执行完毕
    System.out.println("concurrency: " + duration + "ms, b=" + b);
  }

  private static void serial() {
    long start = System.currentTimeMillis();

    long a = 0L;
    for (long i = 0; i < COUNT; i++) {
      a += 5;
    }

    long b = 0;
    for (long i = 0; i < COUNT; i++) {
      b++;
    }
    long duration = System.currentTimeMillis() - start;

    System.out.println("serial: " + duration + "ms, b=" + b);
  }
}
