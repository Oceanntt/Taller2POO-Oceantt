package JUEGO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class JUEGO {
	public static void main(String[] args) throws IOException {
File registros = new File("Registros.txt");
File pokedex = new File("Pokedex.txt");		
		
Random ran = new Random();
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

		System.out.println("ROSS: ¡Hola! ¡Bienvenido al mundo de los POKÉMON! ¡Mi nombre es Eric Ross! ¡La gente me llama el JEFE DE CARRERA POKÉMON! \n¡Este mundo está habitado por criaturas llamadas POKÉMON! Para algunas personas, los POKÉMON son mascotas. Otros los usan para pelear. \nYo... estudio a los POKÉMON como profesión. Primero, ¿cuál es tu nombre?");

		String nombre = scanner.nextLine();
		JUGADOR jugador = new JUGADOR(nombre);
		escritor.write(nombre+";"+0);
		escritor.flush();
		System.out.println("ROSS:"+nombre+" ¡Tu propia leyenda POKÉMON está a punto de desarrollarse! ¡Te espera un mundo de sueños y aventuras con POKÉMON! ¡Vamos!");

		System.out.println("PULSE ENTER PARA CONTINUAR");

		scanner.nextLine();	

		
		
		
		
		while(true) {
		
		FUNCIONES.menu(nombre);
		int opcion = FUNCIONES.pedirOpcionValida(scanner, 1, 8);
		switch (opcion) {
		case 8:
			return;
		case 1:
			int contador = 0;
			System.out.println("Equipo: ");
			Scanner registroslector = new Scanner(registros);
			registroslector.nextLine();
			if (!registroslector.hasNextLine()) {System.out.println("No tienes ningun pokemon!");}
			else{
				while(registroslector.hasNextLine() && contador <6) 
			{
					String linea = registroslector.nextLine();
					if (!registroslector.hasNextLine()) {break;}
					System.out.println(linea);
				contador+=1;
			}
			}
			break;
		case 2:
System.out.println("Donde deseas ir a explorar?");
			System.out.println("Zonas disponibles: ");
			File habitats = new File("Habitats.txt");
			ArrayList<String> listahabitats = new ArrayList<>();
			Scanner lectorHabitat = new Scanner(habitats);
			 contador = 1;
			while(lectorHabitat.hasNextLine()) {
				String linea = lectorHabitat.nextLine();
				listahabitats.add(linea);
				System.out.println(contador+") "+linea);
				contador +=1;

			}
			System.out.println(contador+") volver al menu");
			System.out.print("INGRESE ZONA: ");

			int opcionzona = FUNCIONES.pedirOpcionValida(scanner, 1, 7);
			if (opcionzona == contador) {break;}
			 ArrayList<String> pokemoneshabitat = new ArrayList<>();
			Scanner scapokedex = new Scanner(pokedex);
			while (scapokedex.hasNextLine()) {
				
				String linea = scapokedex.nextLine();
				String[] partes = linea.split(";");
				String habitat = partes[1];
				if (habitat.equals(listahabitats.get(opcionzona-1))) {
					pokemoneshabitat.add(partes[0]);
				}
				
				
			}
			
			String pokerandom = pokemoneshabitat.get(ran.nextInt(pokemoneshabitat.size()));
			System.out.println("Oh! un "+pokerandom+" salvaje ha aparecido");
System.out.println("Que deseas hacer?\r\n"
		+ "\r\n"
		+ "1) Capturar\r\n"
		+ "2) Huir");
int opcioncaptura = FUNCIONES.pedirOpcionValida(scanner, 1, 2);
if (opcioncaptura ==2) {break;}
else {
	System.out.println(pokerandom+" Capturado exitosamente, ha sido agregado a tu equipo");
	escritor.write("\n"+pokerandom+";Vivo\n");
	escritor.flush();
	
}
escritor.flush();
			break;

		default:
			break;
		}
		
		}
	default:

		break;

	}
		
escritor.close();
scanner.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
