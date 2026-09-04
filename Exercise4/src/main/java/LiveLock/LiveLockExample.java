package LiveLock;

public class LiveLockExample {
    public void main() {
        Worker a = new Worker("Алиса", null);
        Worker b = new Worker("Боб", a);
        a.setCoworker(b);

        a.start();
        b.start();
    }
}
