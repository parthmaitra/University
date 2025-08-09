package thread;

public class Main {
    public static void main(String[] args) {
        Object mutex = new Object();
        Thread printEven = new Thread(new PrintEven(mutex));
        Thread printOdd = new Thread(new PrintOdd(mutex));
        printOdd.start();
        printEven.start();
    }
}
