package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

public class CarPanel extends JPanel {
    private int[] pozitii;
    private String[] identificatori;
    private Color[] nuante;
    private int locCurent = 1; // Pentru a calcula clasamentul (Exercițiul 5)

    public CarPanel() {
        pozitii = new int[4];
        identificatori = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        nuante = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int coordY = 50 + i * 50;
            int coordX = pozitii[i];
            int marime = 30;

            g.setColor(nuante[i]);
            g.fillOval(coordX, coordY, marime, marime);
            g.setColor(Color.BLACK);
            g.drawString(identificatori[i], coordX, coordY - 5);
        }
    }

    public void updateCarPosition(String masina, int dist) {
        int index = getCarIndex(masina);
        if (index != -1) {
            pozitii[index] = dist;
            repaint();
        }
    }

    public synchronized void carFinished(String masina) {
        System.out.println(masina + " finished race pe locul " + locCurent);
        locCurent++;
    }

    private int getCarIndex(String masina) {
        for (int i = 0; i < 4; i++) {
            if (identificatori[i].equals(masina)) {
                return i;
            }
        }
        return -1;
    }
}