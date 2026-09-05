package deadLock;

import java.util.List;

public class ThreadTwo extends Thread {
    private Object lock1;
    private Object lock2;

    private List<Integer> list1;

    private List<Integer> list2;

    public ThreadTwo(List<Integer> list1, List<Integer> list2, Object lock1, Object lock2) {
        this.list1 = list1;
        this.list2 = list2;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("lock1 locked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {}
            synchronized (lock1) {
                list2.add(1);
            }
        }

    }
}
