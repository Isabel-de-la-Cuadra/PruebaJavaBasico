package utilidades;

/*
 * 14. Crear una clase Utilidad en package utilidades, que contenga métodos reutilizables para el menú, como limpiar pantalla, mostrar mensajes, etc.
 */


public class Utilidad {

	public void limpiarPantalla() {
		for (int i = 0; i < 10; i++) {
			System.err.println("\n");
		}
	}
	
	public void tiempoDeEspera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(":| interrupción inesperada");
			e.printStackTrace();
		}
	}
	
	public void mensajes() {
		
	}
}
