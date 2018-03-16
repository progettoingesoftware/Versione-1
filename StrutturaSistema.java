package interazione_1;

import java.io.Serializable;

import logica_1.*;

/**
 * Qusta classe contiene dei metodi per la creazione della struttura preimpostata di alcuni aspetti del sistema
 */
public class StrutturaSistema implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo per la creazione e l'aggiunta di 5 operatori preimpostati all'elenco degli operatori presente in AnagraficaOperatori
	 * 
	 * Pre : ao.elenco != null
	 * 
	 * @param ao : l'istanza della classe AnagraficaOperatore a cui aggiungere gli operatori
	 */
	public static void aggiuntaOperatoriPreimpostati(AnagraficaOperatori ao)
	{
		Operatore primo = new Operatore("Stefano", "Metelli", "ste", "161095");
		Operatore secondo = new Operatore("Alba", "Pasini", "sum56", "33alb33");
		Operatore terzo = new Operatore("Marco", "Bellini", "mark4", "starwars2");
		Operatore quarto = new Operatore("Fabio", "Piccinelli", "picci", "fighter118");
		Operatore quinto = new Operatore("Ottavia", "Lauretti", "oct4565", "ppla210");
		
		ao.getElenco().addElement(primo);
		ao.getElenco().addElement(secondo);
		ao.getElenco().addElement(terzo);
		ao.getElenco().addElement(quarto);
		ao.getElenco().addElement(quinto);
	}
	
}
