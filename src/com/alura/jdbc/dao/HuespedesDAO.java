package com.alura.jdbc.dao;

// idHuespedes, nombre, apellido, fechaNacimiento, nacionalidad, telefono, reserva

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Huespedes;

public class HuespedesDAO {

    private static final String SELECT_HUESPEDES_BY_NOMBRE = "SELECT * FROM Huespedes WHERE nombre LIKE ?";

    public HuespedesDAO() {
    }

    public List<Huespedes> buscarPorNombre(String nombre) {
        List<Huespedes> huespedes = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HUESPEDES_BY_NOMBRE);) {
            preparedStatement.setString(1, "%" + nombre + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idHuesped = rs.getInt("idHuespedes");
                String nombreHuesped = rs.getString("nombre");
                String apellidoHuesped = rs.getString("apellido");
              

                Huespedes huesped = new Huespedes(idHuesped, nombreHuesped, apellidoHuesped);
                huespedes.add(huesped);
            }
        } catch (SQLException e) {
            // Manejar las excepciones de SQL aquí
        }
        return huespedes;
    }
}
