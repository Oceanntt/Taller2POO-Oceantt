package JUEGO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class POKEMON {
	String nombre;
 String tipo;
int stats;
 boolean vivo;


public POKEMON(String nombre, String tipo,int stats,boolean vivo) {
	this.nombre = nombre;
	this.tipo = tipo;
	this.stats = stats;
	this.vivo = vivo;
	
}
public String getNombre() {
    return nombre;
}
public boolean isvivo() {
	return vivo;
}
public void derrotado() {
	vivo = false;
}

public String getTipo() {
    return tipo;
}

public int getStats() {
    return stats;
}

public static POKEMON buscarEnPokedex(String nombreBuscado,String estado) throws FileNotFoundException {
    File pokedex = new File("Pokedex.txt");
    Scanner sc = new Scanner(pokedex);

    while (sc.hasNextLine()) {
        String linea = sc.nextLine();
        String[] partes = linea.split(";");

        if (partes[0].equals(nombreBuscado)) {
            String tipo = partes[9];
            int stats = 0;
            for (int i = 3; i <9 ; i++) {
            	stats += Integer.parseInt(partes[i]);
				
			}

            sc.close();
            if (estado.equals("Vivo")) {
            return new POKEMON(nombreBuscado, tipo, stats,true);
            }
            else;
            return new POKEMON(nombreBuscado, tipo, stats,false);
        }
 
    }

    sc.close();
	return null;
}




}
