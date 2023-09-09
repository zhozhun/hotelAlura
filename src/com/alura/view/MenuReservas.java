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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDatePanel;

public class MenuReservas extends JFrame {

//	==================== campos de clase ====================

	private Date fechaEntrada;
	private Date fechaSalida;
	private String formaPago;
	private int idReserva = 0;

//	==================== ejecución interfaz ====================

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenuReservas ventana = new MenuReservas();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});
	}

//	==================== constructores ====================

	public MenuReservas() {

//		Usar un layout nulo (null layout) para desactivar el diseño automático
		setLayout(null);

//    	==================== 1. Elementos básicos ====================

//		Configurar el título de la ventana
		setTitle("Reservas");
//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);
//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      ==================== 2. Componentes ====================

//		==================== 2.1. Páneles ====================

//		==================== 2.2.Labels/Etiquetas ====================

		JLabel etiquetaFechaEntrada = new JLabel("Fecha de entrada: ");
		etiquetaFechaEntrada.setBounds(700, 170, 200, 30);
		Font fuenteEtiquetaEntrada = new Font("Arial", Font.BOLD, 18);
		etiquetaFechaEntrada.setFont(fuenteEtiquetaEntrada);
		add(etiquetaFechaEntrada);

		JLabel etiquetaFechaSalida = new JLabel("Fecha de salida: ");
		etiquetaFechaSalida.setBounds(700, 270, 200, 30);
		Font fuenteEtiquetaSalida = new Font("Arial", Font.BOLD, 18);
		etiquetaFechaSalida.setFont(fuenteEtiquetaSalida);
		add(etiquetaFechaSalida);

		JLabel etiquetaDesplegable = new JLabel("Método de pago: ");
		etiquetaDesplegable.setBounds(700, 500, 200, 30);
		Font fuenteDesplegable = new Font("Arial", Font.BOLD, 18);
		etiquetaDesplegable.setFont(fuenteDesplegable);
		add(etiquetaDesplegable);

//		==================== 2.3. Textos ====================

		JTextField textoValor = new JTextField();
		textoValor.setBounds(700, 400, 400, 30);
		textoValor.setEditable(false);
		add(textoValor);

		JTextField textoIdReserva = new JTextField();
		textoIdReserva.setBounds(700, 450, 400, 30);
		textoIdReserva.setEditable(false);
		add(textoIdReserva);

//		==================== 2.4. Botones ====================

		JButton botonCalcularTarifa = new JButton("Calcular Tarifa");
		botonCalcularTarifa.setBounds(700, 350, 150, 30);
		add(botonCalcularTarifa);

		JButton botonConfirmar = new JButton("Confirmar →");
		botonConfirmar.setBounds(700, 660, 150, 80);
		botonConfirmar.setBackground(new Color(51, 153, 255));
		botonConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
		add(botonConfirmar);

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

//		==================== 2.5. Imágenes ====================

		ImageIcon imagenReservas = new ImageIcon("images/tituloReservas.png");
		JLabel labelImagenReservas = new JLabel(imagenReservas);
		labelImagenReservas.setBounds(50, 20, 600, 200);
		add(labelImagenReservas);

		ImageIcon gifReservas = new ImageIcon("images/gifReservas2.gif");
		JLabel labelGifReservas = new JLabel(gifReservas);
		labelGifReservas.setBounds(50, 100, 600, 600);
		add(labelGifReservas);

//		==================== 2.6. Elementos de calendario ====================

		JDateChooser fechaEntradaChooser = new JDateChooser();
		JDateChooser fechaSalidaChooser = new JDateChooser();
		fechaEntradaChooser.setBounds(700, 200, 200, 30);
		fechaSalidaChooser.setBounds(700, 300, 200, 30);
		add(fechaEntradaChooser);
		add(fechaSalidaChooser);

		fechaEntradaChooser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				fechaEntradaChooser.setCalendar(null); // Borra la selección anterior si la hay
			}
		});

		fechaSalidaChooser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				fechaSalidaChooser.setCalendar(null); // Borra la selección anterior si la hay
			}
		});

//		==================== 2.7. ComboBox ====================

		String[] opcionesPago = { "Tarjeta débito", "Tarjeta de crédito", "Efectivo" };
		JComboBox<String> comboBoxPago = new JComboBox<>(opcionesPago);
		comboBoxPago.setBounds(700, 550, 200, 30);
		add(comboBoxPago);
		
//		==================== 2.8. Métodos ====================

//		==================== calcular tarifa, número de días e Id de reserva ====================

		botonCalcularTarifa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Obtener las fechas seleccionadas

				fechaEntrada = fechaEntradaChooser.getDate();
				fechaSalida = fechaSalidaChooser.getDate();
				formaPago = comboBoxPago.getSelectedItem().toString();
//				idReserva = textoIdReserva.
				// Asignar el número de reserva a textoIdReserva en la nueva ventana

				// Verificar si la fecha de salida es anterior a la fecha de entrada
				if (fechaSalida.before(fechaEntrada)) {
					textoValor.setText("La fecha de salida debe ser posterior a la fecha de entrada.");
				} else {
					// Calcular la diferencia en días
					long diferenciaEnMillis = fechaSalida.getTime() - fechaEntrada.getTime();
					int diasAlojamiento = (int) (diferenciaEnMillis / (1000 * 60 * 60 * 24)); // Convierte millis a días

					// Calcular el costo en dólares (suponiendo $80 por día)
					double costoPorDia = 80.0;
					double costoTotal = costoPorDia * diasAlojamiento;

					// Generar un número de reserva aleatorio de 6 dígitos
					idReserva = (int) (Math.random() * 900000 + 100000); // Genera un número entre 100000 y 999999

					// Mostrar el resultado en los cuadros de texto
					textoValor.setText(
							"Días: " + diasAlojamiento + " | Costo Total: $" + String.format("%.2f", costoTotal));
					textoIdReserva.setText("ID de Reserva: " + idReserva);

					MenuRegistro MenuRegistro = new MenuRegistro();

				}
			}
		});

//		==================== Botón para ir a Registro ====================

		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual (MenuPrincipal)
				setVisible(false);

				// Crea una instancia de MenuUsuario y la muestra
				MenuRegistro menuRegistro = new MenuRegistro();
				
		        menuRegistro.setFechaEntrada(fechaEntrada);
		        menuRegistro.setFechaSalida(fechaSalida);
		        menuRegistro.setFormaPago(formaPago);
		        menuRegistro.setIdReserva(idReserva);
				
				// Asignar el número de reserva a textoIdReserva en MenuRegistro
				menuRegistro.textoIdReserva.setText("ID de Reserva: " + idReserva);

				menuRegistro.setVisible(true);
			}

		});

// 		==================== Botón para ir a MenuPrincipal ====================

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
	
	public Date obtenerFechaEntradaDesdeMenuReservas() {
	    return fechaEntrada;
	}

	public Date obtenerFechaSalidaDesdeMenuReservas() {
	    return fechaSalida;
	}

	public String obtenerFormaPagoDesdeMenuReservas() {
	    return formaPago;
	}

	public int obtenerIdReservaDesdeMenuReservas() {
	    return idReserva;
	}
}
