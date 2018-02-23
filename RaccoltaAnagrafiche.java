package it.ing.sw;

import java.io.Serializable;

/**
 * Questa classe rappresenta un raccoglitore di un'anagrafica di fruitori e di un'anagrafica di operatori
 */
public class RaccoltaAnagrafiche implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AnagraficaFruitori af;
    private AnagraficaOperatori ao;
    
    /**
     * Metodo costruttore della classe RaccoltaAnagrafiche
     * 
     * Pre : af != null
     * Pre : ao != null
     * 
     * @param af: anagrafica dei fruitori
     * @param ao: anagrafica operatori
     */
    public RaccoltaAnagrafiche(AnagraficaFruitori af, AnagraficaOperatori ao)
    {
    	   this.af = af;
    	   this.ao = ao;
    }
    
    /**
     * Metodi get della classe RaccoltaAnagrafiche
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
