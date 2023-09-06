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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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

//		2.3. Textos

		JTextField cuadroResultado = new JTextField();
		cuadroResultado.setBounds(700, 450, 400, 30);
		cuadroResultado.setEditable(false);
		add(cuadroResultado);

//		JTextField cuadroDiasAlojamiento = new JTextField();
//		cuadroDiasAlojamiento.setBounds(700, 450, 200, 30); 
////		no permitir que se pueda ingresar texto
//		cuadroDiasAlojamiento.setEditable(false); 
//		add(cuadroDiasAlojamiento);
//		
//		JTextField cuadroCostoTotal = new JTextField();
//		cuadroCostoTotal.setBounds(700, 550, 200, 30); 
//		cuadroCostoTotal.setEditable(false); 
//		add(cuadroCostoTotal);

//		2.4. Botones

		JButton botonCalcularTarifa = new JButton("Calcular Tarifa");
		botonCalcularTarifa.setBounds(700, 400, 150, 30);
		add(botonCalcularTarifa);

//		JButton botonCalcular = new JButton("Calcular tarifa");
//		botonCalcular.setBounds(700, 400, 150, 30);
//		add(botonCalcular);
//		
//		JButton botonCalcularCosto = new JButton("Calcular Costo");
//		botonCalcularCosto.setBounds(700, 400, 150, 30); 
//		add(botonCalcularCosto);

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
		labelImagenTitulo.setBounds(50, 100, 600, 600);
		add(labelImagenTitulo);

//		2.6. Elementos de calendario

		JDateChooser fechaIngresoChooser = new JDateChooser();
		JDateChooser fechaSalidaChooser = new JDateChooser();
		fechaIngresoChooser.setBounds(700, 200, 200, 30);
		fechaSalidaChooser.setBounds(700, 300, 200, 30);
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

		botonCalcularTarifa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtiene las fechas seleccionadas
				Date fechaIngreso = fechaIngresoChooser.getDate();
				Date fechaSalida = fechaSalidaChooser.getDate();

				// Calcula la diferencia en días
				long diferenciaEnMillis = fechaSalida.getTime() - fechaIngreso.getTime();
				int diasAlojamiento = (int) (diferenciaEnMillis / (1000 * 60 * 60 * 24)); // Convierte millis a días

				// Calcula el costo en dólares (suponiendo $80 por día)
				double costoPorDia = 80.0;
				double costoTotal = costoPorDia * diasAlojamiento;

				// Muestra el resultado en el cuadro de texto
				cuadroResultado
						.setText("Días: " + diasAlojamiento + " | Costo Total: $" + String.format("%.2f", costoTotal));
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

////		calcular días
//		
//		botonCalcular.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		        // Obtener las fechas seleccionadas
//		        java.util.Date fechaIngreso = fechaIngresoChooser.getDate();
//		        java.util.Date fechaSalida = fechaSalidaChooser.getDate();
//
//		        // Calcular la diferencia en días
//		        long diferenciaEnMillis = fechaSalida.getTime() - fechaIngreso.getTime();
//		        int diasAlojamiento = (int) (diferenciaEnMillis / (1000 * 60 * 60 * 24)); // Convertir milisegundos a días
//
//		        // Mostrarel resultado en el cuadro de texto
//		        cuadroDiasAlojamiento.setText(Integer.toString(diasAlojamiento) + " días");
//		    }
//		});
//		
////		calcular costo
//		
//		JButton botonCalcularCosto = new JButton("Calcular Costo");
//		botonCalcularCosto.setBounds(700, 400, 150, 30); // Ajusta las coordenadas y el tamaño según tu diseño
//		add(botonCalcularCosto);
//
//		botonCalcularCosto.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		        // Obtener las fechas seleccionadas
//		        java.util.Date fechaIngreso = fechaIngresoChooser.getDate();
//		        java.util.Date fechaSalida = fechaSalidaChooser.getDate();
//
//		        // Calcular la diferencia en días
//		        long diferenciaEnMillis = fechaSalida.getTime() - fechaIngreso.getTime();
//		        int diasAlojamiento = (int) (diferenciaEnMillis / (1000 * 60 * 60 * 24)); // Convierte milisegundos a días
//
//		        // Calcular el costo en dólares (suponiendo $80 por día)
//		        double costoPorDia = 80.0;
//		        double costoTotal = costoPorDia * diasAlojamiento;
//
//		        // Mostrar el resultado en el cuadro de texto
//		        cuadroCostoTotal.setText("$" + String.format("%.2f", costoTotal));
//		    }
//		});



	}
}
