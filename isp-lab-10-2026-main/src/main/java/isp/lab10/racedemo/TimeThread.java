package isp.lab10.raceapp;

public class TimerThread extends Thread {
    private long timpScurs;
    private boolean activ;

    public TimerThread() {
        timpScurs = 0;
        activ = true;
    }

    @Override
    public void run() {
        while(activ) {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            timpScurs++;
        }
    }

    public void stopTimer() {
        activ = false;
    }

    public long getTime() {
        return timpScurs;
    }
}