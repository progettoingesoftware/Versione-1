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
    
    public void aggiungiFruitore(Fruitore f)  
    {
   	    elencoFruitori.add(f);
    }
    
    public boolean verificaOmonimiaFruitori(String n, String c, LocalDate dn)
    {
    	   for(int i = 0; i < elencoFruitori.size(); i++)
    	   {
    		   Fruitore f = elencoFruitori.get(i);
    		   
    		   if((f.getNome()).equalsIgnoreCase(n) && (f.getCognome().equalsIgnoreCase(c)) && (f.getDataDiNascita().equals(dn)))
                 return true;
    	   }
    	   
    	   return false;
    }
    
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
    
    public void decadenzaFruitore()
    {
   	 	for(int i = 0; i < elencoFruitori.size() ; i++)
   	 	{
   	 		Fruitore f = elencoFruitori.get(i);	
   	 		
   	 		if((LocalDate.now().isAfter(f.getDataDiScadenza())))
	    	 			elencoFruitori.remove(f);    	    	 			
   	 	}
	   
    }
    
    public boolean rinnovoIscrizioneFruitore(String u)
    {
   	 	for(int i = 0; i < elencoFruitori.size() ; i++)
   	 	{
   	 			Fruitore f = elencoFruitori.get(i);
   	 			
   	 			if(f.getUsername().equals(u))
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
