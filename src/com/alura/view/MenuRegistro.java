package com.alura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.alura.jdbc.modelo.PlaceholderTextField;
import com.toedter.calendar.JDateChooser;

import com.alura.jdbc.controller.HuespedesController;

public class MenuRegistro extends JFrame {
	PlaceholderTextField cuadroIdReserva;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenuRegistro ventana = new MenuRegistro();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});
	}

	public MenuRegistro() {
//		Usar un layout nulo (null layout) para desactivar el diseño automático
		setLayout(null);

//    	1. Elementos básicos
//		Configurar el título de la ventana
		setTitle("Reservas");
//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);
//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		2. Componentes
//		2.1. Páneles

		ImageIcon gifRegistro = new ImageIcon("images/gifRegistro2.gif");
		JLabel labelGifRegistro = new JLabel(gifRegistro);
		labelGifRegistro.setBounds(0, 50, 600, 600);
		add(labelGifRegistro);

		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(new Color(51, 153, 255));
		panelIzquierdo.setBounds(0, 0, 600, 800);
		panelIzquierdo.setOpaque(true);
		add(panelIzquierdo);

//		2.2.Labels/Etiquetas

//		2.3. Textos

		PlaceholderTextField textoNombre = new PlaceholderTextField("Ingrese su nombre: ");
		textoNombre.setBounds(700, 150, 400, 30);
		add(textoNombre);

		PlaceholderTextField textoApellido = new PlaceholderTextField("Ingrese su apellido: ");
		textoApellido.setBounds(700, 200, 400, 30);
		add(textoApellido);

		PlaceholderTextField textoTelefono = new PlaceholderTextField("Ingrese su número telefónico: ");
		textoTelefono.setBounds(700, 400, 400, 30);
		add(textoTelefono);

		cuadroIdReserva = new PlaceholderTextField("ID de Reserva: ");
		cuadroIdReserva.setBounds(700, 450, 400, 30);
		cuadroIdReserva.setEditable(false);
		add(cuadroIdReserva);

//		2.4. Botones
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(700, 560, 150, 40);
		botonGuardar.setBackground(new Color(51, 153, 255));
		// Desactivar el pintado del borde predeterminado
		botonGuardar.setBorderPainted(false);
		// Cambiar la curvatura de las esquinas
		botonGuardar.setBorder(new BordeRedondo(20));
		botonGuardar.setFont(new Font("Arial", Font.BOLD, 16));
		add(botonGuardar);
		// Cambiar tipo de cursos al hacer click encima
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(900, 560, 150, 40);
		botonBorrar.setBackground(new Color(51, 153, 255));
		// Desactivar el pintado del borde predeterminado
		botonBorrar.setBorderPainted(false);
		// Cambiar la curvatura de las esquinas
		botonBorrar.setBorder(new BordeRedondo(20));
		botonBorrar.setFont(new Font("Arial", Font.BOLD, 16));
		add(botonBorrar);
		// Cambiar tipo de cursos al hacer click encima
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton botonRegresar = new JButton("← Regresar");
		botonRegresar.setBounds(700, 660, 150, 80);
		Color colorPersonalizado = new Color(51, 153, 255);
		botonRegresar.setBackground(colorPersonalizado);
		// Desactivar el pintado del borde predeterminado
		botonRegresar.setBorderPainted(false);
		// Cambiar la curvatura de las esquinas
		botonRegresar.setBorder(new BordeRedondo(20));
		Font fuenteBotonRegresar = new Font("Arial", Font.BOLD, 16);
		botonRegresar.setFont(fuenteBotonRegresar);
		add(botonRegresar);
		// Cambiar tipo de cursos al hacer click encima
		botonRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton botonInicio = new JButton("⌂");
		botonInicio.setBounds(1100, 660, 80, 80);
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

		ImageIcon tituloReservas = new ImageIcon("images/tituloReservas.png");
		JLabel labelTituloReservas = new JLabel(tituloReservas);
		labelTituloReservas.setBounds(600, 0, 600, 200);
		add(labelTituloReservas);

//		2.6, Elemento de calendario

		JLabel etiquetaFechaNacimiento = new JLabel("Fecha de nacimiento: ");
		etiquetaFechaNacimiento.setBounds(700, 250, 400, 30);
		etiquetaFechaNacimiento.setFont(new Font("Arial", Font.BOLD, 16));
		add(etiquetaFechaNacimiento);

		JDateChooser dateChooserFechaNacimiento = new JDateChooser();
		dateChooserFechaNacimiento.setBounds(700, 290, 400, 30);
		add(dateChooserFechaNacimiento);

		dateChooserFechaNacimiento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				dateChooserFechaNacimiento.setCalendar(null); // Borra la selección anterior si la hay
			}
		});

//		2.7. ComboBox
		String[] opcionesNacionalidad = { "Seleccione una nacionalidad", "Afganistán", "Albania", "Alemania", "Andorra",
				"Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia",
				"Austria", "Azerbaiyán", "Bahamas", "Bahréin", "Bangladés", "Barbados", "Bélgica", "Belice", "Benín",
				"Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi",
				"Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar",
				"Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte",
				"Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador",
				"Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España",
				"Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia",
				"Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea-Bisáu",
				"Guinea Ecuatorial", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda",
				"Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón", "Jordania",
				"Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano",
				"Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Madagascar",
				"Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México",
				"Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal",
				"Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán",
				"Palaos", "Palestina", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal",
				"Reino Unido", "República Centroafricana", "República Checa", "República del Congo",
				"República Democrática del Congo", "República Dominicana", "Ruanda", "Rumania", "Rusia", "Samoa",
				"San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía",
				"Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria",
				"Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia", "Suiza",
				"Surinam", "Tailandia", "Taiwán", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga",
				"Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay",
				"Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue" };

		JComboBox<String> comboBoxNacionalidad = new JComboBox<>(opcionesNacionalidad);
		comboBoxNacionalidad.setBounds(700, 350, 400, 30);
		add(comboBoxNacionalidad);

//		2.8. Métodos
		
		// ActionListener para el botón "Guardar"
		botonGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener los datos ingresados por el usuario desde la interfaz
		        String nombre = textoNombre.getText();
		        String apellido = textoApellido.getText();
		        Date fechaNacimiento = dateChooserFechaNacimiento.getDate();
		        String nacionalidad = comboBoxNacionalidad.getSelectedItem().toString();
		        String telefono = textoTelefono.getText();
		        String idReserva = cuadroIdReserva.getText();
		        String idReserva1 = idReserva.replace("ID de Reserva: ", "");

		        // Crear una instancia de HuespedesController
		        HuespedesController huespedesController = new HuespedesController();

		        // Llamar al método en HuespedesController para guardar los datos
		        boolean exito = huespedesController.guardarHuesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva1);

		        if (exito) {
		            // Mostrar un mensaje de éxito
		            JOptionPane.showMessageDialog(null, "Huésped guardado con éxito");
		        } else {
		            // Mostrar un mensaje de error si la operación falla
		            JOptionPane.showMessageDialog(null, "Error al guardar el huésped", "Error", JOptionPane.ERROR_MESSAGE);
		        }

		        // Limpiar los campos de entrada después de guardar
		        textoNombre.setText("");
		        textoApellido.setText("");
		        dateChooserFechaNacimiento.setDate(null);
		        comboBoxNacionalidad.setSelectedIndex(0);
		        textoTelefono.setText("");
		        cuadroIdReserva.setText("");
		    }
		});
		

		// Botón para regresar a Menú Reservas
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual (MenuPrincipal)
				setVisible(false);

				// Crea una instancia de MenuUsuario y la muestra
				MenuReservas menuReservas = new MenuReservas();
				menuReservas.setVisible(true);
			}

		});

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