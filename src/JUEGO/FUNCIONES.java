package JUEGO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FUNCIONES {
	public static void menu(String nombre) {

		System.out.println("Bienvenido "+nombre+"\r\n"
				+ "1) Revisar equipo.\r\n"
				+ "2) Salir a capturar.\r\n"
				+ "3) Acceso al PC (cambiar Pokémon del equipo).\r\n"
				+ "4) Retar un gimnasio.\r\n"
				+ "5) Desafío al Alto Mando.\r\n"
				+ "6) Curar Pokémon.\r\n"
				+ "7) Guardar.\r\n"
				+ "8) Guardar y Salir.");

	}
	public static int pedirOpcionValida(Scanner scanner, int primeraOpcion, int ultimaOpcion) {
	    int opcion = 0;
	    boolean valido = false;

	    while (!valido) {
	        try {
	            System.out.print("Ingrese una opción (" + primeraOpcion + "-" + ultimaOpcion + "): ");
	            opcion = scanner.nextInt();

	            if (opcion >= primeraOpcion && opcion <= ultimaOpcion) {
	                valido = true;
	            } else {
	                System.out.println("Error: opción fuera de rango.");
	            }

	        } catch (InputMismatchException e) {
	            System.out.println("Error: debe ingresar un número entero.");
	            scanner.nextLine(); //
	        }
	    }

	    return opcion;
	}


}
