package it.ing.sw;

import java.time.LocalDate;

public class Fruitore 
{
	 private String nome;
     private String cognome;
     private LocalDate dataDiNascita;
     private String username;
     private String password;              
     private LocalDate dataDiIscrizione;		
     private LocalDate dataDiScadenza;
     
     public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nData di nascita: %??\nUsername: %s\nPassword: %d\nData di iscrizione: %??";
 	 public static final int TERMINE_SCADENZA = 5;
     
     
     public Fruitore(String n, String c, LocalDate dn, String u, String p)
     {
    	     this.nome = n;
    	     this.cognome = c;
    	     this.dataDiNascita = dn;
    	     this.username = u;
    	     this.password = p;
    	     this.dataDiIscrizione = LocalDate.now();
    	     this.dataDiScadenza = dataDiIscrizione.plusYears(TERMINE_SCADENZA);
     }
     
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
     
     public void setDataDiScadenza(LocalDate nuovads)
     {
    	 	 dataDiScadenza = nuovads;
     }
     
     public String toString()
     {
    	    StringBuffer ris = new StringBuffer();
    	    ris.append(String.format( DESCRIZIONE_FRUITORE, nome, cognome, dataDiNascita, username, password, dataDiIscrizione));
    	    return ris.toString();
     }
    
}
