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
	String nombre = "";
File registros = new File("Registros.txt");
File pokedex = new File("Pokedex.txt");		
		
Random ran = new Random();
BufferedWriter escritor = new BufferedWriter(new FileWriter("Registros.txt",true));
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
		Scanner primerlectorregistro = new Scanner(registros);
		String linea = primerlectorregistro.nextLine();
		
		
		

		break;

	case 2:
		escritor = new BufferedWriter(new FileWriter("Registros.txt"));

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

		 nombre = scanner.nextLine();
		 
		
		escritor.write(nombre+";"+0+"\n");
		escritor.flush();
		System.out.println("ROSS:"+nombre+" ¡Tu propia leyenda POKÉMON está a punto de desarrollarse! ¡Te espera un mundo de sueños y aventuras con POKÉMON! ¡Vamos!");

		System.out.println("PULSE ENTER PARA CONTINUAR");

		scanner.nextLine();	

		
		
		
		
		
	default:

		break;

	}
	JUGADOR jugador = new JUGADOR(nombre,0,null);
while(true) {
		nombre = jugador.getnombre();
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
jugador.mostrarPokemons();
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
			 ArrayList<Double> porcentajesaparicion = new ArrayList<>();
			Scanner scapokedex = new Scanner(pokedex);
			while (scapokedex.hasNextLine()) {
				
				String linea = scapokedex.nextLine();
				String[] partes = linea.split(";");
				String habitat = partes[1];
				if (habitat.equals(listahabitats.get(opcionzona-1))) {
					pokemoneshabitat.add(partes[0]);
					porcentajesaparicion.add(Double.parseDouble(partes[2]));
				}
				
				
			}
			
			String pokerandom = "";
			Double prob = ran.nextDouble();
			Double probacumulada = 0.0;
			
			for (int i = 0; i < pokemoneshabitat.size(); i++) {
				probacumulada += porcentajesaparicion.get(i);
				 if (prob < probacumulada) {
		                pokerandom = pokemoneshabitat.get(i);
		                break;
				 }
				 
			}
			
			
			
			
			
			
			
			
			
			System.out.println("Oh! un "+pokerandom+" salvaje ha aparecido");
System.out.println("Que deseas hacer?\r\n"
		+ "\r\n"
		+ "1) Capturar\r\n"
		+ "2) Huir");
int opcioncaptura = FUNCIONES.pedirOpcionValida(scanner, 1, 2);
if (opcioncaptura ==2) {break;}
else {
	
	
	
	
	
	
	System.out.println(pokerandom+" Capturado exitosamente, ha sido agregado a tu equipo");
	escritor.write(pokerandom+";Vivo\n");
	escritor.flush();
	
}
escritor.flush();

jugador.agregarpokemon(POKEMON.buscarEnPokedex(pokerandom));            
			break;
		case 3:
			
			Scanner registrolector = new Scanner(registros);
			 contador = 1;
			 System.out.println("0)Salir");
			 registrolector.nextLine();
			 if (!registrolector.hasNextLine()) {System.out.println("No tienes ningun pokemon!");}
				else{
					 while (registrolector.hasNextLine()) {
						 String linea = scanner.nextLine();
						 String[] partes = linea.split(";");
						 System.out.println(contador+")"+partes[0]);
						 
					 }
					 
					 System.out.println("Elija el Pokemon a ser cambiado: ");
					 int opcion1 = FUNCIONES.pedirOpcionValida(scanner, 0, contador);
					 System.out.println("Elija el Pokemon de cambiado: ");
					 int opcion2 = FUNCIONES.pedirOpcionValida(scanner, 0, contador);
					 
					 jugador.intercambiarPokemons(opcion1, opcion2);
					 
					 
					 
					 
					 
					 
				}
			 
			 break;
			 
			 
			
			 
			
			
			
			
			
			
			
			
			
			
			
			
		default:
			break;
			}
		
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
