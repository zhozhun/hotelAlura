package com.alura.jdbc.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PlaceholderTextField extends JTextField {

    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        setForeground(Color.GRAY);
        setText(placeholder);

        // Agregar un FocusListener para eliminar el marcador de posición cuando se obtiene el foco
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                clearPlaceholder(); // Limpia el marcador de posición cuando se obtiene el foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                restorePlaceholder(); // Restaura el marcador de posición si se pierde el foco sin entrada de texto
            }
        });
    }

    public void clearPlaceholder() {
        if (getText().equals(placeholder)) {
            setText("");
            setForeground(Color.BLACK);
        }
    }

    public void restorePlaceholder() {
        if (getText().isEmpty()) {
            setText(placeholder);
            setForeground(Color.GRAY);
        }
    }

    public String getPlaceholder() {
        return placeholder;
    }
}