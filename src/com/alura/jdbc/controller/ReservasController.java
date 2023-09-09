package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.alura.jdbc.factory.ConnectionFactory;

public class ReservasController {
  
    public boolean crearReserva(String idReserva, Date fechaEntrada, Date fechaSalida, double costoTotal, String formaPago) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Obtener una conexión a la base de datos
            connection = ConnectionFactory.getConnection();

            // Definir la consulta SQL para insertar una reserva
            String sql = "INSERT INTO Reservas (idReservas, fechaEntrada, fechaSalida, costoTotal, formaPago) VALUES (?, ?, ?, ?, ?)";

            // Crear una declaración preparada con la consulta SQL
            statement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            statement.setString(1, idReserva);
            statement.setDate(2, new java.sql.Date(fechaEntrada.getTime()));
            statement.setDate(3, new java.sql.Date(fechaSalida.getTime()));
            statement.setDouble(4, costoTotal);
            statement.setString(5, formaPago);

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
