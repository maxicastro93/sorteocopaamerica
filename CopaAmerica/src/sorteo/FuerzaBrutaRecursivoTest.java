package sorteo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FuerzaBrutaRecursivoTest {

//	dispersion de grupo null
//	dispersion de grupo negativa
//	minima dispersion null
//	pais repetido null
	
	
	@Test(expected = IllegalArgumentException.class)
	public void grupoIncompleto()
	{
		ArrayList<Pais> paises = new ArrayList<Pais>(12);
		FuerzaBrutaRecursivo fuerzaBrut = new FuerzaBrutaRecursivo(paises);
		ArrayList<Pais> grupo = new ArrayList<Pais>();
		
		fuerzaBrut.grupoValido(grupo);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void dispersionNegativa()
	{
		ArrayList<Pais> paises = new ArrayList<Pais>(12);
		FuerzaBrutaRecursivo fuerzaBrut = new FuerzaBrutaRecursivo(paises);
		double d = -1.2;
		fuerzaBrut.dispersionValida(d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void paisRepetidoNull()
	{
		ArrayList<Pais> paises = new ArrayList<Pais>();
		FuerzaBrutaRecursivo fuerzaBrut = new FuerzaBrutaRecursivo(paises);
		paises.add(new Pais(0, "Argentina", 11));
		paises.add(new Pais(1, "Brasil", 12));
		paises.add(new Pais(2, "Bolivia", 3));
		paises.add(new Pais(3, "Colombia", 8));
		Pais p = null;
		fuerzaBrut.paisRepetido(p, paises);
	}
	

	
	
	@Test
	public void paisRepetidoEnGrupo()
	{
		ArrayList<Pais> paises = new ArrayList<Pais>();
		FuerzaBrutaRecursivo fuerzaBrut = new FuerzaBrutaRecursivo(paises);
		Pais p = new Pais(3, "Colombia", 8);
		paises.add(p);
		paises.add(p);
		paises.add(p);
		paises.add(p);
		assertTrue(fuerzaBrut.paisRepetido(p, paises));
	}
	
	@Test
	public void paisNoRepetidoEnGrupo()
	{
		ArrayList<Pais> paises = new ArrayList<Pais>();
		FuerzaBrutaRecursivo fuerzaBrut = new FuerzaBrutaRecursivo(paises);
		Pais a = new Pais(0, "Colombia", 8);
		Pais b = new Pais(1, "Argentina", 11);
		Pais c = new Pais(2, "Bolivia", 3);
		Pais d = new Pais(3, "Brasil", 12);
		Pais e = new Pais(4, "Peru", 6);
		paises.add(a);
		paises.add(b);
		paises.add(c);
		paises.add(d);
		assertFalse(fuerzaBrut.paisRepetido(e, paises));
	}

}
