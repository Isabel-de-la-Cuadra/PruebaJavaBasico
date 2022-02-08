package main;

import vistas.Menu;
import vistas.MenuTemplate;

/*
 * A) Crear un proyecto en Java y generar versionamiento con Git y GitHub (1 punto)
 *    https://github.com/Isabel-de-la-Cuadra/PruebaJavaBasico
 * 1. Crear un proyecto nuevo a través de Eclipse como proyecto Java
 * 2. Crear 6 paquetes sobre los cuales trabajaremos: main, modelo, servicio, test, utilidades y vista
 * 5. Crear la clase Main con método public static void en el package main, la cual usará una instancia para iniciar el menú.
 */


public class Main {

	public static void main(String[] args) {
		
		MenuTemplate menu = new Menu();
		menu.iniciarMenu();
	}

}
