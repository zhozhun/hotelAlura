package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class UsuarioDAO {
 
    // Método para verificar las credenciales del usuario en la base de datos
    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        boolean autenticado = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM Usuarios WHERE nombreUsuario = ? AND contrasena = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreUsuario);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Si se encuentra una coincidencia en la base de datos, el usuario es autenticado
                autenticado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return autenticado;
    }
}
	
