package com.alura.jdbc.modelo;

import java.sql.Date;

public class Reservas {

//	campos de clase
	private int idReservas;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int valor;
	private String formaPago;

//	constructor

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
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}	
	
//	métodos

}
