package isp.lab10.raceapp;

public class Car extends Thread {
    private String numeAuto;
    private int parcurs = 0;
    private CarPanel panouCursa;

    public Car(String numeAuto, CarPanel panouCursa) {
        setName(numeAuto);
        this.numeAuto = numeAuto;
        this.panouCursa = panouCursa;
    }

    public void run() {
        while (parcurs < 400) {
            int vitezaMisc = (int) (Math.random() * 10) + 1;
            parcurs += vitezaMisc;

            panouCursa.updateCarPosition(numeAuto, parcurs);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        panouCursa.carFinished(numeAuto);
    }
}