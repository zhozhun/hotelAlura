package com.alura.jdbc.modelo;

import java.sql.Date;

public class Huespedes {

//	campos de clase
	private int idHuesped;
	private String nombreHuesped;
	private String apellidoHuesped;
	private Date fechaNacimiento;
	private String nacionalidad;
	private int telefono;
	private int reserva;

//  constructor
	
    public Huespedes(int id, String nombre, String apellido) {
        this.idHuesped = id;
        this.nombreHuesped = nombre;
        this.apellidoHuesped = apellido;
    }

//	setter & getter

	public int getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(int idHuespedes) {
		this.idHuesped = idHuespedes;
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
