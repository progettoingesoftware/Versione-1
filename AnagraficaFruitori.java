package it.ing.sw;

import java.time.LocalDate;
import java.util.*;

public class AnagraficaFruitori 
{
     private Vector <Fruitore> elencoFruitori;
     
     public static final String INTESTAZIONE_ELENCO = "Elenco degli attuali fruitori: \n";
     public static final int DIECI_GIORNI = 10;
 	 public static final int TERMINE_SCADENZA = 5;
     
     public AnagraficaFruitori()
     {
    	    elencoFruitori = new Vector <Fruitore> ();
     }
     
     public void aggiungiFruitore(Fruitore f)  //nel main quando un cittadino vuole iscriversi, creiamo il fruitore e dal main lo aggiungiamo all'elenco dei fruitori
     {
    	    elencoFruitori.add(f);
     }
     
     public boolean verificaOmonimiaFruitori(String username) // 2 fruitori sono omonimi quando hanno lo stesso username. Se true, devo chiedere all'utente di inserire un nuovo username (questo lo faccio nel main)
     {
    	    for(int i = 0; i < elencoFruitori.size() ; i++)
    	    {
    	    	   Fruitore f = elencoFruitori.get(i);
    	    	   if((f.getUsername()).equals(username))
    	    		      return true;
    	    }
    	    
    	    return false;
     }
     
     public void decadenzaFruitore()
     {
    	 	for(int i = 0; i < elencoFruitori.size() ; i++)
    	 	{
    	 		Fruitore f = elencoFruitori.get(i);
    	 			
    	 		
    	 		if((LocalDate.now().isAfter(f.getDataDiScadenza())))
	    	 			elencoFruitori.remove(f);    	    	 			
    	 	}
 	   
     }
     
     public boolean rinnovoIscrizioneFruitore(String username)
     {
    	 	for(int i = 0; i < elencoFruitori.size() ; i++)
    	 	{
    	 			Fruitore f = elencoFruitori.get(i);
    	 			if(f.getUsername().equals(username))
    	 			{
    	 				if((LocalDate.now().isBefore(f.getDataDiScadenza())))
    	 				{
        	 				if((LocalDate.now().isAfter(f.getDataDiScadenza().minusDays(DIECI_GIORNI))))
    	 							f.setDataDiScadenza(LocalDate.now().plusYears(TERMINE_SCADENZA));
        	 						return true;
    	 				}


    	 			}
    	 				
    	 	}
 	    
    	 	return false;
     }     
     
     /*
      * Avevamo fatto nello stesso modo nel progetto di Serina. Nella classe Operatore il metodo visualizzaElencoFruitori
      * avrÃ  come parametro un oggetto di tipo elencoFruitori; su questo invoca il toString definito qui sotto.
      * 
      */
     public String toString()		// Dichiarazione statica + ho cambiato il nome del metodo perchè entrava in conflitto con il toString() della classe String
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
