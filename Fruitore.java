package it.ing.sw;

public class Fruitore 
{
     private String nome;
     private String cognome;
     private ?? dataDiNascita;
     private String username;
     private int password;
     private ?? dataDiIscrizione;
     
     public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nData di nascita: %??\nUsername: %s\nPassword: %d\nData di iscrizione: %??";
     
     /*  Bisogna controllare che il cittadino che vuole diventare fruitore sia maggiorenne; direi di farlo nel main
      *  o in una classe di utilità, al momento dell'input. Quando l'utente inserisce la sua data di nascita, la confrontiamo 
      *  con la data acquisita dal sistema e verifichiamo che la differenza tra le 2 sia >= di 18; se si proseguiamo, altrimenti
      *  gli diaciamo che non può diventare fruitore.
      */
     
     public Fruitore(String nome, String cognome, ?? dataDiNascita, String username, int password, ?? dataDiIscrizione)
     {
    	     this.nome = nome;
    	     this.cognome = cognome;
    	     this.dataDiNascita = dataDiNascita;
    	     this.username = username;
    	     this.password = password;
    	     this.dataDiIscrizione = dataDiIscrizione;
     }
     
     public String getUsername()
     {
    	     return username;
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
