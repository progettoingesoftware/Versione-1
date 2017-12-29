package it.ing.sw;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Fruitore 
{
	private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String username;
    private String password;              
    private LocalDate dataDiIscrizione;		
    private LocalDate dataDiScadenza;

    public static final String DESCRIZIONE_FRUITORE = "\nNome: %s\nCognome: %s\nData di nascita: %??\nUsername: %s\nPassword: %d\nData di iscrizione: %s";
    public static final int TERMINE_SCADENZA = 5;
    public static final String FORMATO_DATA = "dd/MM/yyyy";

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
    		assert n != "" : "Errore inserimento nome";
    	this.nome = n;
    	    assert c != "" : "Errore inserimento cognome";
    	this.cognome = c;
 	 		assert dn != null : "Errore inserimento data di nascita";
    	this.dataDiNascita = dn;
 	 		assert u != "" : "Errore inserimento username";
    	this.username = u;
    	    assert p != "" : "Errore inserimento password";
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
    		assert dataDiScadenza == dataDiIscrizione.plusYears(TERMINE_SCADENZA) : "Errore";
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
    		assert nuovads.isAfter(dataDiScadenza): "Data inserita non valida";
    	dataDiScadenza = nuovads;
    	 	assert dataDiScadenza == nuovads.plusYears(TERMINE_SCADENZA): "Operazione non completata";
    }
     
    /**
     * Metodo toString() ereditato dalla classe String per la creazione di una stringa descrittiva contenente i vari attributi dell'oggetto Fruitore
     * 
     * @return String
     */
    public String toString()
    {
    	StringBuffer ris = new StringBuffer();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_DATA);
    	    
    	ris.append(String.format(DESCRIZIONE_FRUITORE, nome, cognome, dataDiNascita, username, password, dataDiIscrizione.format(formatter)));
        return ris.toString();
    }
    
}
