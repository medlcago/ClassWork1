package mfc;

import java.util.Random;

class Citizen implements Runnable {
    private final Category category;
    private final Window[] windows;
    public static int[] totalCitizensByCategory = new int[Main.TOTAL_WINDOWS];
    public static int[] angryCitizensByCategory = new int[Main.TOTAL_WINDOWS];

    public Citizen(String category, Window[] windows) {
        this.category = Category.fromString(category);
        this.windows = windows;
        totalCitizensByCategory[this.category.ordinal()]++;
    }

    @Override
    public void run() {
        Random random = new Random();
        int windowIndex = random.nextInt(Main.TOTAL_WINDOWS);
        Window window = windows[windowIndex];

        if ((windowIndex == 0) || (windowIndex == category.ordinal())) {
            if (!window.isBusy()) {
                window.setBusy(true);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Гражданин категории " + category + " обслужен в окне " + (windowIndex + 1));
            } else {
                angryCitizensByCategory[category.ordinal()]++;
                System.out.println("Гражданин категории " + category + " разгневанно ушел из окна " + (windowIndex + 1));
            }
        } else {
            angryCitizensByCategory[category.ordinal()]++;
            System.out.println("Гражданин категории " + category + " разгневанно ушел из окна " + (windowIndex + 1));
        }
        window.setBusy(false);
    }

    public static double getAngryPercentage(Category category) {
        return (double) angryCitizensByCategory[category.ordinal()] / totalCitizensByCategory[category.ordinal()] * 100;
    }
}
