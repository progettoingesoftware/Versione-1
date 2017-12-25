package it.ing.sw;

/**
 * Importazione delle classi necessarie per la gestione delle date e per l'interazione con l'utente
 */
import java.time.LocalDate;
import java.util.*;

/**
 * Questa classe gestisce la raccolta dati dei vari fruitori e permette il controllo e la verifica di specifiche condizioni necessarie per il mantenimento e l'aggiornamento dei dati
 */
public class AnagraficaFruitori 
{
	/**
	 * L'attributo privato assegnato alla classe AnagraficaFruitori è il vettore contenente le caratteristiche dei vari fruitori che aderiscono al servizio
	 */
	private Vector <Fruitore> elencoFruitori;
    
    /**
     * Costante stringa che permette l'intestazione dell'elenco dei fruitori
     */
    public static final String INTESTAZIONE_ELENCO = "Elenco degli attuali fruitori: \n";
    
    /**
     * Costante numerica intera che specifica il numero di giorni antecedenti la data di scadenza
     */
    public static final int DIECI_GIORNI = 10;
	
    /**
     * Metodo costruttore della classe AnagraficaFruitori
     */    
    public AnagraficaFruitori()
    {
   	    elencoFruitori = new Vector <Fruitore> ();
    }
    
    /**
     * Metodo che permette l'aggiunta di un fruitori all'elenco dei fruitori
     * 
     * @param f : l'oggetto fruitore che si desidera aggiungere
     * 
     * @return void
     */
    public void aggiungiFruitore(Fruitore f)  
    {
   	    elencoFruitori.add(f);
    }
    
    /**
     * Metodo che verifica se il fruitore che intende iscriversi ha contemporaneamente lo stesso nome, lo stesso cognome e la stessa data di nascita di almeno uno dei fruitori già iscritti
     * 
     * @param n : nome del nuovo fruitore
     * @param c : cognome del nuovo fruitore
     * @param dn : data di nascita del nuovo fruitore
     * 
     * @return boolean : true se le condizioni di uguaglianza sono verificate
     */
    public boolean verificaOmonimiaFruitori(String n, String c, LocalDate dn)
    {
    	   for(int i = 0; i < elencoFruitori.size(); i++)
    	   {
    		   Fruitore f = elencoFruitori.get(i);
    		   
    		   if((f.getNome()).equalsIgnoreCase(n) && (f.getCognome().equalsIgnoreCase(c)) && (f.getDataDiNascita().isEquals(dn)))
                 return true;
    	   }
    	   
    	   return false;
    }
    
    /**
     * Metodo che verifica se il fruitore che intende iscriversi ha lo stesso username di almeno uno dei fruitori già iscritti
     * 
     * @param u : username del nuovo fruitore
     * 
     * @return boolean : true se la condizione di uguaglianza è verificata
     */
    public boolean verificaStessoUsername(String u) 
    {
   	    for(int i = 0; i < elencoFruitori.size() ; i++)
   	    {
   	       Fruitore f = elencoFruitori.get(i);
   	    	   
   	    	   if((f.getUsername()).equals(u))
   	    		      return true;
   	    }
   	    
   	    return false;
    }
    
    /**
     * Metodo che verifica se l'utente, identificato tramite lo username e la password, è presente nell'elenco dei fruitori già iscritti
     * 
     * @param u : username identificativo del fruitore
     * @param p : password del fruitore
     * 
     * @return boolean : true se l'utente è già presente nell'elenco dei fruitori
     */
    public boolean accedi(String u, String p)
    {
    	    for(int i = 0; i < elencoFruitori.size(); i++)
    	    {
    	    	  Fruitore f = elencoFruitori.get(i);
    	    	  
    	    	  if((f.getUsername()).equals(u) && (f.getPassword().equals(p)))
    	    			   return true;
    	    }
    	    
    	    return false;
    }
    
    /**
     * Metodo che verifica se la data corrente è successiva rispetto alla data di scadenza del servizio prevista per uno specifico fruitore;
     * in tal caso procede con la rimozione del suddetto fruitore dall'elenco dei fruitori iscritti
     * 
     * @return void
     */
    public void decadenzaFruitore()
    {
   	 	for(int i = 0; i < elencoFruitori.size() ; i++)
   	 	{
   	 		Fruitore f = elencoFruitori.get(i);	
   	 		
   	 		if((LocalDate.now().isAfter(f.getDataDiScadenza())))
	    	 			elencoFruitori.remove(f);    	    	 			
   	 	}
	   
    }
    
    /**
     * Metodo che verifica se la data corrente è compresa nel periodo tra i dieci giorni antecedenti la data di scadenza del servizio (prevista per uno specifico fruitore) e la stessa data di scadenza;
     * in tal caso procede con la modifica della data di scadenza del suddetto fruitore aggiornandola con la data corrente
     * 
     * @param u : username del fruitore
     * 
     * @return boolean : true se la condizione indicata è verificata
     */  
    public boolean rinnovoIscrizioneFruitore(String u)
    {
   	 	for(int i = 0; i < elencoFruitori.size() ; i++)
   	 	{
   	 			Fruitore f = elencoFruitori.get(i);
   	 			
   	 			if(f.getUsername().equals(u))
   	 			{
   	 				/**
   	 				 * La verifica della data avviene mediante due if concatenati:
   	 				 * il primo verifica che la data corrente preceda quella di scadenza indicata per lo specifico fruitore;
   	 				 * il secondo verifica che la data corrente succeda quella di scadenza (indicata per lo specifico fruitore) diminuita di un periodo di 10 giorni
   	 				 */
   	 				if((LocalDate.now().isBefore(f.getDataDiScadenza())))
   	 				{
       	 				if((LocalDate.now().isAfter(f.getDataDiScadenza().minusDays(DIECI_GIORNI))))
   	 							f.setDataDiScadenza(LocalDate.now().plusYears(Fruitore.TERMINE_SCADENZA));
       	 						return true;
   	 				}
   	 			}		
   	 	}
	    
   	 	return false;
    }  
    
    /**
     * Metodo toString() ereditato dalla classe String per la creazione di una stringa descrittiva contenente l'elenco ordinato dei vari fruitori
     * 
     * @return String
     */    
    public String toString()		
    {
   	    StringBuffer ris = new StringBuffer();
   	    ris.append(INTESTAZIONE_ELENCO);
   	    
   	    for(int i = 0; i < elencoFruitori.size(); i++)
   	    {
   	    	    Fruitore f = elencoFruitori.get(i);
   	    	    ris.append(i+1 + ")" + f.toString() + "\n");
   	    }
   	    
   	    return ris.toString();
    }
    
}
