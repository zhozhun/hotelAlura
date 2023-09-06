package com.alura.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

////1.Menú Princpial haciendo click en login, 
//2. Menú de Usuario
//2.1. Reservas * Fecha check in * fecha check out * Calculas valor de la reserva, ^ Método de pago TC TD DE, Botón continuar, Generar número de reserva
//2.1.1. Registro de huésped: Nombre, Apellido, Fecha de nacimiento Nacionalidad, Teléfono, Número de la reserva (Creado en la ventana anterior), Botón Guardar, Hay botón cancelar, Hay botón salir, si exitoso mostrar ventana Exitoso, volver al menú principal 
//2.2. Búsqueda de reserva: Pestaña búsqueda por huéspedes, pestaña búsqueda por número de reserva, botón salir al menú principal, al hacer click en este se debe preguntar si realmente desea salir 


public class MenuPrincipal extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenuPrincipal ventana = new MenuPrincipal();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});

	}

	public MenuPrincipal() {
//			Usar un layout nulo (null layout) para desactivar el diseño automático
		setLayout(null);

//	    	1. Elementos básicos
//			Configurar el título de la ventana
		setTitle("Alura Hotel");
//			Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);
//			Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//	      2. Componentes
//			2.1. Páneles
		
		JLabel etiquetaIniciar = new JLabel("Iniciar");
		etiquetaIniciar.setBounds(835, 350, 200, 30);
		Font fuenteEtiquetaIniciar = new Font("Arial", Font.BOLD, 40);
		etiquetaIniciar.setFont(fuenteEtiquetaIniciar);
		add(etiquetaIniciar);
		
		ImageIcon imagenTitulo = new ImageIcon("images/tituloHotel1.png");
		JLabel labelImagenTitulo = new JLabel(imagenTitulo);
		labelImagenTitulo.setBounds(600, 0, 600, 300);
		add(labelImagenTitulo);
		

		Color color1 = new Color(33, 155, 194); // Color central
		Color color2 = new Color(51, 153, 255); // Color exterior
		BotonDegradadoRadial botonInicio = new BotonDegradadoRadial("⌂", color1, color2);
		botonInicio.setBounds(825, 400, 150, 150);
		botonInicio.setBorder(new RoundedBorder(40));
		Font fuenteBotonInicio= new Font("Arial", Font.BOLD, 60);
		botonInicio.setFont(fuenteBotonInicio);
		add(botonInicio);
		// Cambiar tipo de cursos al hacer click encima
		botonInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		

		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(new Color(51, 153, 255));
		panelDerecho.setBounds(600, 0, 600, 800);
		panelDerecho.setOpaque(true);
		add(panelDerecho);

//			2.2.Labels/Etiquetas
		
//			2.3. Textos

//			2.4. Botones
		


//			2.5. Imágenes
		
		ImageIcon imagenInicio = new ImageIcon("images/gifInicio.gif");
		JLabel labelImagenInicio = new JLabel(imagenInicio);
		labelImagenInicio.setBounds(0, 50, 600, 600);
		add(labelImagenInicio);
		
//		2.6. Métodos
		
        // Botón para ir a MenuUsuario
        botonInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Oculta la ventana actual (MenuPrincipal)
                setVisible(false);

                // Crea una instancia de MenuUsuario y la muestra
                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
            }

        });

	}

}
