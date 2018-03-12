package it.ing.sw.v1;

import java.io.Serializable;

/**
 * Questa classe rappresenta il modello di un Operatore
 */
public class Operatore extends Utente implements Serializable 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo costruttore della classe Operatore
	 * @param n : nome dell'operatore
	 * @param c : cognome dell'operatore
	 * @param u : username dell'operatore
	 * @param p : password dell'operatore
	 */
	public Operatore(String n, String c, String u, String p) 
	{
		super(n, c, u, p);
	}

    /**
     * Metodo che permette la visualizzazione dell'elenco di Fruitori con relative caratteristiche
     * 
     * Pre : e != null
     * 
     * @param e : l'oggetto indicato dove e' depositato il Vector di Fruitori su cui poter invocare il metodo toString()
     * @return la stringa descrittiva dell'anagrafica dei fruitori
     */
	public String visualizzaElencoFruitori(AnagraficaFruitori e) 
	{
		return e.toString();
	}

}
