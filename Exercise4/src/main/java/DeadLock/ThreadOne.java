package DeadLock;

import java.util.List;

public class ThreadOne extends Thread{
    public final Object lock1;
    public final Object lock2;

    private List<Integer> list1;

    private List<Integer> list2;

    public ThreadOne(List<Integer> list1, List<Integer> list2, Object lock1, Object lock2){
        this.list1 = list1;
        this.list2 = list2;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run(){
        synchronized (lock1){
            System.out.println("lock2 locked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
            }
            synchronized (lock2){
                list1.add(1);

            }
        }
    }
}
