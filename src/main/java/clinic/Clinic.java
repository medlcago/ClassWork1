package clinic;

import java.util.concurrent.Semaphore;

public class Clinic {
    private Semaphore therapistSemaphore;
    private Semaphore mriSemaphore;
    private int queueLength;

    public Clinic() {
        therapistSemaphore = new Semaphore(1);
        mriSemaphore = new Semaphore(1);
        queueLength = 0;
    }

    public void servePatient() {
        try {
            Thread.sleep(RandomUtils.getRandomNumberInRange(300, 600));

            synchronized (this) {
                queueLength++;
                System.out.println("Пациент вошел в очередь. Размер очереди: " + queueLength);
            }

            therapistSemaphore.acquire();

            System.out.println("Осмотр терапевтом");

            Thread.sleep(RandomUtils.getRandomNumberInRange(0, 1000));

            mriSemaphore.acquire();

            mriSemaphore.release();

            System.out.println("Обследование на МРТ");

            Thread.sleep(RandomUtils.getRandomNumberInRange(0, 1000));

            synchronized (this) {
                queueLength--;
                System.out.println("Пациент покинул очередь. Размер очереди: " + queueLength);
            }

            therapistSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getQueueLength() {
        return queueLength;
    }
}