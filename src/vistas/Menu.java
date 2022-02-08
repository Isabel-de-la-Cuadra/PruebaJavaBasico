package vistas;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

/*
 * 6. Crear la clase Menu en el package vistas, que debe contener los siguientes atributos:
 *    - clienteServicio, instancia de ClienteServicio
 *    - archivoServicio, instancia de ArchivoServicio
 *    - exportadorCSV, instancia de ExportarCsv
 *    - exportarTXT, instancia de ExportarTxt
 *    - Definir un String fileName = "Clientes" (para exportar el archivo)
 *    - Definir un String fileName1 = "DBClientes.csv" (para importar el archivo)
 *    - Scanner, instancia de Scanner para recibir valores a través del teclado
 *    - iniciarMenu, muestra el menu principal y recibe la entrada del teclado a través del scanner. Contiene la lógica para detonar los demás métodos en base a la entrada del teclado
 * 7. La clase Menu debe contener los siguientes métodos para la construcción y selección del menu:
 *    - listarCliente
 *    - agregarCliente
 *    - editarCliente
 *    - importarDatos
 *    - exportarDatos
 *    - terminarPrograma
 * 8. Se deben sobreescribir los métodos nombrados previamente en el punto 7, dentro de la misma clase Menu de la siguiente manera:
 *    - listarClientes, muestra lista de clientes agregados, ya sea por importación o agregando a mano.
 *    - agregarCliente, solicita ingreso de datos y llena objeto de tipo Cliente.
 *    - editarCliente, permite la edición de algún cliente en caso de requerirlo o cambiar el estado del cliente.
 *    - cargarDatos, ejecuta la carga de datos del archivo "DBClientes.csv".
 *    - terminarPrograma, el cual finaliza la ejecución del sistema.
 * HINT: El único método que no se debe sobreescribir es iniciarMenu, ya que contiene su implementación al inicio de la clase para formar el menú
 */

public class Menu extends MenuTemplate {

	private ClienteServicio clienteServicio = new ClienteServicio();
	private Utilidad utilidad = new Utilidad();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();

	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";

	Scanner scanner = new Scanner(System.in);

	@Override
	public void listarClientes() {

		clienteServicio.retornolistarClientes();

		System.out.println("--------------------------------------------");

	};

	@Override
	public void agregarCliente() {

		@SuppressWarnings("unused")
		Cliente agregarCliente = new Cliente();

		System.out.println("------------  Crear Cliente  -------------");
		System.out.println("------Elegiste agregar un cliente---------");
		System.out.println("Te pediré algunos datos para poder hacerlo");
		System.out.println();

		System.out.println("Ingresa el RUN del Cliente: ");
		String runNuevo = scanner.nextLine();

		while (runNuevo.isEmpty()) {
			System.out.println("No puedes ingresar datos nulos");
			System.out.println("Ingresa correctamente el RUN del Cliente");
			runNuevo = scanner.nextLine();
		}

		System.out.println("Datos ingresados correctamente al RUN del Cliente");
		System.out.println();

		System.out.println("Ingresa el Nombre del Cliente: ");
		String nombreNuevo = scanner.nextLine();

		while (nombreNuevo.isEmpty()) {
			System.out.println("No puedes ingresar datos nulos");
			System.out.println("Ingresa correctamente el Nombre del Cliente");
			nombreNuevo = scanner.nextLine();
		}

		System.out.println("Datos ingresados correctamente al Nombre del Cliente");
		System.out.println();

		System.out.println("Ingresa el Apellido del Cliente: ");
		String apellidoNuevo = scanner.nextLine();

		while (apellidoNuevo.isEmpty()) {
			System.out.println("No puedes ingresar datos nulos");
			System.out.println("Ingresa correctamente el Apellido del Cliente");
			apellidoNuevo = scanner.nextLine();
		}

		System.out.println("Datos ingresados correctamente al Apellido del Cliente");
		System.out.println();

		System.out.println("Ingresa los años que tiene como Cliente: ");
		String aniosNuevo = scanner.nextLine();

		while (aniosNuevo.isEmpty()) {
			System.out.println("No puedes ingresar datos nulos");
			System.out.println("Ingresa correctamente los años que tiene como Cliente");
			aniosNuevo = scanner.nextLine();
		}

		System.out.println("Datos ingresados correctamente");
		System.out.println();

		System.out.println();
		System.out.println("--------------------------------------------");

		System.out.println();

		clienteServicio.agregarCliente(runNuevo, nombreNuevo, apellidoNuevo, aniosNuevo, CategoriaEnum.ACTIVO);

	}

	@Override
	public void editarCliente() {

		System.out.println("----------                 Editar Cliente              -----------");
		System.out.println("----------    Elegiste editar los datos de un cliente  -----------");
		System.out.println("-----------    Selecciona qué parte deseas modificar   -----------");
		System.out.println();
		System.out.println("Ingresa el 1 si deseas cambiar el estado del cliente");
		System.out.println("Ingresa el 2 si deseas editar los datos que ingresaste del cliente");
		System.out.println();
		int opcion = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Ingresa el RUN del cliente a modificar:");
		String runEditar = scanner.nextLine();

		for (Cliente clienteAEditar : clienteServicio.getListaClientes()) {
			if (clienteAEditar.getRunCliente().equals(runEditar)) {

				if (opcion == 1) {
					System.out.println("Actualizaré el estado del Cliente ");
					System.out.println();
					System.out.println("El estado actual del cliente " + clienteAEditar.getNombreCliente() + " "
							+ clienteAEditar.getApellidoCliente() + " es " + clienteAEditar.getNombreCategoria());
					System.out.println();
					System.out.println("Ingresa 1 si deseas cambiar el estado del cliente a Inactivo");
					System.out.println("Ingresa 2 si deseas cambiar el estado del cliente a Activo");
					int opcionEstado = scanner.nextInt();
					scanner.nextLine();
					System.out.println();

					if (opcionEstado == 1) {
						clienteAEditar.setNombreCategoria(CategoriaEnum.INACTIVO);
						System.out.println("Cambié la categoría del cliente " + clienteAEditar.getNombreCliente() + " "
								+ clienteAEditar.getApellidoCliente() + " a INACTIVO :(");
					} else if (opcionEstado == 2) {
						clienteAEditar.setNombreCategoria(CategoriaEnum.ACTIVO);
						System.out.println("Cambié la categoría del cliente " + clienteAEditar.getNombreCliente() + " "
								+ clienteAEditar.getApellidoCliente() + " a ACTIVO :)");
					} else {
						System.out.println(
								"Entendí que no deseas cambiar el estado del Cliente, te estoy sacando de la edición");
						break;
					}

				} else if (opcion == 2) {
					System.out.println("Con tu ayuda, actualizaré los datos del Cliente "
							+ clienteAEditar.getNombreCliente() + " " + clienteAEditar.getApellidoCliente());
					System.out.println();
					System.out.println("Los datos actuales son:");
					System.out.println("El RUN del Cliente es: " + clienteAEditar.getRunCliente());
					System.out.println("El Nombre del Cliente es: " + clienteAEditar.getNombreCliente());
					System.out.println("El Apellido del Cliente es: " + clienteAEditar.getApellidoCliente());
					System.out.println(
							"Los años que lleva como nuestro cliente son: " + clienteAEditar.getAniosCliente());
					System.out.println();
					System.out.println("Ingresa el 1 si deseas cambiar el RUN del cliente");
					System.out.println("Ingresa el 2 si deseas cambiar el Nombre del cliente");
					System.out.println("Ingresa el 3 si deseas cambiar el apellido del cliente");
					System.out.println("Ingresa el 4 si deseas cambiar los años que lleva como cliente");
					System.out.println();
					int opcionAEditar = scanner.nextInt();
					scanner.nextLine();

					if (opcionAEditar == 1) {

						System.out.println("Escribe el nuevo RUN del cliente " + clienteAEditar.getNombreCliente() + " "
								+ clienteAEditar.getNombreCliente());
						String nuevoRUN = scanner.nextLine();

						while (nuevoRUN.isEmpty()) {
							System.out.println("No puedes ingresar datos nulos");
							System.out.println("Vuelve a intentarlo. Escribe el nuevo RUN del cliente "
									+ clienteAEditar.getNombreCliente() + " " + clienteAEditar.getNombreCliente());
							nuevoRUN = scanner.nextLine();
						}

						clienteAEditar.setRunCliente(nuevoRUN);
						System.out.println();
						System.out.println("Ingresé los nuevos datos sin contratiempos");
						System.out.println("Así está la base de datos de este cliente, luego de las modificaciones");
						System.out.println();
						System.out.println("Ahora el RUN del Cliente es: " + clienteAEditar.getRunCliente());
						System.out.println("Ahora el Nombre del Cliente es: " + clienteAEditar.getNombreCliente());
						System.out.println("Ahora el Apellido del Cliente es: " + clienteAEditar.getApellidoCliente());
						System.out.println("Ahora los años que lleva como nuestro cliente son: "
								+ clienteAEditar.getAniosCliente());
						System.out.println();
						System.out
								.println("---------------------------------------------------------------------------");

					} else if (opcionAEditar == 2) {
						System.out.println("Escribe el nuevo nombre del cliente que se llamaba"
								+ clienteAEditar.getNombreCliente() + " " + clienteAEditar.getNombreCliente());
						String nuevoNombre = scanner.nextLine();
						while (nuevoNombre.isEmpty()) {
							System.out.println("No puedes ingresar datos nulos");
							System.out.println("Vuelve a intentarlo. Escribe el nuevo Nombre del cliente que se llamaba "
									+ clienteAEditar.getNombreCliente() + " " + clienteAEditar.getNombreCliente());
							nuevoNombre = scanner.nextLine();
						}

						clienteAEditar.setNombreCliente(nuevoNombre);

						System.out.println();
						System.out.println("Ingresé los nuevos datos sin contratiempos");
						System.out.println("Así está la base de datos de este cliente, luego de las modificaciones");
						System.out.println();
						System.out.println("Ahora el RUN del Cliente es: " + clienteAEditar.getRunCliente());
						System.out.println("Ahora el Nombre del Cliente es: " + clienteAEditar.getNombreCliente());
						System.out.println("Ahora el Apellido del Cliente es: " + clienteAEditar.getApellidoCliente());
						System.out.println("Ahora los años que lleva como nuestro cliente son: "
								+ clienteAEditar.getAniosCliente());
						System.out.println();
						System.out
								.println("---------------------------------------------------------------------------");

					} else if (opcionAEditar == 3) {
						System.out.println("Escribe el nuevo apellido del cliente " + clienteAEditar.getNombreCliente()
								+ " " + clienteAEditar.getNombreCliente());
						String nuevoApellido = scanner.nextLine();

						while (nuevoApellido.isEmpty()) {
							System.out.println("No puedes ingresar datos nulos");
							System.out
									.println("Vuelve a intentarlo. Escribe el nuevo Apellido del cliente que se llamaba "
											+ clienteAEditar.getNombreCliente() + " "
											+ clienteAEditar.getNombreCliente());
							nuevoApellido = scanner.nextLine();
						}

						clienteAEditar.setApellidoCliente(nuevoApellido);
						System.out.println();
						System.out.println("Ingresé los nuevos datos sin contratiempos");
						System.out.println("Así está la base de datos de este cliente, luego de las modificaciones");
						System.out.println();
						System.out.println("Ahora el RUN del Cliente es: " + clienteAEditar.getRunCliente());
						System.out.println("Ahora el Nombre del Cliente es: " + clienteAEditar.getNombreCliente());
						System.out.println("Ahora el Apellido del Cliente es: " + clienteAEditar.getApellidoCliente());
						System.out.println("Ahora los años que lleva como nuestro cliente son: "
								+ clienteAEditar.getAniosCliente());
						System.out.println();
						System.out
								.println("---------------------------------------------------------------------------");

					} else if (opcionAEditar == 4) {
						System.out.println("Escribe el nuevo periodo que es nuestro cliente "
								+ clienteAEditar.getNombreCliente() + " " + clienteAEditar.getNombreCliente());
						String nuevoAnio = scanner.nextLine();
						while (nuevoAnio.isEmpty()) {
							System.out.println("No puedes ingresar datos nulos");
							System.out.println("Vuelve a intentarlo. Escribe el nuevo periodo de nuestro cliente "
									+ clienteAEditar.getNombreCliente() + " " + clienteAEditar.getNombreCliente());
							nuevoAnio = scanner.nextLine();
						}

						clienteAEditar.setAniosCliente(nuevoAnio);

						System.out.println();
						System.out.println("Ingresé los nuevos datos sin contratiempos");
						System.out.println("Así está la base de datos de este cliente, luego de las modificaciones");
						System.out.println();
						System.out.println("Ahora el RUN del Cliente es: " + clienteAEditar.getRunCliente());
						System.out.println("Ahora el Nombre del Cliente es: " + clienteAEditar.getNombreCliente());
						System.out.println("Ahora el Apellido del Cliente es: " + clienteAEditar.getApellidoCliente());
						System.out.println("Ahora los años que lleva como nuestro cliente son: "
								+ clienteAEditar.getAniosCliente());
						System.out.println();
						System.out
								.println("---------------------------------------------------------------------------");

					} else {
						System.out.println(
								"Entendí que no deseas cambiar los datos del Cliente, te estoy sacando de la edición");
						System.out.println();
						break;
					}

				} else {
					System.out.println("Te estoy llevando al Menú Principal ;)");
					System.out.println();
					break;
				}

			}

		}

	}

	@Override
	public void cargarDatos() {
		System.out.println("---  Elegiste Cargar Datos desde el Archivo DBClientes.csv ---");
		System.out.println();
		System.out.println("Dame la ruta donde se encuentra el archivo DBClientes.csv");
		System.out.println();
		System.out.println("Tienes que escribir, para poder encontrarlo, por ejemplo, lo siguiente:");
		System.out.println("Si estás en ambiente Linux o Mac: /EspacioTrabajo/PruebaJavaBasico/src/servicio/");
		System.out.println("Si estás en ambiente Windows: \\EspacioTrabajo\\PruebaJavaBasico\\src\\servicio\\");
		
		String ruta = scanner.nextLine();
		
		while (ruta == null || ruta.isEmpty() || ruta.contains(" ")) {
			System.out.println("El nombre de la ruta no puede se nulo, estar vacío o contener espacios en blanco");
			System.out.println();
			System.out.println("Ingresa una ruta válida donde se encuentre el archivo" +fileName1);
			ruta = scanner.nextLine();
		}
		
		archivoServicio.cargarDatos(ruta, fileName1, clienteServicio.getListaClientes());
	
	}

	@Override
	public void exportarDatos() {

		System.out.println("---    Elegiste Exportar Archivo con Datos de Clientes   ---");
		System.out.println("- Tienes que seleccionar el formato del archivo a exportar -");
		System.out.println();
		System.out.println("Ingresa el 1 si deseas exportar en formato csv");
		System.out.println("(El archivo se llamará Clientes.csv)");
		System.out.println("Ingresa el 2 si deseas exportar en formato txt");
		System.out.println("(El archivo se llamará Clientes.txt)");
		System.out.println();
		int opcionFormato = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Antes de exportar, te tengo que preguntar en qué tipo de ambiente te encuentras");
		System.out.println();
		System.out.println("¿Estás trabajando en ambiente Linux o Mac? Ingresa 1 si tu respueta es afirmativa");
		System.out.println("¿Estás trabajando en ambiente Windows? Ingresa 2 si tu respueta es afirmativa");
		System.out.println();
		int opcionAmbiente = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Ingresa el nombre de la carpeta donde deseas dejar el archivo");
		System.out.println("La crearé dentro de PruebaJavaBasico.carpetaDeTrabajo");
		String Carpeta = scanner.nextLine();

		while (Carpeta == null || Carpeta.isEmpty() || Carpeta.contains(" ")) {
			System.out.println("El nombre de la carpeta no puede se nulo, estar vacío o contener espacios en blanco");
			System.out.println();
			System.out.println("Ingresa un nombre válido para la carpeta donde deseas dejar el archivo");
			Carpeta = scanner.nextLine();
		}

		File directorioLinuxMac = new File("carpetaDeTrabajo/" + Carpeta);
		File directorioWindows = new File("carpetaDeTrabajo\\" + Carpeta);
		
		if (opcionAmbiente == 1) {
			if (!directorioLinuxMac.exists()) {
				directorioLinuxMac.mkdirs();
				System.out.println("Carpeta creada exitosamente en " + directorioLinuxMac.toString());

				if (opcionFormato == 1) {
					exportadorCsv.exportar(directorioLinuxMac.toString(), fileName, clienteServicio.getListaClientes());
				}

				if (opcionFormato == 2) {
					exportadorTxt.exportar(directorioLinuxMac.toString(),fileName, clienteServicio.getListaClientes());
				}
			}

		}

		if (opcionAmbiente == 2) {
			if (!directorioWindows.exists()) {
				directorioWindows.mkdirs();
				System.out.println("Carpeta creada exitosamente en " + directorioWindows.toString());

				if (opcionFormato == 1) {
					exportadorCsv.exportar(directorioWindows.toString(), fileName, clienteServicio.getListaClientes());
				}

				if (opcionFormato == 2) {
					exportadorTxt.exportar(directorioWindows.toString(), fileName, clienteServicio.getListaClientes());
				}

			}

		}

	}

	@Override
	public void terminarPrograma() {
		System.out.println("Gracias por usar este programa. Nos vemos en otra oportunidad ;)");
	};

	int opcion = 0;

	public void iniciarMenu() {

		System.out.println();
		System.out.println("   Bienvenido al Programa de Control de Clientes   ");
		System.out.println("              de Pastelería Bon Bon Jovi           ");
		System.out.println();
		System.out.println();
		try {
			do {

				System.out.println("         ¿Qué deseas hacer en este Programa?       ");
				System.out.println();
				System.out.println(" Tienes que ingresar el número de la opción elegida");
				System.out.println();
				System.out.println("---------------------------------------------------");
				System.out.println("-       Ingresa 1 para Listar Clientes            -");
				System.out.println("-       Ingresa 2 para Agregar Cliente            -");
				System.out.println("-       Ingresa 3 para Editar Cliente             -");
				System.out.println("-       Ingresa 4 para Cargar Datos               -");
				System.out.println("-       Ingresa 5 para Exportar Datos             -");
				System.out.println("-       Ingresa 6 para Salir del Programa         -");
				System.out.println("---------------------------------------------------");
				System.out.println(" Ingresa el número de la opción elegida");
				opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					listarClientes();
					utilidad.tiempoDeEspera();
					break;

				case 2:
					agregarCliente();
					utilidad.tiempoDeEspera();
					break;
				case 3:
					editarCliente();
					utilidad.tiempoDeEspera();
					break;
				case 4:
					cargarDatos();
					utilidad.tiempoDeEspera();
					break;
				case 5:
					exportarDatos();
					utilidad.tiempoDeEspera();
					break;
				case 6:
					terminarPrograma();
					utilidad.limpiarPantalla();
					break;

				default:
					System.out.println("Ingresaste una opción no válida. Te estoy sacando del Programa <3");
					break;
				}

			} while (opcion >= 1 && opcion <= 5);
		} catch (InputMismatchException ime) {
			System.out.println("Este menú solo acepta números. Creo que quieres salir, así es que lo haré por ti ;)");
		}
		scanner.close();
	}

}
