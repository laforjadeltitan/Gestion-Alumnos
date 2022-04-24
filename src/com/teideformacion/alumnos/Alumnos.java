package com.teideformacion.alumnos;

public class Alumnos {
	private String clave;
	private String nombre;
	private String apellidos;
	private int edad;
	private String calle;
	private int numero;
	private String localidad;

	public Alumnos(String clave, String nombre, String apellidos, int edad, String calle, int numero,
			String localidad) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getClave() {
		return clave;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	@Override
	public String toString() {
		return "Alumnos [clave=" + clave + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + "]";
	}

	// Método calcular edad pendiente de hacer

}
