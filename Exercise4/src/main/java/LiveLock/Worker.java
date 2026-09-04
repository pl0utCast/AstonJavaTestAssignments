package LiveLock;

public class Worker extends Thread {
    private Worker coworker;
    private boolean active = false;
    private int workProgress = 0;

    public Worker(String name, Worker coworker) {
        super(name);
        this.coworker = coworker;
    }

    public void setCoworker(Worker coworker) {
        this.coworker = coworker;
    }

    private void doWork() {
        workProgress++;
        System.out.println(getName() + ": СДЕЛАЛ РАБОТУ! #" + workProgress);
    }

    @Override
    public void run() {
        while (workProgress < 10) {
            if (active && !coworker.active) {
                System.out.println(getName() + ": я активен, но " + coworker.getName() + " неактивен, уступаю");
                active = false;
                coworker.active = true;
            } else if (!active && coworker.active) {
                System.out.println(getName() + ": жду пока " + coworker.getName() + " уступит");
            } else if (active && coworker.active) {
                System.out.println(getName() + ": оба активны, пытаюсь сделать работу...");
                active = false;
                coworker.active = false;
                System.out.println(getName() + ": решил уступить, становлюсь неактивным");
            } else {
                System.out.println(getName() + ": оба неактивны, становлюсь активным!");
                active = true;
                coworker.active = false;
            }

            if (active && coworker.active) {
                doWork();
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