package mfc;

import java.util.Random;

public class Main {
    static int TOTAL_CITIZENS = 15;
    static int TOTAL_WINDOWS = 3;

    public static void main(String[] args) throws InterruptedException {
        Window[] windows = new Window[TOTAL_WINDOWS];
        for (int i = 0; i < TOTAL_WINDOWS; i++) {
            windows[i] = new Window();
        }

        for (int i = 0; i < TOTAL_CITIZENS; i++) {
            Category category = Category.values()[new Random().nextInt(Category.values().length)];
            Thread citizenThread = new Thread(new Citizen(category.toString(), windows));
            citizenThread.start();
            citizenThread.join();
        }

        for (Category category : Category.values()) {
            double angryPercentage = Citizen.getAngryPercentage(category);
            System.out.println(category + ": " + angryPercentage + "%");
        }
    }
}
