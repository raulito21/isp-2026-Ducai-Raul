package isp.lab10.raceapp;

public class SemaphoreThread extends Thread {
    private SemaphorePanel panouSemafor;

    public SemaphoreThread(SemaphorePanel panouSemafor) {
        this.panouSemafor = panouSemafor;
    }

    public void run() {
        try {
            panouSemafor.setGray();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            panouSemafor.setYellow();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            panouSemafor.setGreen();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}