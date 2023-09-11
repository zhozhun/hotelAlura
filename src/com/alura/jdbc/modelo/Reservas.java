package com.alura.jdbc.modelo;

import java.sql.Date;

public class Reservas {

//	campos de clase
	private int idReservas;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int costoTotal;
	private String formaPago;

//	constructor
	
	public Reservas(int idReservas, Date fechaEntrada, Date fechaSalida, int costoTotal, String formaPago) {
		this.idReservas = idReservas;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.costoTotal = costoTotal;
		this.formaPago = formaPago;
		
	}

//	setter & getter

	public int getIdReservas() {
		return idReservas;
	}
	public void setIdReservas(int idReservas) {
		this.idReservas = idReservas;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}	
	
//	métodos

}
