package com.alura.view;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import javax.swing.*;

public class RoundedBorder extends AbstractBorder {
    private final int radio;

    public RoundedBorder(int radio) {
        this.radio = radio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK); // Color del borde
        g2d.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radio, radio, radio, radio);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
