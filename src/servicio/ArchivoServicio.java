package servicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

/*
 * 13. Crear la clase ArchivoServivio en el package servicio que extiende a la clase Exportador. Esta contiene
 * los siguientes requisitos:
 * - Crear el método cargarDatos que recibe por parámetro un String fileName, el cual indica el nombre del archivo
 * a cargar. Se deben realizar las implementaciones correspondientes al interior del método usando FileReader y
 * BufferedReader (para lectura de archivos).
 * - Crear el método exportar que será una herencia proveniente de la clase Exportador, cuyos parámetros serán los
 * mismos que se van a implementar en el paso 8.
 * 
 * Germán, te comento los cambios a las indicaciones, que no las encuentro ni lógicas ni atingentes:
 * 1. Por lo que realiza esta clase, no puede extender de un Exportador, por eso cree la clase abstracta Importar.
 * 2. El método CargarDatos no puede recibir fileName, porque este se implementó en Menú y se refiere al archivo Cliente,
 * voy a usar fileName1, que es el que contiene el nombre del archivo DBClientes.csv.
 * 3. El archivo DBClientes no venía como apoyo, así es que lo creé.
 * 4. Considero que la parte 2 de las instrucciones del punto 13 no guardan relación con lo que hay que hacer en esta clase,
 * por lo tanto, las obvié. 
 */

public class ArchivoServicio extends Importador {

	@Override
	public void cargarDatos(String ruta, String fileName1, List<Cliente> listaClientes) {
		//System.out.println("Ruta en ArchivoServicio " + ruta);
		//System.out.println("Nombre Archivo en ArchivoServicio " + fileName1);
		//System.out.println("listaClientes en ArchivoServicio " + listaClientes);

		String ArchivoALeer = (ruta + fileName1);
		System.out.println("Ruta del Archivo a Leer " + ArchivoALeer);
		System.out.println();

		try {
			FileReader archivoReader = new FileReader(ArchivoALeer);
			BufferedReader archivoBuffered = new BufferedReader(archivoReader);

			String lineaArchivo = archivoBuffered.readLine();

			while (lineaArchivo != null) {
				String[] atributoCliente = lineaArchivo.split(",");

				Cliente clienteTemporal = new Cliente(atributoCliente[0], atributoCliente[1], atributoCliente[2],
						atributoCliente[3], CategoriaEnum.valueOf(atributoCliente[4].toUpperCase()));
				lineaArchivo = archivoBuffered.readLine();

				listaClientes.add(clienteTemporal);
				
			}
			
			archivoBuffered.close();
			System.out.println("Ingresé correctamente la información a tu lista de clientes");
			System.out.println("La nueva lista de clientes es " + listaClientes);
			System.out.println();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("No encontré el archivo :O");
		} catch (IOException ioe) {
			System.out.println("Error al ingresar los datos :|");
		}

	}

}
