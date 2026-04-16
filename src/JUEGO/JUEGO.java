package JUEGO;
// Sebastian Parada 22.312.246-9 ICCI
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JUEGO {
	public static void main(String[] args) throws IOException {
	String nombre = "";
File registros = new File("Registros.txt");
File pokedex = new File("Pokedex.txt");	
File gimnasios = new File("Gimnasios.txt");	
JUGADOR jugador = null;
		
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
		String[] partes = linea.split(";");
	 nombre = partes[0];
		int medallas = Integer.parseInt(partes[1]);
		ArrayList<POKEMON> listaaux = new ArrayList<>();
		while (primerlectorregistro.hasNextLine()) {
			linea = primerlectorregistro.nextLine();
			partes = linea.split(";");
			
			POKEMON p = POKEMON.buscarEnPokedex(partes[0]);
			listaaux.add(p);
	
		}
		jugador = new JUGADOR(nombre,medallas,listaaux);
		

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
		 jugador = new JUGADOR(nombre,0,null);
		
		
		
		
		
	default:

		break;

	}
	
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
	boolean pasar = true;
	Scanner lectorregistro = new Scanner(registros);
	lectorregistro.nextLine();
	while (lectorregistro.hasNextLine()) {
		String linea = lectorregistro.nextLine();
		String[] partes = linea.split(";");
		if (partes[0].equals(pokerandom)) {
			System.out.println("No puedes capturar este pokemon porque ya lo tienes!");
			pasar = false;
			break;}
	}
	
	if (pasar) {
	
	
	
	System.out.println(pokerandom+" Capturado exitosamente, ha sido agregado a tu equipo");
	escritor.write(pokerandom+";Vivo\n");
	escritor.flush();
	jugador.agregarpokemon(POKEMON.buscarEnPokedex(pokerandom));  
	}
}
          
			break;
		case 3:
			
			Scanner registrolector = new Scanner(registros);
			 contador = 1;
			 System.out.println("0)Salir");
			 ArrayList<String> listaaux = new ArrayList<>();
			 listaaux.add(registrolector.nextLine());
			 if (!registrolector.hasNextLine()) {System.out.println("No tienes ningun pokemon!");}
				else{
					
					 while (registrolector.hasNextLine()) {
						 
						 String linea = registrolector.nextLine();
						 listaaux.add(linea);
						 String[] partes = linea.split(";");
						 System.out.println(contador+")"+partes[0]);
						 contador+=1;
						 
					 }
					 
					 System.out.println("Elija el Pokemon a ser cambiado: ");
					 int opcion1 = FUNCIONES.pedirOpcionValida(scanner, 0, contador-1);
					 System.out.println("Elija el Pokemon de cambiado: ");
					 int opcion2 = FUNCIONES.pedirOpcionValida(scanner, 0, contador-1);
					 if (opcion1 == 0 || opcion2 ==0) {break;}
					 
					 jugador.intercambiarPokemons(opcion1-1, opcion2-1);
					 String aux = listaaux.get(opcion1);
					 listaaux.set(opcion1, listaaux.get(opcion2));
					 listaaux.set(opcion2, aux);
					 
					 escritor = new BufferedWriter(new FileWriter("Registros.txt"));
					 
					 for (int i = 0; i < listaaux.size(); i++) {
						escritor.write(listaaux.get(i)+"\n");
						escritor.flush();
					}
					 
					 
					 
					 
				}
			 
			 break;
			 
			 
			
			 
			
		case 4:
			Scanner scgimnasios = new Scanner(gimnasios);
			System.out.println("0)Regresar");
			while (scgimnasios.hasNextLine()) {
				String linea = scgimnasios.nextLine();
				String[] partes = linea.split(";");
				System.out.println(partes[0]+")"+partes[1]+": "+partes[2]);
				
			}
			opcion = FUNCIONES.pedirOpcionValida(scanner, 0, 8);
			if (opcion == 0) {break;}
			if (opcion > jugador.getmedallas() +1) {
				System.out.println("Ross: Cada cosa a su momento, debes derrotar a los otros lideres primero");
				break;}
			
			scgimnasios = new Scanner(gimnasios);
			for (int i = 1; i < opcion; i++) {
				scgimnasios.nextLine();
			}
			String linea = scgimnasios.nextLine();
			String[] partes = linea.split(";");
			String lider = partes[1];
			int num = Integer.parseInt(partes[0]);
			String estado = partes[2];
			int numpokemons = Integer.parseInt(partes[3]);
			ArrayList<POKEMON> pokemonslider = new ArrayList<>();
			for (int i = 0; i < numpokemons; i++) {
				pokemonslider.add(POKEMON.buscarEnPokedex(partes[i+3]));
			}
			
			
					System.out.println("Desafiando a "+lider+"!!");

			
			
			
			
			
			
			
		default:
			break;
			}
		
		}

	}
	

	

}
