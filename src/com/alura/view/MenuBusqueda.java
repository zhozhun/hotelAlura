package com.alura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.alura.jdbc.dao.HuespedesDAO;
import com.alura.jdbc.modelo.Huespedes;
import com.alura.jdbc.dao.ReservasDAO;
import com.alura.jdbc.modelo.Reservas;
import com.toedter.calendar.JDateChooser;

public class MenuBusqueda extends JFrame {

	private final HuespedesDAO huespedesDAO = new HuespedesDAO();
	private final ReservasDAO reservasDAO = new ReservasDAO();
	private JTextField textoMostrarHuesped;
	private JTextField textoMostrarReserva;

//	==================== ejecución interfaz ====================

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenuBusqueda ventana = new MenuBusqueda();

			// Hacer que la ventana sea visible
			ventana.setVisible(true);
		});
	}

	public MenuBusqueda() {

//		Usar un layout nulo (null layout) para desactivar el diseño automático
		setLayout(null);

//    	==================== 1. Elementos básicos ====================
//		Configurar el título de la ventana
		setTitle("Búsqueda");
//		Establecer el tamaño de la ventana (ancho x alto)
		setSize(1200, 800);
//		Configurar la operación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      ==================== 2. Componentes ====================

//		==================== 2.1. Imágenes ====================

//		==================== 2.2. Páneles ====================

//		==================== Pestaña buscar huéspedes ====================

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
//		==================== Pestaña buscar reservas ====================

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Cliente", panel1);
		tabbedPane.addTab("Reserva", panel2);
		tabbedPane.setBounds(10, 10, 1160, 740);

		// "this.getContentPane().add(tabbedPane)" en lugar de
		// "frame.getContentPane().add(tabbedPane)"
		this.getContentPane().add(tabbedPane);

//		==================== 2.3. Pestañas ====================

//		==================== 2.4. Etiquetas ====================

		JLabel label1 = new JLabel("Buscar por nombre o apellido:");
		label1.setBounds(100, 30, 300, 30);
		panel1.add(label1);

		JLabel label2 = new JLabel("Buscar por número de reserva:");
		label2.setBounds(100, 30, 300, 30);
		panel2.add(label2);

//		==================== 2.5. Textos ====================

		JTextField textoBuscarHuesped = new JTextField();
		textoBuscarHuesped.setBounds(330, 30, 500, 30);
		panel1.add(textoBuscarHuesped);

		JTextField textoBuscarReserva = new JTextField();
		textoBuscarReserva.setBounds(330, 30, 500, 30);
		panel2.add(textoBuscarReserva);

		textoMostrarHuesped = new JTextField();
		textoMostrarHuesped.setBounds(100, 100, 1000, 500);
		panel1.add(textoMostrarHuesped);

		textoMostrarReserva = new JTextField();
		textoMostrarReserva.setBounds(100, 100, 1000, 500);
		panel2.add(textoMostrarReserva);

//		==================== 2.6. Botones ====================

		JButton buttonBuscarHuesped = new JButton("Buscar");
		buttonBuscarHuesped.setBounds(850, 30, 100, 30);
		panel1.add(buttonBuscarHuesped);

		JButton buttonBuscarReserva = new JButton("Buscar");
		buttonBuscarReserva.setBounds(850, 30, 100, 30);
		panel2.add(buttonBuscarReserva);

		// Crear un botón para la primera pestaña (panel1)

		JButton botonInicioPanel1 = new JButton("⌂");
		botonInicioPanel1.setBounds(1050, 625, 80, 80);
		botonInicioPanel1.setBackground(new Color(51, 153, 255));
		botonInicioPanel1.setBorderPainted(false);
		botonInicioPanel1.setBorder(new BordeRedondo(20));
		Font fuenteBotonInicio = new Font("Arial", Font.BOLD, 30);
		botonInicioPanel1.setFont(fuenteBotonInicio);
		botonInicioPanel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel1.add(botonInicioPanel1);

		// Crear un botón para la primera pestaña (panel2)

		JButton botonInicioPanel2 = new JButton("⌂");
		botonInicioPanel2.setBounds(1050, 625, 80, 80);
		botonInicioPanel2.setBackground(new Color(51, 153, 255));
		botonInicioPanel2.setBorderPainted(false);
		botonInicioPanel2.setBorder(new BordeRedondo(20));
		botonInicioPanel2.setFont(fuenteBotonInicio);
		botonInicioPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel2.add(botonInicioPanel2);

//		==================== 2.8. Métodos ====================

//		==================== Pestaña clientes ====================

		buttonBuscarHuesped.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreBuscado = textoBuscarHuesped.getText();
				List<Huespedes> resultados = huespedesDAO.buscarPorNombre(nombreBuscado);
				mostrarResultados(resultados);
			}
		});

//		==================== Pestaña reserva ====================

		buttonBuscarReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int reservaBuscada = Integer.parseInt(textoBuscarReserva.getText());
				List<Reservas> resultados = reservasDAO.buscarPorId(reservaBuscada);
				mostrarId(resultados);
			}
		});

//		====================  ====================

		// Botón para ir a MenuPrincipal
		botonInicioPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual (MenuPrincipal)
				setVisible(false);

				// Crea una instancia de MenuUsuario y la muestra
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
			}

		});

		botonInicioPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual (MenuPrincipal)
				setVisible(false);

				// Crea una instancia de MenuUsuario y la muestra
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
			}

		});

	}

	private void mostrarResultados(List<Huespedes> resultados) {
		StringBuilder sb = new StringBuilder();
		for (Huespedes huesped : resultados) {
			sb.append("ID: ").append(huesped.getIdHuesped()).append("\n");
			sb.append("Nombre: ").append(huesped.getNombreHuesped()).append("\n");
			sb.append("Apellido: ").append(huesped.getApellidoHuesped()).append("\n\n");
		}
		textoMostrarHuesped.setText(sb.toString());

	}

	private void mostrarId(List<Reservas> resultados) {
		StringBuilder sb = new StringBuilder();
		for (Reservas reserva : resultados) {
			sb.append("ID: ").append(reserva.getIdReservas()).append("\n");
			sb.append("Fecha de entrada: ").append(reserva.getFechaEntrada()).append("\n");
			sb.append("Fecha de salida: ").append(reserva.getFechaSalida()).append("\n\n");
			sb.append("Costo: ").append(reserva.getCostoTotal()).append("\n\n");
			sb.append("Forma de pago: ").append(reserva.getFormaPago()).append("\n\n");
		}
		textoMostrarReserva.setText(sb.toString());

	}
}
