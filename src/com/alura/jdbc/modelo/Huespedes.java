package com.alura.jdbc.modelo;

import java.sql.Date;

public class Huespedes {

//	campos de clase
	private int idHuespedes;
	private String nombreHuesped;
	private String apellidoHuesped;
	private Date fechaNacimiento;
	private String nacionalidad;
	private int telefono;
	private int reserva;

//  constructor

//	setter & getter

	public int getIdHuespedes() {
		return idHuespedes;
	}

	public void setIdHuespedes(int idHuespedes) {
		this.idHuespedes = idHuespedes;
	}

	public String getNombreHuesped() {
		return nombreHuesped;
	}

	public void setNombreHuesped(String nombreHuesped) {
		this.nombreHuesped = nombreHuesped;
	}

	public String getApellidoHuesped() {
		return apellidoHuesped;
	}

	public void setApellidoHuesped(String apellidoHuesped) {
		this.apellidoHuesped = apellidoHuesped;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getReserva() {
		return reserva;
	}

	public void setReserva(int reserva) {
		this.reserva = reserva;
	}

//	métodos

}
