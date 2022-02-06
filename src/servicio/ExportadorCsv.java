package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

/*
 * 11. Crear una clase ExportadorCsv en el package servicio, que contenga un método exportar, cuyos parámetros serán
 * String fileName y una List<Cliente>listaClientes. Se deben realizar las implementaciones correspondientes al 
 * interior del método usando PrintWriter y Filewriter para la exportación de archivos.
 * Le pasé, además, por parámetro la ruta del directorio.
 */

public class ExportadorCsv extends Exportador {

	@Override
	public void exportar(String directorio, String fileName, List<Cliente> listaClientes) {
		System.out.println(directorio); //Sacar más adelanta
		System.out.println(fileName); //Sacar más adelante
		System.out.println(listaClientes); //Sacar más adelante
		
		File archivo = new File(directorio + "/" +fileName + ".csv");
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();

				FileWriter archivoWriter = new FileWriter(archivo);
				PrintWriter printWriter = new PrintWriter(archivoWriter);

				for (Cliente cliente : listaClientes) {
					String lineaCliente = cliente.getRunCliente() + "," + cliente.getNombreCliente() + ","
							+ cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + ","
							+ cliente.getNombreCategoria();
					printWriter.write(lineaCliente);
					printWriter.println();
				}
				printWriter.close();
			} catch (IOException e) {
				System.out.println("No pude crear el archivo");
				System.out.println("Para el programador " + e);
			}
		}

	}

}
