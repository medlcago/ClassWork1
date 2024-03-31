package thread;

public class ThreadExample implements Runnable {
    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.printf("ID потока: %d\n", threadId);
    }
}