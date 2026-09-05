package deadLock;

import java.util.ArrayList;
import java.util.List;

public class DeadLockExample {
    public void main(){
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        ThreadOne threadOne = new ThreadOne(list1, list2, lock1, lock2);
        ThreadTwo threadTwo = new ThreadTwo(list1, list2, lock1, lock2);

        threadOne.start();
        threadTwo.start();
    }
}
