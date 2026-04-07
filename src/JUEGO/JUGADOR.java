package JUEGO;

public class JUGADOR {
private int medallas;
public String nombre;
	
	public JUGADOR(String nombre) {
		this.nombre = nombre;
		this.medallas = 0;
	}
	public void ganarmedalla() {
		medallas += 1;
	}
	

}
