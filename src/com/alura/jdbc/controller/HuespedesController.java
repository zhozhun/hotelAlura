package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.alura.jdbc.factory.ConnectionFactory;

public class HuespedesController {

	public boolean guardarHuesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, String idReserva) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Obtener una conexión a la base de datos
			connection = ConnectionFactory.getConnection();

			// Definir la consulta SQL para insertar un huésped
			String sql = "INSERT INTO Huespedes (nombre, apellido, fechaNacimiento, nacionalidad, telefono, reserva) VALUES (?, ?, ?, ?, ?, ?)";

			// Crear una declaración preparada con la consulta SQL
			statement = connection.prepareStatement(sql);

			// Establecer los valores de los parámetros
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setDate(3, new java.sql.Date(fechaNacimiento.getTime())); // Convertir Date a java.sql.Date
			statement.setString(4, nacionalidad);
			statement.setString(5, telefono);
			statement.setString(6, idReserva);

			// Ejecutar la consulta
			int filasInsertadas = statement.executeUpdate();

			// Si se insertaron filas, se considera un éxito
			return filasInsertadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // En caso de error, se devuelve false
		} finally {
			// Cerrar la conexión y la declaración
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
