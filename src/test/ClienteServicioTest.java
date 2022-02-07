package test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

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

	private static Logger logger = Logger
			.getLogger("PruebaJavaBasico.src.test.ClienteServicioTest");
	ClienteServicio clienteServicio = new ClienteServicio();

	@Test
	public void AgregarClienteTest() {

		logger.info("Información test Agregar Cliente");
		List<Cliente> agregarClienteTest = clienteServicio.agregarCliente("17.162.856-5", "Iron", "Manjar", "1 año",
				CategoriaEnum.ACTIVO);
		assertTrue("El Test del método agregar cliente fue exitoso", agregarClienteTest.size() > 0);
	}

	@Test
	public void AgregarClienteNullTest() {

		logger.info("Información test Agregar Cliente");
		List<Cliente> agregarClienteNullTest = clienteServicio.agregarCliente(null, null, null, null,
				CategoriaEnum.ACTIVO);
		assertNull(agregarClienteNullTest.isEmpty());

	}

}
