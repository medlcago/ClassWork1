package readwrite;

class Reader implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.printf("Чтение из списка: %s\n", ReadWrite.listOfNumbers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
