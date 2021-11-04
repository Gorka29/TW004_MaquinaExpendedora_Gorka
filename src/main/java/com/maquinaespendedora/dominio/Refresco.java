package com.maquinaespendedora.dominio;

public class Refresco {
	
	// Atributos
	private String nombre = "";
	
	private Double precio = 0.0;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	// Contructor
	public Refresco() {
	}
	
	public Refresco(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	// Metodos
	/**
	 * Metodo sobreescrito para visualizar los refrescos.
	 * @author Gorka Ruiz
	 */
	@Override
	public String toString() {
		return nombre + " (" + precio + "\u20AC) \n";
	}
}