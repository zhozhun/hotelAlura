package com.alura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDatePanel;

public class MenuReservas extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenuReservas ventana = new MenuReservas();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});
	}

	public MenuReservas() {
//		Usar un layout nulo (null layout) para desactivar el diseño automático
		setLayout(null);

//    	1. Elementos básicos
//		Configurar el título de la ventana
		setTitle("Reservas");
//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);
//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      2. Componentes
//		2.1. Páneles

//		2.2.Labels/Etiquetas

//		2.3. Textos

//		2.4. Botones

		JButton botonInicio = new JButton("⌂");
		botonInicio.setBounds(1100, 660, 80, 80);
		Color colorPersonalizado = new Color(51, 153, 255);
		botonInicio.setBackground(colorPersonalizado);
		// Desactivar el pintado del borde predeterminado
		botonInicio.setBorderPainted(false);
		// Cambiar la curvatura de las esquinas
		botonInicio.setBorder(new BordeRedondo(20));
		Font fuenteBotonInicio = new Font("Arial", Font.BOLD, 30);
		botonInicio.setFont(fuenteBotonInicio);
		add(botonInicio);
		// Cambiar tipo de cursos al hacer click encima
		botonInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		2.5. Imágenes

		ImageIcon imagenTitulo = new ImageIcon("images/gifReservas.gif");
		JLabel labelImagenTitulo = new JLabel(imagenTitulo);
		labelImagenTitulo.setBounds(100, 100, 600, 600);
		add(labelImagenTitulo);

//		2.6. Elementos de calendario

		JDateChooser fechaIngresoChooser = new JDateChooser();
		JDateChooser fechaSalidaChooser = new JDateChooser();
		fechaIngresoChooser.setBounds(100, 100, 150, 30);
		fechaSalidaChooser.setBounds(100, 150, 150, 30);
		add(fechaIngresoChooser);
		add(fechaSalidaChooser);
		
		fechaIngresoChooser.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        fechaIngresoChooser.setCalendar(null); // Borra la selección anterior si la hay
		    }
		});

		fechaSalidaChooser.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        fechaSalidaChooser.setCalendar(null); // Borra la selección anterior si la hay
		    }
		});


//		2.7. Métodos

		// Botón para ir a MenuPrincipal
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual (MenuPrincipal)
				setVisible(false);

				// Crea una instancia de MenuUsuario y la muestra
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
			}

		});

	}
}
