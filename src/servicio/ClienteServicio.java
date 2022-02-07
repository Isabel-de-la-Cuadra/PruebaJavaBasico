package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

/*
 * 9. Crear la clase ClienteServicio en el package servicio con los siguientes requisitos:
 *    - Crear un atributo llamado List<Cliente> listaClientes
 *    - Generar un constructor de ClienteServicio que tenga esta listaClientes como una nueva ArrayList
 *    - Generar el método público sin valor de retornolistarClientes e implementar el ciclo más idóneo para recorrer cada uno de los clientes
 *    - Generar un public void del método agregarCliente y pasarle los parámetros de la clase Cliente. Utiliza este método para guardar clientes en una instancia de cliente
 *    - Generar un public void del método editarCliente y pasarle los parámetros de la clase Cliente
 *    - Crear un getter de listaCliente y que pueda retornar una listaClientes.
 */

public class ClienteServicio {
	List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
		super();
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = new ArrayList<Cliente>(listaClientes);
	}

	public void retornolistarClientes() {
		for (Cliente clienteTemporal : listaClientes) {

			System.out.println("------------  Datos del Cliente  ------------");
			System.out.println();

			System.out.println("RUN del Cliente: " + clienteTemporal.getRunCliente());
			System.out.println("Nombre del Cliente: " + clienteTemporal.getNombreCliente());
			System.out.println("Apellido del Cliente: " + clienteTemporal.getApellidoCliente());
			System.out.println("Años como Cliente: " + clienteTemporal.getAniosCliente());
			System.out.println("Categoría del Cliente: " + clienteTemporal.getNombreCategoria());
			System.out.println();
			System.out.println("--------------------------------------------");
		}
	}

	public List<Cliente> agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {

		Cliente clienteIngresado = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente,
				CategoriaEnum.ACTIVO);

		if (clienteIngresado != null) {
			listaClientes.add(clienteIngresado);
		}
		System.out.println("Lista de clientes " + listaClientes);
		System.out.println();
		
		return listaClientes;

	}

	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		// Editar cliente de la listaClientes se sobreescribe en Menu
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

}
