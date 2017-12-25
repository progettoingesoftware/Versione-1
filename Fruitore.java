package it.ing.sw;

/**
 * Importazione della classe necessaria per la gestione delle date
 */
import java.time.LocalDate;

/**
 * Questa classe rappresenta il modello di un Fruitore
 */
public class Fruitore 
{
	 /**
	  * Gli attributi privati assegnati alla classe Fruitore sono il nome, il cognome, lo username e la password.
	  * Vengono inoltre definite la data di nascita, quella relativa al momento in cui viene effettuata l'iscrizione e quella che indica la scadenza del servizio;
	  * tali date sono gestite attraverso l'uso della classe LocalDate
	  */
	 private String nome;
     private String cognome;
     private LocalDate dataDiNascita;
     private String username;
     private String password;              
     private LocalDate dataDiIscrizione;		
     private LocalDate dataDiScadenza;
     
     /**
      * Costante stringa identificativa del fruitore
      */
     public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nData di nascita: %??\nUsername: %s\nPassword: %d\nData di iscrizione: %??";
 	 
     /**
      * Costante numerica intera che specifica il periodo di validità del servizio
      */
     public static final int TERMINE_SCADENZA = 5;
     
     /**
      * Metodo costruttore della classe Fruitore
      * 
      * @param n : nome del fruitore
      * @param c : cognome del fruitore
      * @param dn : data di nascita del fruitore
      * @param u : username del fruitore
      * @param p : password del fruitore
      */     
     public Fruitore(String n, String c, LocalDate dn, String u, String p)
     {
    	     this.nome = n;
    	     this.cognome = c;
    	     this.dataDiNascita = dn;
    	     this.username = u;
    	     this.password = p;
    	     
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
     public String getNome()
     {
    	     return nome;
     }
     
     public String getCognome()
     {
    	     return cognome;
     }
     
     public LocalDate getDataDiNascita()
     {
    	     return dataDiNascita;
     }
     
     public String getUsername()
     {
    	     return username;
     }
     
     public String getPassword()
     {
    	     return password;
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
      * 
      * @param nuovads : data di scadenza aggiornata
      * 
      * @return void
      */
     public void setDataDiScadenza(LocalDate nuovads)
     {
    	 	 dataDiScadenza = nuovads;
     }
     
     /**
      * Metodo toString() ereditato dalla classe String per la creazione di una stringa descrittiva contenente i vari attributi dell'oggetto Fruitore
      * 
      * @return String
      */
     public String toString()
     {
    	    StringBuffer ris = new StringBuffer();
    	    ris.append(String.format( DESCRIZIONE_FRUITORE, nome, cognome, dataDiNascita, username, password, dataDiIscrizione));
    	    return ris.toString();
     }
    
}
