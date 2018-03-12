package it.ing.sw.v1;

import java.io.Serializable;

/**
 * Questa classe rappresenta un raccoglitore di dati, utile per la memorizzazione su file
 */
public class RaccoltaDati implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private AnagraficaFruitori af;
	private AnagraficaOperatori ao;

	/**
	 * Metodo costruttore della classe RaccoltaAnagrafiche
	 * 
	 * Pre : af != null 
	 * Pre : ao != null
	 * 
	 * @param af : anagrafica dei fruitori
	 * @param ao : anagrafica operatori
	 */
	public RaccoltaDati(AnagraficaFruitori af, AnagraficaOperatori ao) 
	{
		this.af = af;
		this.ao = ao;
	}

	/**
	 * Metodi get della classe RaccoltaDati
	 */
	public AnagraficaFruitori getAnagraficaFruitori() 
	{
		return af;
	}

	public AnagraficaOperatori getAnagraficaOperatori() 
	{
		return ao;
	}

}
