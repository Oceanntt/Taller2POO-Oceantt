package JUEGO;

import java.util.ArrayList;

public class AltoMando {
	private String nombre;
	private ArrayList<POKEMON> pokemonaltomando;

	
	
	public AltoMando(String altomando,ArrayList<POKEMON> pokemonaltomando) {
		  this.nombre = altomando;
		  this.pokemonaltomando= pokemonaltomando;
	}
	public String getnombre() {
		return nombre;
	}
	public ArrayList<POKEMON> getPokemonaltomando() {
		return pokemonaltomando;
	}

}
