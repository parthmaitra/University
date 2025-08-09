package thread;

public class PrintOdd implements Runnable{
    Object mutex;
    PrintOdd(Object mutex) {
        this.mutex = mutex;
    }
    public void printOdd() throws InterruptedException {
        synchronized (mutex) {
            for (int i = 1; i < 10; i += 2) {
                mutex.wait();
                System.out.println(i);
                mutex.notify();
            }
        }
    }
    @Override
    public void run() {
        try {
            printOdd();
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
