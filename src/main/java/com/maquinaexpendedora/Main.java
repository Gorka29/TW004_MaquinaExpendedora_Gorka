package com.maquinaexpendedora;

import com.maquinaespendedora.dominio.MaquinaExpendedora;
import com.maquinaespendedora.dominio.Refresco;

public class Main {

	public static void main(String[] args) {
		
	//Cremoa los refrescos con su nombre y precio
	Refresco agua     = new Refresco("Agua", 1.25);
	Refresco cocaCola = new Refresco("Cola-Cola", 1.75);
	Refresco aquarius = new Refresco("Aquarius", 1.5);
	Refresco pepsy    = new Refresco("Pepsy", 1.65);
	
	//Creamos la máquina y le añadimos el dinero
	MaquinaExpendedora maquina = new MaquinaExpendedora();
	maquina.setDineroMaquina(8.0);
	
	//Añadimos los refrescos
	maquina.añadirRefresco(agua);
	maquina.añadirRefresco(agua);
	maquina.añadirRefresco(agua);
	maquina.añadirRefresco(cocaCola);
	maquina.añadirRefresco(cocaCola);
	maquina.añadirRefresco(cocaCola);
	maquina.añadirRefresco(aquarius);
	maquina.añadirRefresco(aquarius);
	maquina.añadirRefresco(pepsy);
	
	//Mostramos el estado actual de la máquina
	maquina.mostrarEstadoActual();
	
	//Mostramos distintos tipos de información
	maquina.mostrarCompra(cocaCola, 5.0);
	
	maquina.mostrarVendidos();
	
	maquina.informeDeRefresco(agua);
	
	maquina.informeDeRefresco(cocaCola);
	
	maquina.informeDeRefresco(aquarius);
	
	maquina.informeDeRefresco(pepsy);

	}
}
