package it.ing.sw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Questa classe rappresenta il modello di un Fruitore
 */
public class Fruitore extends Utente
{
    private LocalDate dataDiNascita;             
    private LocalDate dataDiIscrizione;		
    private LocalDate dataDiScadenza;
      
    public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nData di nascita: %s\nUsername: %s\nPassword: %d\nData di iscrizione: %s";
    public static final int TERMINE_SCADENZA = 5;
    public static final String FORMATO_DATA = "dd/MM/yyyy";
    
    /**
     * Metodo costruttore della classe Fruitore
     * @param n : nome del fruitore
     * @param c : cognome del fruitore
     * @param dn : data di nascita del fruitore
     * @param u : username del fruitore
     * @param p : password del fruitore
     */     
    public Fruitore(String n, String c, LocalDate dn, String u, String p)
    {
   	     super(n, c, u, p);
   	     this.dataDiNascita = dn;
   	     
   	     /**
   	      * L'attributo dataDiIscrizione assume il valore restituito dal metodo now() della classe LocalDate;
   	      * tale valore è costituito dalla data in cui viene effettuata tale invocazione ottenuta attraverso l'orologio di sistema
   	      */
   	     this.dataDiIscrizione = LocalDate.now();
   	     
   	     /**
   	      * L'attributo dataDiScadenza assume il valore indicato dalla data di iscrizione incrementata di un periodo di 5 anni
   	      */
   	     this.dataDiScadenza = dataDiIscrizione.plusYears(TERMINE_SCADENZA);
    }
    
    /**
     * Metodi get per il ritorno dei vari attributi della classe Fruitore
     */
    public LocalDate getDataDiNascita()
    {
   	     return dataDiNascita;
    }
   
    public LocalDate getDataDiIscrizione()
    {
   	     return dataDiIscrizione;
    }
    
    public LocalDate getDataDiScadenza()
    {
   	     return dataDiScadenza;
    }
    
    /**
     * Metodo set per la modifica della data di scadenza del servizio
     * @param nuovads : data di scadenza aggiornata
     */
    public void setDataDiScadenza(LocalDate nuovads)
    {
   	 	 dataDiScadenza = nuovads;
    }
    
    /**
     * Metodo toString() ereditato dalla classe String per la creazione di una stringa descrittiva contenente i vari attributi dell'oggetto Fruitore
     * @return la stringa descrittiva
     */
    public String toString()    //in sospeso per formattazione data
    {
      	StringBuffer ris = new StringBuffer();
      	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_DATA);
    	    
      	ris.append(String.format(DESCRIZIONE_FRUITORE, getNome(), getCognome(), dataDiNascita, getUsername(), getPassword(), dataDiIscrizione.format(formatter)));
        return ris.toString();
    }  
    
}
