package JUEGO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JUGADOR {
private int medallas;
public String nombre;
public ArrayList<POKEMON> pokemonsjugador;
	
	public JUGADOR(String nombre,int medallas, ArrayList<POKEMON> pokemonsjugador) {
		this.nombre = nombre;
		this.medallas = medallas;
		this.pokemonsjugador = pokemonsjugador;
	}
	public void ganarmedalla() {
		medallas += 1;
	}
	public String getnombre() {
		return nombre;
		
	}
	public ArrayList<POKEMON> getPokemonsjugador() {
		return pokemonsjugador;
	}
	public int getmedallas() {
		return medallas;
	}
	public void agregarpokemon(POKEMON elemento) {
		pokemonsjugador.add(elemento);
	}
	public void mostrarPokemons() {
	    for (int i = 0; i < pokemonsjugador.size() && i < 6; i++) {
	        POKEMON p = pokemonsjugador.get(i);
	        System.out.println(i+1+")"+p.getNombre()+"|"+p.getTipo()+"|"+p.getStats());

	    }
	}
	

	public void intercambiarPokemons(int i, int j, File registros) throws IOException {
	    if (i < 0 || j < 0 ||  i==j ||i >= pokemonsjugador.size() || j >= pokemonsjugador.size()  ) {
	        System.out.println("Posiciones inválidas.");
	        return;
	    }

	    POKEMON aux = pokemonsjugador.get(i);
	    pokemonsjugador.set(i, pokemonsjugador.get(j));
	    pokemonsjugador.set(j, aux);
	    Scanner lector = new Scanner(registros);
	    ArrayList<String> lineas = new ArrayList<>();

	    while (lector.hasNextLine()) {
	        lineas.add(lector.nextLine());
	    }
	    int lineaPokemon1 = i + 1;
	    int lineaPokemon2 = j + 1;

	    String auxLinea = lineas.get(lineaPokemon1);
	    lineas.set(lineaPokemon1, lineas.get(lineaPokemon2));
	    lineas.set(lineaPokemon2, auxLinea);

	    BufferedWriter escritor = new BufferedWriter(new FileWriter(registros));
	    for (String linea : lineas) {
	        escritor.write(linea + "\n");
	    }

	    escritor.flush();
	    escritor.close();
	    
	    
	}
	public void cambiarencombate(int i ,int j) {
		 if (i < 0 || j < 0 ||  i==j ||i >= pokemonsjugador.size() || j >= pokemonsjugador.size() || i >6||j>6 ) {
		        System.out.println("Posiciones inválidas.");
		        return;
		    }

		    POKEMON aux = pokemonsjugador.get(i);
		    pokemonsjugador.set(i, pokemonsjugador.get(j));
		    pokemonsjugador.set(j, aux);
	}
	
	
	public void revivir() {
		for (int i = 0; i < pokemonsjugador.size(); i++) {
			pokemonsjugador.get(i).revivir();
		}
	}
}
