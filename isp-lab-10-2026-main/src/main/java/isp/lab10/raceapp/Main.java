package isp.lab10.raceapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fereastraSemafor = new JFrame("Semaphore");
        fereastraSemafor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel panouSem = new SemaphorePanel();

        fereastraSemafor.getContentPane().add(panouSem);
        fereastraSemafor.pack();
        fereastraSemafor.setVisible(true);

        SemaphoreThread firSemafor = new SemaphoreThread(panouSem);
        firSemafor.start();

        JFrame fereastraCursa = new JFrame("Car Race");
        fereastraCursa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel panouTraseu = new CarPanel();

        fereastraCursa.getContentPane().add(panouTraseu);
        fereastraCursa.pack();
        fereastraCursa.setSize(500,300);
        fereastraCursa.setVisible(true);

        Car auto1 = new Car("Red car", panouTraseu);
        Car auto2 = new Car("Blue car", panouTraseu);
        Car auto3 = new Car("Green car", panouTraseu);
        Car auto4 = new Car("Yellow car", panouTraseu);

        PlaySound audio = new PlaySound();
        TimerThread cronometru = new TimerThread();

        try {
            firSemafor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Race!");
        audio.playSound();
        cronometru.start();

        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();

        try {
            auto1.join();
            auto2.join();
            auto3.join();
            auto4.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        cronometru.stopTimer();
        audio.stopSound();

        System.out.println("Race duration: " + (float) cronometru.getTime() / 100 + " sec");
    }
}