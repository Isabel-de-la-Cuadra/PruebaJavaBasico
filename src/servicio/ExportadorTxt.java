package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	
	@Override
	public void exportar(String directorio, String fileName, List<Cliente> listaClientes) {
		
	File archivo = new File(directorio + "/" +fileName + ".txt");
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
