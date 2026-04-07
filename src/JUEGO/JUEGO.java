package JUEGO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JUEGO {
	public static void main(String[] args) throws IOException {
File registros = new File("Registros.txt");
		
		
BufferedWriter escritor = new BufferedWriter(new FileWriter("Registros.txt"));
		Scanner scanner = new Scanner(System.in);
		

	int respuesta = 0;

	while(respuesta<=0 || respuesta>=4) {

		try {

			System.out.println("1) Continuar.\r\n"
					+ "2) Nueva Partida.\r\n"
					+ "3) Salir.");

			respuesta = scanner.nextInt();
		} catch (Exception e) {

			System.out.println("Respuesta invalida");

			scanner.nextLine();

		}
	}
	switch (respuesta) {

	case 1:

		

		break;

	case 2:


		System.out.println("¿Estas seguro de iniciar una nueva partida? Se borraran todos tus datos anteriores\nSI|NO");

		String borrarpartida = "";
		borrarpartida = scanner.nextLine();
		while (true) {



	borrarpartida = scanner.nextLine();

		if (borrarpartida.equals("NO")) {return;}

		else if (borrarpartida.equals("SI")) {

			System.out.println("Creando una nueva partida...");

			break;

			}

		else {System.out.println("Respuesta incorrecta SI|NO");}

		}

		System.out.println("PULSE ENTER PARA CONTINUAR");

		scanner.nextLine();	

		System.out.println("Oak: ¡Hola! ¡Bienvenido al mundo de los POKÉMON! ¡Mi nombre es OAK! ¡La gente me llama el PROFESOR POKÉMON! \n¡Este mundo está habitado por criaturas llamadas POKÉMON! Para algunas personas, los POKÉMON son mascotas. Otros los usan para pelear. \nYo... estudio a los POKÉMON como profesión. Primero, ¿cuál es tu nombre?");

		String nombre = scanner.nextLine();
		JUGADOR jugador = new JUGADOR(nombre);
		escritor.write(nombre+";"+0);
		escritor.write("\nMawile;Cueva;0.2;50;85;85;55;55;50;Acero\r\n"
				+ "Gliscor;Cueva;0.2;75;95;125;45;75;95;Tierra\r\n"
				+ "MegaMawile;none;0;50;105;125;55;95;50;Acero\r\n"
				+ "MegaBlaziken;none;0;80;160;80;130;80;100;Fuego\r\n"
				+ "Mawile;Cueva;0.2;50;85;85;55;55;50;Acero\r\n"
				+ "Gliscor;Cueva;0.2;75;95;125;45;75;95;Tierra\r\n"
				+ "MegaMawile;none;0;50;105;125;55;95;50;Acero\r\n"
				+ "MegaBlaziken;none;0;80;160;80;130;80;100;Fuego");

		System.out.println("Oak:"+nombre+" ¡Tu propia leyenda POKÉMON está a punto de desarrollarse! ¡Te espera un mundo de sueños y aventuras con POKÉMON! ¡Vamos!");

		System.out.println("PULSE ENTER PARA CONTINUAR");

		scanner.nextLine();	

		
		
		
		
		
		
		FUNCIONES.menu(nombre);
		int opcion = FUNCIONES.pedirOpcionValida(scanner, 1, 8);
		switch (opcion) {
		case 1:
			System.out.println("Equipo: ");
			Scanner registroslector = new Scanner(registros);
			registroslector.nextLine();
			if (!registroslector.hasNextLine()) {System.out.println("No tienes ningun pokemon!");}
			else{while(registroslector.hasNextLine()) {
				for (int i = 0; i < 6; i++) {
					String linea = registroslector.nextLine();
					if (!registroslector.hasNextLine()) {break;}
					System.out.println(linea);
				}
				
			}
			}
			break;

		default:
			break;
		}
		

	default:

		break;

	}
escritor.close();
scanner.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
