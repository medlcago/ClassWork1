package clinic;

public class PatientThread extends Thread {
    private Clinic clinic;

    public PatientThread(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        clinic.servePatient();
    }
}