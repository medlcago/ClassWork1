package mfc;

class Window {
    private boolean busy;

    public Window() {
        this.busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean status){
        this.busy = status;
    }

}
