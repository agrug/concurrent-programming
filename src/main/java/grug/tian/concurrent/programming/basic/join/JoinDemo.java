package grug.tian.concurrent.programming.basic.join;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * join()在当前线程插入一个异步线程，等异步线程执行完后，当前线程才会继续执行
 *
 * @author Grug.Tian
 * @date 2019/9/30 21:01
 */
@Slf4j
public class JoinDemo {
  @Getter
  private static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    T1 t1 = new T1();
    log.info("T1线程start");
    t1.start();
    t1.join();
    log.info("count: {}", count.get());
  }

}
