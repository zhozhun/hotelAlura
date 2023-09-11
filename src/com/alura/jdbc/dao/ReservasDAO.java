package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Reservas;

// idReservas, fechaEntrada, fechaSalida, costoTotal, formaPago

public class ReservasDAO {

	private static final String SELECT_RESERVAS_BY_ID = "SELECT * FROM Reservas WHERE idReservas = ?";

	public ReservasDAO() {
	}

	public List<Reservas> buscarPorId(int idReservas) {
		List<Reservas> reservas = new ArrayList<>();
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVAS_BY_ID);) {
			preparedStatement.setInt(1, idReservas);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idReserva = rs.getInt("idReservas");
				Date fechaEntrada = rs.getDate("fechaEntrada");
				Date fechaSalida = rs.getDate("fechaSalida");
				int costoTotal = rs.getInt("costoTotal");
				String formaPago = rs.getString("formaPago");

				Reservas reserva = new Reservas(idReserva, fechaEntrada, fechaSalida, costoTotal, formaPago);
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();// Manejar las excepciones de SQL aquí
		}
		return reservas;
	}

}
