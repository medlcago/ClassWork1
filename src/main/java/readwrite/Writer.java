package readwrite;

class Writer implements Runnable {
    private int counter = 1;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                ReadWrite.listOfNumbers.add(counter);
                System.out.printf("В список записано число: %d\n", counter);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}