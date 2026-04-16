package JUEGO;

import java.util.ArrayList;

public class JUGADOR {
private int medallas;
public String nombre;
public ArrayList<POKEMON> pokemonsjugador;
	
	public JUGADOR(String nombre,int medallas, ArrayList<POKEMON> pokemonsjugador) {
		this.nombre = nombre;
		this.medallas = medallas;
		this.pokemonsjugador = new ArrayList<>();
	}
	public void ganarmedalla() {
		medallas += 1;
	}
	public String getnombre() {
		return nombre;
		
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
	        System.out.println(p.getNombre()+"|"+p.getTipo()+"|"+p.getStats());

	    }
	}
	public void intercambiarPokemons(int i, int j) {
	    if (i < 0 || j < 0 ||  i==j ||i >= pokemonsjugador.size() || j >= pokemonsjugador.size() ) {
	        System.out.println("Posiciones inválidas.");
	        return;
	    }

	    POKEMON aux = pokemonsjugador.get(i);
	    pokemonsjugador.set(i, pokemonsjugador.get(j));
	    pokemonsjugador.set(j, aux);
	}
}
