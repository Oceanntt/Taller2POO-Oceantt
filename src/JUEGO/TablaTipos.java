package JUEGO;
import java.util.ArrayList;
public class TablaTipos {
	ArrayList<String> tipos = new ArrayList<>(
		    java.util.Arrays.asList(
		        "Normal","Fuego","Agua","Planta","Electrico","Hielo",
		        "Lucha","Veneno","Tierra","Volador","Psiquico","Bicho",
		        "Roca","Fantasma","Dragon","Acero","Siniestro","Hada"
		    )
		    );
		
		

	 private static final double[][] EFECTIVIDAD = {
		        // NOR  FUE  AGU  PLA  ELE  HIE  LUC  VEN  TIE  VOL  PSI  BIC  ROC  FAN  DRA  ACE  SIN  HAD
		        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0, 0.5, 1.0, 1.0 }, // NORMAL
		        {  1.0, 0.5, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0 }, // FUEGO
		        {  1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0 }, // AGUA
		        {  1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 0.5, 0.5, 1.0, 1.0 }, // PLANTA
		        {  1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0 }, // ELECTRICO
		        {  1.0, 0.5, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0 }, // HIELO
		        {  2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 0.5, 2.0, 0.0, 1.0, 2.0, 2.0, 0.5 }, // LUCHA
		        {  1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 0.0, 1.0, 2.0 }, // VENENO
		        {  1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 0.5, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0 }, // TIERRA
		        {  1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 0.5, 1.0, 1.0 }, // VOLADOR
		        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0 }, // PSIQUICO
		        {  1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 0.5, 2.0, 0.5 }, // BICHO
		        {  1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0 }, // ROCA
		        {  0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0 }, // FANTASMA
		        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.0 }, // DRAGON
		        {  1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0 }, // ACERO
		        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5 }, // SINIESTRO
		        {  1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0, 1.0 }  // HADA
		    };
public double verificarefectividad(POKEMON pokemonjugador, POKEMON pokemonrival) {
String tipojugador = pokemonjugador.getTipo();
String tiporival = pokemonrival.getTipo();
int indice1 = tipos.indexOf(tipojugador);
int indice2 = tipos.indexOf(tiporival);
double efectividad = EFECTIVIDAD[indice1][indice2];
return efectividad;

	
	
	
}
	 
	 
	 
	 
	 
	 
	 
}
