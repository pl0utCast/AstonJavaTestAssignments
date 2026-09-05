package liveLock;

public class Worker extends Thread {
    private Worker coworker;
    private boolean hasResource1 = false;
    private boolean hasResource2 = false;
    private boolean done = false;

    public Worker(String name, Worker coworker) {
        super(name);
        this.coworker = coworker;
    }

    public void setCoworker(Worker coworker) {
        this.coworker = coworker;
    }

    public void setHasResource1(boolean has) {
        this.hasResource1 = has;
    }

    public void setHasResource2(boolean has) {
        this.hasResource2 = has;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public void run() {
        while (!done) {
            if (hasResource1 && hasResource2) {
                System.out.println(getName() + ": СДЕЛАЛ РАБОТУ!");
                done = true;
                break;
            }

            if (hasResource1 && !hasResource2) {
                System.out.println(getName() + ": у меня ресурс1, прошу у " + coworker.getName() + " ресурс2");
                if (coworker.hasResource2 && !coworker.hasResource1) {
                    hasResource1 = false;
                    coworker.setHasResource1(true);
                    hasResource2 = true;
                    coworker.setHasResource2(false);
                    System.out.println(getName() + ": обменялся! Теперь у меня ресурс2");
                }
            }

            if (!hasResource1 && hasResource2) {
                System.out.println(getName() + ": у меня ресурс2, прошу у " + coworker.getName() + " ресурс1");
                if (coworker.hasResource1 && !coworker.hasResource2) {
                    hasResource2 = false;
                    coworker.setHasResource2(true);
                    hasResource1 = true;
                    coworker.setHasResource1(false);
                    System.out.println(getName() + ": обменялся! Теперь у меня ресурс1");
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + ": ЗАВЕРШИЛ работу!");
    }
}