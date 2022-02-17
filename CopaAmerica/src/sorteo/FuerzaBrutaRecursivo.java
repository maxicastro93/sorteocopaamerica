package sorteo;


import java.util.ArrayList;

public class FuerzaBrutaRecursivo
{
	public ArrayList<Pais> paises;
	public ArrayList<ArrayList<Pais>> soluciones;
	public ArrayList<ArrayList<Pais>> solucionesAux;
	public ArrayList<ArrayList<Pais>> solucionesMain;
	public ArrayList<ArrayList<ArrayList<Pais>>> solFinal;
	public double MinimaDispersionAnterior;
	public int z;
	public ArrayList<ArrayList<Pais>> solucionFinal;


	
	public FuerzaBrutaRecursivo (ArrayList<Pais> listaPaises)
	{
		paises = listaPaises;
		soluciones = new ArrayList<ArrayList<Pais>>();
		solucionesAux = new ArrayList<ArrayList<Pais>>();
		solucionesMain = new ArrayList<ArrayList<Pais>>();
		solFinal = new ArrayList<ArrayList<ArrayList<Pais>>>();
		soluciones.add(new ArrayList<Pais>());
		soluciones.add(new ArrayList<Pais>());
		soluciones.add(new ArrayList<Pais>());
		MinimaDispersionAnterior = 0;
		
		solucionesAux.add(new ArrayList<Pais>());
		solucionesAux.add(new ArrayList<Pais>());
		solucionesAux.add(new ArrayList<Pais>());
		
		solucionesMain.add(new ArrayList<Pais>());
		solucionesMain.add(new ArrayList<Pais>());
		solucionesMain.add(new ArrayList<Pais>());
		
	}

	public void recursion (int n)
	{
		//Caso Base #1
		
		if (solFinal.size()<1 && n == 8)
		{
			for(int i = 0; i< paises.size(); i++)
			{
				if (!paisRepetido(paises.get(i), soluciones.get(0))
					&& !paisRepetido(paises.get(i), soluciones.get(1)))
					soluciones.get(2).add(paises.get(i));
			}
			
			solucionesAux.get(0).add(soluciones.get(0).get(0));
			solucionesAux.get(0).add(soluciones.get(0).get(1));
			solucionesAux.get(0).add(soluciones.get(0).get(2));
			solucionesAux.get(0).add(soluciones.get(0).get(3));
			solucionesAux.get(1).add(soluciones.get(1).get(0));
			solucionesAux.get(1).add(soluciones.get(1).get(1));
			solucionesAux.get(1).add(soluciones.get(1).get(2));
			solucionesAux.get(1).add(soluciones.get(1).get(3));
			solucionesAux.get(2).add(soluciones.get(2).get(0));
			solucionesAux.get(2).add(soluciones.get(2).get(1));
			solucionesAux.get(2).add(soluciones.get(2).get(2));
			solucionesAux.get(2).add(soluciones.get(2).get(3));
			
			solucionesMain.get(0).add(0, solucionesAux.get(0).get(0));
			solucionesMain.get(0).add(1, solucionesAux.get(0).get(1));
			solucionesMain.get(0).add(2, solucionesAux.get(0).get(2));
			solucionesMain.get(0).add(3, solucionesAux.get(0).get(3));
			solucionesMain.get(1).add(0, solucionesAux.get(1).get(0));
			solucionesMain.get(1).add(1, solucionesAux.get(1).get(1));
			solucionesMain.get(1).add(2, solucionesAux.get(1).get(2));
			solucionesMain.get(1).add(3, solucionesAux.get(1).get(3));
			solucionesMain.get(2).add(0, solucionesAux.get(2).get(0));
			solucionesMain.get(2).add(1, solucionesAux.get(2).get(1));
			solucionesMain.get(2).add(2, solucionesAux.get(2).get(2));
			solucionesMain.get(2).add(3, solucionesAux.get(2).get(3));
			
			
			
			solFinal.add(solucionesAux);
			MinimaDispersionAnterior = MinimaDispersion(solucionesAux);
			
			soluciones.get(2).remove(3);
			soluciones.get(2).remove(2);
			soluciones.get(2).remove(1);
			soluciones.get(2).remove(0);
			return;
		}
		
		//Caso Base #2
		
		if (n==8 && solFinal.size()>=1)
		{	
			for(int i = 0; i< paises.size(); i++)
			{
				if (!paisRepetido(paises.get(i), soluciones.get(0))
					&& !paisRepetido(paises.get(i), soluciones.get(1)))
					soluciones.get(2).add(paises.get(i));
			}
			
			solucionesAux.get(0).set(0, soluciones.get(0).get(0));
			solucionesAux.get(0).set(1, soluciones.get(0).get(1));
			solucionesAux.get(0).set(2, soluciones.get(0).get(2));
			solucionesAux.get(0).set(3, soluciones.get(0).get(3));
			solucionesAux.get(1).set(0, soluciones.get(1).get(0));
			solucionesAux.get(1).set(1, soluciones.get(1).get(1));
			solucionesAux.get(1).set(2, soluciones.get(1).get(2));
			solucionesAux.get(1).set(3, soluciones.get(1).get(3));
			solucionesAux.get(2).set(0, soluciones.get(2).get(0));
			solucionesAux.get(2).set(1, soluciones.get(2).get(1));
			solucionesAux.get(2).set(2, soluciones.get(2).get(2));
			solucionesAux.get(2).set(3, soluciones.get(2).get(3));

			solFinal.add(solucionesAux);
			z++;
			if(MinimaDispersionAnterior < MinimaDispersion(solucionesAux))
			{
				MinimaDispersionAnterior = MinimaDispersion(solucionesAux);
				
				solucionesMain.get(0).set(0, solucionesAux.get(0).get(0));
				solucionesMain.get(0).set(1, solucionesAux.get(0).get(1));
				solucionesMain.get(0).set(2, solucionesAux.get(0).get(2));
				solucionesMain.get(0).set(3, solucionesAux.get(0).get(3));
				solucionesMain.get(1).set(0, solucionesAux.get(1).get(0));
				solucionesMain.get(1).set(1, solucionesAux.get(1).get(1));
				solucionesMain.get(1).set(2, solucionesAux.get(1).get(2));
				solucionesMain.get(1).set(3, solucionesAux.get(1).get(3));
				solucionesMain.get(2).set(0, solucionesAux.get(2).get(0));
				solucionesMain.get(2).set(1, solucionesAux.get(2).get(1));
				solucionesMain.get(2).set(2, solucionesAux.get(2).get(2));
				solucionesMain.get(2).set(3, solucionesAux.get(2).get(3));
			}
			soluciones.get(2).remove(3);
			soluciones.get(2).remove(2);
			soluciones.get(2).remove(1);
			soluciones.get(2).remove(0);

			return;
		}
		
		for(int i = 0; i< paises.size(); i++)
		{
			if (!paisRepetido(paises.get(i), soluciones.get(0))
				&& !paisRepetido(paises.get(i), soluciones.get(1)))
				{

					if(soluciones.get(0).size()<4)
					{
						soluciones.get(0).add(paises.get(i));
						recursion(n+1);
						soluciones.get(0).remove(soluciones.get(0).size()-1);
						
					}
					else if(soluciones.get(1).size()<4)
					{
						soluciones.get(1).add(paises.get(i));
						recursion(n+1);
						soluciones.get(1).remove(soluciones.get(1).size()-1);
					}
					
				}
		}
		
	}
	
	
	public double dispersionGrupo (ArrayList<Pais> p)
	{

		grupoValido(p);
		
		double disp = 0;
		double promedio = (p.get(0).ranking + p.get(1).ranking + p.get(2).ranking + p.get(3).ranking) / 4;
		
		double d1 = Math.pow((p.get(0).ranking - promedio),2) / (4-1);
		double d2 = Math.pow((p.get(1).ranking - promedio),2) / (4-1);
		double d3 = Math.pow((p.get(2).ranking - promedio),2) / (4-1);
		double d4 = Math.pow((p.get(3).ranking - promedio),2) / (4-1);

		disp = d1+d2+d3+d4;
		dispersionValida(disp);
		return disp;
	}

	public void grupoValido(ArrayList<Pais> p) {
		
		if(p.size() < 4)
			throw new IllegalArgumentException("el grupo esta vacio o incompleto");
	}

	public void dispersionValida(double d) 
	{
		if(d < 0)
			throw new IllegalArgumentException("la dispersion del grupo es negativa!");
	}
	
	public double MinimaDispersion (ArrayList<ArrayList<Pais> > p)
	{
		double a = dispersionGrupo(p.get(0));
		double b = dispersionGrupo(p.get(1));
		double c = dispersionGrupo(p.get(2));
		grupoValido(p.get(0));
		grupoValido(p.get(1));
		grupoValido(p.get(2));
		dispersionValida(a);
		dispersionValida(b);
		dispersionValida(c);
		
		double minimo=a;
	
		if(b<a)
			minimo = b;
		
		if(c < minimo)
			minimo = c;
		
		if(minimo < 0)
			throw new IllegalArgumentException("dispersion negativa !!");
			
		return minimo;
			
		
	}
	
	public boolean paisRepetido(Pais pais, ArrayList<Pais> grupo) 
	{
		if(pais == null)
			throw new IllegalArgumentException("Pais no valido o null");
					
		if( grupo.contains(pais))
			return true;
		else
			return false;
	}

	
}