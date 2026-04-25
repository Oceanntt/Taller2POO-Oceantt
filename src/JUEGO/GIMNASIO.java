package JUEGO;

import java.util.ArrayList;

public class GIMNASIO {
private String estado;
private String lider;
private ArrayList<POKEMON> pokemongim;
private int numero;

public GIMNASIO(String lider,String estado,int numero,ArrayList<POKEMON> pokemongim) {
	  this.lider = lider;
	    this.estado = estado;
	    this.numero = numero;
	    this.pokemongim = pokemongim;
}

public String getEstado() {
    return estado;
}

public String getLider() {
    return lider;
}

public ArrayList<POKEMON> getPokemongim() {
    return pokemongim;
}

public int getNumero() {
    return numero;
}
}
