package com.alura.view;

import javax.swing.*;
import java.awt.*;

public class JTextFieldConPlaceholder extends JTextField {
    private String placeholder;

    public JTextFieldConPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && !isFocusOwner()) {
            Font originalFont = g.getFont();
//          Font italicFont = originalFont.deriveFont(Font.ITALIC);
//          g.setFont(italicFont);
            g.setColor(Color.GRAY);
            g.drawString(placeholder, getInsets().left, g.getFontMetrics().getAscent() + getInsets().top);
        }
    }
}
