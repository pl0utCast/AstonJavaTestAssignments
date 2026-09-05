package oneTwoPrint;

public class OneTwoPrinter {
    private static final Object lock = new Object();
    private static Boolean printOne = true;

    public static void printDigits() {
        Thread onePrinter = new Thread(() -> {
            synchronized (lock) {
                while (printOne) {
                    System.out.print("1");
                    printOne = false;
                    try {
                        lock.wait();
                    } catch (InterruptedException ie) {
                    }
                }
            }
        });

        Thread twoPrinter = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!printOne) {
                        System.out.print("2");
                        printOne = true;
                        lock.notify();
                    }
                }
            }
        });

        onePrinter.start();
        twoPrinter.start();
    }
}
