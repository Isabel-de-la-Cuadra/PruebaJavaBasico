package test;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

/*
 * 16. Escribir pruebas unitarias para ClienteServicio:
 * - Método agregarClienteTest para verificar el funcionamiento de agregarCliente (se debe agregar un
 * cliente para que el test corra de manera correcta).
 * - Método agregarClienteNullTest para verificar el funcionamiento de agregarCliente en caso que vengan 
 * casos nulos (se debe agregar un cliente nulo para que el test corra de manera correcta)
 */

public class ClienteServicioTest {

	ClienteServicio clienteServicio = new ClienteServicio();

	@Test
	public void AgregarClienteTest() {

		List<Cliente> agregarClienteTest = clienteServicio.agregarCliente("17.162.856-5", "Iron", "Manjar", "1 año",
				CategoriaEnum.ACTIVO);
		assertTrue(agregarClienteTest.size()>0);
	}

	
	@Test
	public void AgregarClienteNullTest() {

		List<Cliente> agregarClienteNullTest = clienteServicio.agregarCliente(null, null, null, null,
				CategoriaEnum.ACTIVO);
		Cliente clienteNulo = clienteServicio.getListaClientes().get(0);
		String rutNulo = clienteNulo.getRunCliente();
		assertNull(rutNulo, null);

	}

}
