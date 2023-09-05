package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Configurar los detalles de tu base de datos MySQL
	private static final String URL = "jdbc:mysql://localhost:3306/HotelDB";
	private static final String USER = "admin";
	private static final String PASSWORD = "1234";

	// Método para obtener una conexión a la base de datos MySQL
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Registrar el controlador JDBC de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establece la conexión a la base de datos
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.err.println("Error: No se pudo cargar el controlador JDBC");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error: No se pudo establecer la conexión a la base de datos");
			e.printStackTrace();
		}
		return connection;
	}

}
