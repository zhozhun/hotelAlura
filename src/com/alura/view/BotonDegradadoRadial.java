package com.alura.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class BotonDegradadoRadial extends JButton {

    public BotonDegradadoRadial(String texto, Color color1, Color color2) {
        super(texto);
        setContentAreaFilled(false); // Hace que el área de contenido del botón no esté rellena
        setFocusPainted(false); // Elimina el efecto de resaltado al obtener el foco

        // Pasa los colores personalizados al constructor
        this.color1 = color1;
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        Point2D center = new Point2D.Float(width / 2, height / 2);
        float radius = Math.min(width, height) / 2;
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {color1, color2}; // Usa los colores personalizados aquí

        RadialGradientPaint paint = new RadialGradientPaint(center, radius, dist, colors);

        g2d.setPaint(paint);
        g2d.fillRoundRect(0, 0, width, height, 10, 10); // Dibuja un botón redondeado

        super.paintComponent(g);
    }
}
