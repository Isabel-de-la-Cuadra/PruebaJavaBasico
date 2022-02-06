package test;

import static org.junit.Assert.assertNull;

import org.junit.Test;

/*
 * 16. Escribir pruebas unitarias para ClienteServicio:
 * - Método agregarClienteTest para verificar el funcionamiento de agregarCliente (se debe agregar un
 * cliente para que el test corra de manera correcta).
 * - Método agregarClienteNullTest para verificar el funcionamiento de agregarCliente en caso que vengan 
 * casos nulos (se debe agregar un cliente nulo para que el test corra de manera correcta)
 */


public class ClienteServicioTest {

	@Test
	public void AgregarClienteTest() {
		System.out.println("Test método agregar cliente");
	
		//assertTrue("El Test del método agregar cliente fue exitoso", listaCliente.size()>0)
	}
	
	
	@Test
	public void AgregarClienteNullTest () {
		System.out.println("Test método agregar cliente nulo");
		//assertNull("El test del método agregar cliente nulo fue exitoso", listaCliente);
	}
	
}




