package readwrite;

import java.util.concurrent.CopyOnWriteArrayList;

public class ReadWrite {
    static final CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        Thread readerThread = new Thread(new Reader());
        Thread writerThread = new Thread(new Writer());

        readerThread.start();
        writerThread.start();
    }
}
