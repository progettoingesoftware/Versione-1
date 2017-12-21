package it.ing.sw;

import java.time.*;

public class Fruitore 
{
     private String nome;
     private String cognome;
     private LocalDate dataDiNascita;
     private String username;
     private String password;              //la password la gestiamo come int... va bene?
     private LocalDate dataDiIscrizione;		//gestione date come oggetti LocalDate
     private LocalDate dataDiScadenza;
     
     public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nData di nascita: %??\nUsername: %s\nPassword: %d\nData di iscrizione: %??";
 	 public static final int TERMINE_SCADENZA = 5;
     
     /*  Bisogna controllare che il cittadino che vuole diventare fruitore sia maggiorenne; direi di farlo nel main
      *  o in una classe di utilità, al momento dell'input. Quando l'utente inserisce la sua data di nascita, la confrontiamo 
      *  con la data acquisita dal sistema e facciamo il controllo.
      */
     
     public Fruitore(String nome, String cognome, LocalDate dataDiNascita, String username, String password)
     {
    	     this.nome = nome;
    	     this.cognome = cognome;
    	     this.dataDiNascita = dataDiNascita;
    	     this.username = username;
    	     this.password = password;
    	     this.dataDiIscrizione = LocalDate.now();
    	     this.dataDiScadenza = dataDiIscrizione.plusYears(TERMINE_SCADENZA);
     }
     
     public String getUsername()
     {
    	     return username;
     }
     
     public LocalDate getDataDiIscrizione()
     {
    	     return dataDiIscrizione;
     }
     
     public LocalDate getDataDiScadenza()
     {
    	     return dataDiScadenza;
     }
     
     public void setDataDiScadenza(LocalDate nuovaDataDiScadenza)
     {
    	 	 dataDiScadenza = nuovaDataDiScadenza;
     }
     
     
     
     /*
      * Ritorna una stringa con la descrizione del fruitore. Va bene stampare tutti gli attributi del fruitore
      * oppure sarebbe meglio selezionarne solo alcuni come nome, cognome e username?
      * 
      */
     public String toString()
     {
    	    StringBuffer ris = new StringBuffer();
    	    ris.append(String.format( DESCRIZIONE_FRUITORE, nome, cognome, dataDiNascita, username, password, dataDiIscrizione));
    	    return ris.toString();
     }
     
     
     
     
}
