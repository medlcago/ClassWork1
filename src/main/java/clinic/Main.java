package clinic;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        int numPatients = 10;

        for (int i = 0; i < numPatients; i++) {
            PatientThread patientThread = new PatientThread(clinic);
            patientThread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int maxQueueLength = clinic.getQueueLength();
        System.out.println("Максимальная длина очереди: " + maxQueueLength);
    }
}