package sorteo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {

	public static void main(String[] args) 
	{
		long horaInicio = System.currentTimeMillis();
		long horaFinal;

		ArrayList<Pais> paises = new ArrayList<Pais>(12);
	
		paises.add(new Pais(0, "Argentina", 11));
		paises.add(new Pais(1, "Brasil", 12));
		paises.add(new Pais(2, "Bolivia", 3));
		paises.add(new Pais(3, "Colombia", 8));
		paises.add(new Pais(4, "Peru", 6));
		paises.add(new Pais(5, "Paraguay", 7));
		paises.add(new Pais(6, "Chile", 9));
		paises.add(new Pais(7, "Uruguay",10));
		paises.add(new Pais(8, "Venezuela", 2));
		paises.add(new Pais(9, "Qatar", 1));
		paises.add(new Pais(10,"Japon", 5));
		paises.add(new Pais(11, "Ecuador", 4));
		
		FuerzaBrutaRecursivo fuerzaBrut = new FuerzaBrutaRecursivo(paises);

		fuerzaBrut.recursion(0);

		ArrayList<ArrayList<Pais>> x = fuerzaBrut.solucionesMain;
				
		System.out.println("Grupo 1: ");
		System.out.print(x.get(0).get(0).nombre + " , ");
		System.out.print(x.get(0).get(1).nombre + " , ");
		System.out.print(x.get(0).get(2).nombre + " , ");
		System.out.println(x.get(0).get(3).nombre + " ");
		
		System.out.println("Grupo 2: ");
		System.out.print(x.get(1).get(0).nombre + " , ");
		System.out.print(x.get(1).get(1).nombre + " , ");
		System.out.print(x.get(1).get(2).nombre + " , ");
		System.out.println(x.get(1).get(3).nombre + " ");
		
		System.out.println("Grupo 3: ");
		System.out.print(x.get(2).get(0).nombre + " , ");
		System.out.print(x.get(2).get(1).nombre + " , ");
		System.out.print(x.get(2).get(2).nombre + " , ");
		System.out.println(x.get(2).get(3).nombre + " ");
		System.out.println("");
		System.out.println("Dispersion Grupo 1: " + fuerzaBrut.dispersionGrupo(x.get(0)));
		System.out.println("Dispersion Grupo 2: " + fuerzaBrut.dispersionGrupo(x.get(1)));
		System.out.println("Dispersion Grupo 3: " + fuerzaBrut.dispersionGrupo(x.get(2)));
		System.out.println("");
		
		System.out.println("Minima Dispersion: " + fuerzaBrut.MinimaDispersion(x));
		
		
		horaFinal = System.currentTimeMillis();
		System.out.println("");
		System.out.println("Veces que se ejecuto el Caso Base: " + (fuerzaBrut.z+1));
		System.out.println("");
		
		System.out.println("Tiempo de ejecucion: "+ ((horaFinal-horaInicio)/1000) + " segundos");
	}			
		

	

}
