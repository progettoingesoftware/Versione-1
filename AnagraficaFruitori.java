package it.ing.sw;

import java.time.LocalDate;
import java.util.*;

public class AnagraficaFruitori 
{
	private Vector <Fruitore> elencoFruitori;

    public static final String INTESTAZIONE_ELENCO = "Elenco degli attuali fruitori: \n";
    public static final int DIECI_GIORNI = 10;
	
    /**
     * Metodo costruttore della classe AnagraficaFruitori
     */    
    public AnagraficaFruitori()
    {
   	    elencoFruitori = new Vector <Fruitore> ();
   	    	assert (elencoFruitori != null) : "Errore";
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
    		assert elencoFruitori.contains(f) : "Errore";
    }
    
    /**
     * Metodo che verifica se il fruitore che intende iscriversi ha contemporaneamente lo stesso nome, lo stesso cognome e la stessa data di nascita di almeno uno dei fruitori gi� iscritti
     * 
     * @param n : nome del nuovo fruitore
     * @param c : cognome del nuovo fruitore
     * @param dn : data di nascita del nuovo fruitore
     * 
     * @return boolean : true se le condizioni di uguaglianza sono verificate
     */
    public boolean verificaOmonimiaFruitori(String n, String c, LocalDate dn)
    {
	    		assert (elencoFruitori != null) : "Errore";
    	   for(int i = 0; i < elencoFruitori.size(); i++)
    	   {
    		   Fruitore f = elencoFruitori.get(i);
    		   		assert elencoFruitori.contains(f) : "Errore";
    		   
    		   if((f.getNome()).equalsIgnoreCase(n) && (f.getCognome().equalsIgnoreCase(c)) && (f.getDataDiNascita().isEqual(dn)))
                 return true;
    	   }
    	   
    	   return false;
    }
    
    /**
     * Metodo che verifica se il fruitore che intende iscriversi ha lo stesso username di almeno uno dei fruitori gi� iscritti
     * 
     * @param u : username del nuovo fruitore
     * 
     * @return boolean : true se la condizione di uguaglianza � verificata
     */
    public boolean verificaStessoUsername(String u) 
    {
			assert (elencoFruitori != null) : "Errore";
   	    for(int i = 0; i < elencoFruitori.size() ; i++)
   	    {
   	       Fruitore f = elencoFruitori.get(i);
	   				assert elencoFruitori.contains(f) : "Errore";
	   				
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
				assert (elencoFruitori != null) : "Errore";
    	    for(int i = 0; i < elencoFruitori.size(); i++)
    	    {
    	    	  Fruitore f = elencoFruitori.get(i);
    	    	  		assert elencoFruitori.contains(f) : "Errore";
    	    	  	
    	    	  if((f.getUsername()).equals(u) && (f.getPassword().equals(p)))
    	    			   return true;
    	    }
    	    
    	    return false;
    }
    
    /**
     * Metodo che verifica se la data corrente � successiva rispetto alla data di scadenza del servizio prevista per uno specifico fruitore;
     * in tal caso procede con la rimozione del suddetto fruitore dall'elenco dei fruitori iscritti
     * 
     * @return void
     */
    public void decadenzaFruitore()
    {
			assert (elencoFruitori != null) : "Errore";
   	 	for(int i = 0; i < elencoFruitori.size() ; i++)
   	 	{
   	 		Fruitore f = elencoFruitori.get(i);	
   	 				assert elencoFruitori.contains(f) : "Errore";
   	 				
   	 		if((LocalDate.now().isAfter(f.getDataDiScadenza())))
   	 		{
   	 			elencoFruitori.remove(f); 
   	 				assert elencoFruitori.contains(f) == false : "Operazione non completata";
   	 		}
   	 		
   	 	}
	   
    }
    
    /**
     * Metodo che verifica se la data corrente � compresa nel periodo tra i dieci giorni antecedenti la data di scadenza del servizio (prevista per uno specifico fruitore) e la stessa data di scadenza;
     * in tal caso procede con la modifica della data di scadenza del suddetto fruitore aggiornandola con la data corrente
     * 
     * @param u : username del fruitore
     * 
     * @return boolean : true se la condizione indicata � verificata
     */  
    public boolean rinnovoIscrizioneFruitore(String u)
    {
			assert (elencoFruitori != null) : "Errore";
   	 	for(int i = 0; i < elencoFruitori.size() ; i++)
   	 	{
   	 			Fruitore f = elencoFruitori.get(i);
   	 					assert elencoFruitori.contains(f) : "Errore";
   	 					
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
       	 				{
       	 					f.setDataDiScadenza(LocalDate.now().plusYears(Fruitore.TERMINE_SCADENZA));
       	 						assert f.getDataDiScadenza().isEqual(LocalDate.now().plusYears(Fruitore.TERMINE_SCADENZA)) : "Operazione non completata";
	 						return true;
       	 				}
   	 						
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
			assert (elencoFruitori != null) : "Errore";
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
