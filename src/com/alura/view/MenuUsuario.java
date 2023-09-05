package com.alura.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuUsuario extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenuUsuario ventana = new MenuUsuario();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});
	}

	public MenuUsuario() {
//		Usar un layout nulo (null layout) para desactivar el diseño automático
		setLayout(null);

//    	1. Elementos básicos
//		Configurar el título de la ventana
		setTitle("Alura Hotel");
//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);
//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      2. Componentes
//		2.1. Páneles
//		poner imagen primero para que aparezca encima del pánel
		ImageIcon imagenTitulo = new ImageIcon("images/tituloIniciarSesion.png");
		JLabel labelImagenTitulo = new JLabel(imagenTitulo);
		labelImagenTitulo.setBounds(0, 0, 600, 300);
		add(labelImagenTitulo);

//		imagen gif
		ImageIcon gifHotel = new ImageIcon("images/luggage.png");
		JLabel labelGifHotel = new JLabel(gifHotel);
		labelGifHotel.setBounds(40, 190, 500, 500);
		add(labelGifHotel);

		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(new Color(51, 153, 255));
		panelIzquierdo.setBounds(0, 0, 600, 800);
		panelIzquierdo.setOpaque(true);
		add(panelIzquierdo);

//		2.2.Labels/Etiquetas
		JLabel etiquetaUsuario = new JLabel("Usuario: ");
		etiquetaUsuario.setBounds(725, 370, 200, 30);
		Font fuenteEtiquetaUsuario = new Font("Arial", Font.BOLD, 16);
		etiquetaUsuario.setFont(fuenteEtiquetaUsuario);
		add(etiquetaUsuario);

		JLabel etiquetaContrasena = new JLabel("Contraseña: ");
		etiquetaContrasena.setBounds(725, 470, 200, 30);
		Font fuenteEtiquetaContrasena = new Font("Arial", Font.BOLD, 16);
		etiquetaContrasena.setFont(fuenteEtiquetaContrasena);
		add(etiquetaContrasena);

//		2.3. Textos
//		agregar texto con place holder
		JTextFieldConPlaceholder textoUsuario = new JTextFieldConPlaceholder("Ingresar el usuario");
		textoUsuario.setBounds(725, 400, 300, 40);
//		modificar bordes
		textoUsuario.setBorder(new RoundedBorder(10)); // El valor 10 es el radio de las esquinas redondeadas
//      agregar placeholder
		add(textoUsuario);

		JPasswordField textoContrasena = new JPasswordField();
		textoContrasena.setBounds(725, 500, 300, 40);
		textoContrasena.setBorder(new RoundedBorder(10));
		add(textoContrasena);

//		2.4. Botones
		Color color1 = new Color(24, 181, 231); // Color central
		Color color2 = new Color(33, 155, 194); // Color exterior
		BotonDegradadoRadial botonLogin = new BotonDegradadoRadial("Iniciar sesión", color1, color2);
		botonLogin.setBounds(725, 600, 300, 40);
		botonLogin.setBorder(new RoundedBorder(10));
		Font fuenteBotonLogin = new Font("Arial", Font.BOLD, 20);
		botonLogin.setFont(fuenteBotonLogin);
		add(botonLogin);
		// Cambiar tipo de cursos al hacer click encima
		botonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
		ImageIcon imagenLogin = new ImageIcon("images/safe1.gif");
		JLabel labelImagenLogin = new JLabel(imagenLogin);
		labelImagenLogin.setBounds(725, 50, 300, 300);
		add(labelImagenLogin);

//		2.6. Métodos
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

class BordeRedondo implements Border {
    private int radioCurvatura;

    public BordeRedondo(int radioCurvatura) {
        this.radioCurvatura = radioCurvatura;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radioCurvatura, radioCurvatura);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(radioCurvatura, radioCurvatura, radioCurvatura, radioCurvatura);
    }

    public boolean isBorderOpaque() {
        return true;
    }
}
