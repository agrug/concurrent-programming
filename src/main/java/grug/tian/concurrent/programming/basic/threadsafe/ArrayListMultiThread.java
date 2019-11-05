package grug.tian.concurrent.programming.basic.threadsafe;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ArrayList线程不安全示例 Vector线程安全示例
 *
 * @author Grug.Tian
 * @date 2019/11/4 18:01
 */
public class ArrayListMultiThread {

  private static final int ADD_COUNT = 10000;
  private static ExecutorService arrayListPool = Executors.newFixedThreadPool(200);
  private static ExecutorService vectorPool = Executors.newFixedThreadPool(200);

  private static void addArrayList() throws InterruptedException {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < ADD_COUNT; i++) {
      arrayListPool.execute(() -> list.add(1));
    }
    arrayListPool.shutdown();
    arrayListPool.awaitTermination(10, TimeUnit.SECONDS);
    System.out.println("add loop count is " + ADD_COUNT + ", ArrayList size is " + list.size());
  }

  private static void addVector() throws InterruptedException {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < ADD_COUNT; i++) {
      vectorPool.execute(() -> vector.add(1));
    }
    vectorPool.shutdown();
    vectorPool.awaitTermination(10, TimeUnit.SECONDS);
    System.out.println("add loop count is " + ADD_COUNT + ", Vector size is " + vector.size());

  }

  public static void main(String[] args) throws InterruptedException {
    addArrayList();
    addVector();
  }

}
