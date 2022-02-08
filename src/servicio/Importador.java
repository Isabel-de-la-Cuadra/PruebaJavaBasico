package servicio;

import java.util.List;

import modelo.Cliente;

/*
 * 13. Crear la clase ArchivoServicio en el package servicio que extiende a la clase Exportador.
 * 
 * Germán, creo que es ilógico que ArchivoServicio extienda de la clase Abstracta Exportador, porque lo que está
 * haciendo es importar data. Es un asunto de nombrar las cosas por la palabra correcta. Así es que creé una clase
 * abstracta Importador. (ArchivoServicio usa el String fileName1, no el String fileName).
 */

public abstract class Importador {

	public abstract void cargarDatos(String ruta, String fileName1, List<Cliente> listaClientes);
}
