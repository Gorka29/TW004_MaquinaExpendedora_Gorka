package com.maquinaespendedora.dominio;

import java.util.*;

public class MaquinaExpendedora {
	// Atributos
	private Double dineroMaquina = 0.0;
	private Boolean stock = false;
	private ArrayList<Refresco> cantidadRefrescos = new ArrayList<Refresco>();
	private ArrayList<Refresco> informe = new ArrayList<Refresco>();
	
	public Double getDineroMaquina() {
		return dineroMaquina;
	}

	public void setDineroMaquina(Double dineroMaquina) {
		this.dineroMaquina = dineroMaquina;
	}

	public Boolean getStock() {
		return stock;
	}

	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	public ArrayList<Refresco> getCantidadRefrescos() {
		return cantidadRefrescos;
	}

	public void setCantidadRefrescos(ArrayList<Refresco> cantidadRefrescos) {
		this.cantidadRefrescos = cantidadRefrescos;
	}

	public ArrayList<Refresco> getInforme() {
		return informe;
	}

	public void setInforme(ArrayList<Refresco> informe) {
		this.informe = informe;
	}

	// Contructor
	public MaquinaExpendedora() {
	}
	
	public MaquinaExpendedora(Double dineroMaquina, Boolean stock, ArrayList<Refresco> cantidadRefrescos, ArrayList<Refresco> informe) {
		super();
		this.dineroMaquina = dineroMaquina;
		this.stock = stock;
		this.cantidadRefrescos = cantidadRefrescos;
		this.informe = informe;
	}


	// Metodos

	/**
	 * Este método comprueba si hay stock o no. Si no hay
	 * pone el stock a true y añade el refresco.
	 * En el caso de que si hay stock solo añade el refresco.
	 * 
	 * @param Recibe un objeto refresco para añadirlo a la máquina.
	 * @author Gorka Ruiz
	 */
	public void añadirRefresco(Refresco refresco) {
		if (this.stock == false) {
			this.stock = true;
		}
		this.cantidadRefrescos.add(refresco);
	}

	/**
	 * Este método compra refrescos, después de comprobar que el dinero metido 
	 * a la máquina sea mayor o igual al precio a pagar, 
	 * que haya stock de refrescos en la máquina y que la máquina 
	 * tenga dinero para poder dar cambios. 
	 * 
	 * @param Recibe un objeto refresco
	 * @param Recibe el dinero introducido en la maquina
	 * @author Gorka Ruiz
	 */
	public int comprarRefresco(Refresco refresco, Double dineroMaquina) {
		int resultadoCompra = 0;
		Double precio = refresco.getPrecio();
		if (dineroMaquina >= precio) {
			if (buscarRefresco(refresco) == true) {
				if (this.dineroMaquina - dineroMaquina >= 0) {
					this.dineroMaquina = this.dineroMaquina + precio;
					this.cantidadRefrescos.remove(buscarPosicionDeRefresco(refresco));
					if (this.cantidadRefrescos.size() <= 0) {
						this.stock = false;
					}
					this.informe.add(refresco);
					resultadoCompra = 1;
				} else {
					resultadoCompra = 2;
				}
			} else {
				resultadoCompra = 3;
			}
		} else {
			resultadoCompra = 4;
		}
		return resultadoCompra;
	}
	
	/**
	 * Este método a partir de un refresco en especifico da la cantidad de ellos
	 * disponible.
	 * 
	 * @param Recibe un objeto refresco.
	 * @return Devuelve un int con la cantidad de refrescos especificos que se estan
	 *         buscando.
	 * @author Gorka Ruiz
	 */
	public int buscarCuantasPorTipo(Refresco refresco) {
		int contador = 0;

		for (int i = 0; i < this.cantidadRefrescos.size(); i++) {
			String nombre = refresco.getNombre();
			if (nombre.equalsIgnoreCase(this.cantidadRefrescos.get(i).getNombre())) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Este método visualiza un informe completo de todos los productos comprados. 
	 * 
	 * @author Gorka Ruiz
	 */
	public void mostrarVendidos() {
		System.out.println("---------------------- INFORME DE VENTAS ----------------------\n");
		System.out.println("Dinero total obtenido: " + dineroAcomuladoDeVentas() + "\u20AC\n");
		for (int i = 0; i < this.informe.size(); i++) {
			System.out.println("- " + this.informe.get(i));
		}
		System.out.println("-----------------------------------------------------------------\n");
	}


	/**
	 * Este método nos muestra el estado actual de la máquina con datos como:
	 * cuanto dinero hay en la máquina, el stock de los refrescos totales,
	 * el nombre de los refrescos, el precio de cada uno y los diferentes mensajes 
	 * que no puede devolver.
	 * 
	 * @author Gorka Ruiz
	 */
	public void mostrarEstadoActual() {
		System.out.println("------------------------- ESTADO ACTUAL -------------------------\n");
		System.out.println("-------- Dinero máquina: " + this.dineroMaquina + " \u20AC |---| Cantidad refrescos:" + getCantidadRefrescos().size() + " -------\n");
		for (int i = 0; i < this.cantidadRefrescos.size(); i++) {
			System.out.println("- " + this.cantidadRefrescos.get(i));
		}
		System.out.println("-----------------------------------------------------------------\n");
	}

	/**
	 * Este método comprueba si hay el refresco que
	 * le introducimos por parámatro.
	 * 
	 * @param Se le entrega un objeto Refresco.
	 * @return Devuelve un booleano, false para indicar que no esta y true para
	 *         indicar que si esta.
	 * @author Gorka Ruiz
	 */
	public boolean buscarRefresco(Refresco refresco) {
		Boolean ok = false;
		for (int i = 0; i < this.cantidadRefrescos.size(); i++) {
			if (refresco == this.cantidadRefrescos.get(i)) {
				ok = true;
			}
		}

		return ok;

	}

	/**
	 * Este método nos devuelve la posición del refresco en el array.
	 *
	 * @param Se le entrega un objeto Refresco.
	 * @return Devuelve la posicion (int) en la que se encuentra el refresco en el
	 *         array, si el valor es negativo no se encuentra y si es positivo te da
	 *         su posicion.
	 * @author Gorka Ruiz
	 */
	public int buscarPosicionDeRefresco(Refresco refresco) {
		int posi = -1;
		for (int i = 0; i < this.cantidadRefrescos.size(); i++) {
			if (refresco == this.cantidadRefrescos.get(i)) {
				posi = i;
			}
		}
		return posi;
	}

	/**
	 * Este método recorre los refrescos de la maquina y calcula el precio de los
	 * mismos para de esta manera saber cuanto dinero de ganancias se ha acomulado
	 * en la máquina.
	 *
	 * @return Devuelve un double con la cantidad total (en dinero) de refrescos
	 *         vendidos.
	 * @author Gorka Ruiz
	 */
	public Double dineroAcomuladoDeVentas() {
		Double dinero = 0.0;
		for (int i = 0; i < this.informe.size(); i++) {
			dinero += this.informe.get(i).getPrecio();
		}
		return Math.round(dinero * 100.0) / 100.0;
	}

	/**
	 * Este método muestra el stock y la disponibilidad de un refresco en especifico
	 * en la maquina.
	 * 
	 * @param Recibe un objeto refresco para realizar la busqueda.
	 * @author Gorka Ruiz
	 */
	public void informeDeRefresco(Refresco refresco) {
		if (buscarRefresco(refresco) == true) {
			System.out.println("- Refresco: " + refresco.getNombre() + "\n");
			System.out.println("- Su stock: " + buscarCuantasPorTipo(refresco) + " unidades." + "\n");
		}

	}

	/**
	 * Muestra la informacion de la compra en pantalla.
	 * 
	 * @param Recibe un objeto refresco
	 * @param Recibe el dinero que ha depositado el cliente en la máquina
	 * @author Gorka Ruiz
	 */
	public void mostrarCompra(Refresco refresco, Double dinero) {
		int respuesta = comprarRefresco(refresco, dinero);
		Double precio = refresco.getPrecio();
		Double cambios = dinero - precio;
		String msg = "";

		switch (respuesta) {
		case 1:
			msg = "Compra realizada, cambios: " + cambios + "\n";
			break;
		case 2:
			msg = "No quedan cambios en la maquina. \n";
			break;
		case 3:
			msg = "No hay stock de este refresco en la máquina. \n";
			break;
		case 4:
			msg = "No tienes suficiente dinero \n";
			break;
		default:
			msg = "Ha ocurrido un error \n";
			break;
		}
		System.err.println(msg);
	}

}
