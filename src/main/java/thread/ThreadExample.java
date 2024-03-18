package thread;

public class ThreadExample implements Runnable {
    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.printf("ID потока: %d\n", threadId);
    }

    public static void main(String[] args) {
        ThreadExample object = new ThreadExample();

        Thread thread1 = new Thread(object);
        Thread thread2 = new Thread(object);
        Thread thread3 = new Thread(object);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
