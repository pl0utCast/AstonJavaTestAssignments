package liveLock;

public class LiveLockExample {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Работник 1", null);
        Worker worker2 = new Worker("Работник 2", null);

        worker1.setCoworker(worker2);
        worker2.setCoworker(worker1);

        worker1.setHasResource1(true);
        worker2.setHasResource2(true);

        worker1.start();
        worker2.start();
    }
}