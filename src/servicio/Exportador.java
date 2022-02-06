package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {

	/*
	 * 10. Crear una clase abstracta de nombre Exportador en package Servicio, que contenga un método abstracto
	 * para exportar, cuyos parámetros serán String fileName  List<Cliente>listaClientes.
	 */
	
	public abstract void exportar(String directorio, String fileName, List<Cliente> listaClientes);
	
}
