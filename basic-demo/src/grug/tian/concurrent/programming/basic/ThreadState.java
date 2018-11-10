package grug.tian.concurrent.programming.basic;

public class ThreadState {
    /**
     * 输出所有的线程状态
     *
     * NEW              线程被构建，但还未执行start()
     * RUNNABLE         可执行状态，表示拥有CPU执行权，但不一定在执行。可以细分为ready状态和running状态
     * BLOCKED          阻塞状态，例如等待锁释放
     * WAITING
     * TIMED_WAITING    时间等待状态，超过一定时限后可以自动装换为RUNNABLE状态，例如对线程进行sleep()操作
     * TERMINATED       执行结束状态
     */
    private static void printAllThreadState() {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state.name());
        }
    }

    public static void main(String[] args) {
        printAllThreadState();
    }
}
