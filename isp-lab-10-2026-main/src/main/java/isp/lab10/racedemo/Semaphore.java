package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

public class SemaphorePanel extends JPanel {
    private Color culoareCurenta;

    public SemaphorePanel() {
        setPreferredSize(new Dimension(100, 300));
        culoareCurenta = Color.GRAY;
    }

    public void setGray() {
        culoareCurenta = Color.GRAY;
        repaint();
    }

    public void setYellow() {
        culoareCurenta = Color.YELLOW;
        repaint();
    }

    public void setGreen() {
        culoareCurenta = Color.GREEN;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diametru = Math.min(getWidth(), getHeight()) - 20;
        int px = (getWidth() - diametru) / 2;
        int py = (getHeight() - diametru) / 2;

        g.setColor(culoareCurenta);
        g.fillOval(px, py, diametru, diametru);

        g.setColor(Color.BLACK);
        g.drawOval(px, py, diametru, diametru);
    }
}