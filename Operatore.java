package it.ing.sw;

public class Operatore 
{
	private String nome;
    private String cognome;
    private String password;
    
    /**
     * Metodo costruttore della classe Operatore
     * 
     * @param n : nome dell'operatore
     * @param c : cognome dell'operatore
     * @param p : password dell'operatore
     */
    
    public Operatore(String n, String c, String p)
    {
    		assert n != "" : "Errore inserimento nome";
   		this.nome = n;
   	     	assert c != "" : "Errore inserimento cognome";
   	    this.cognome = c;
   	        assert p != "" : "Errore inserimento password";
   	    this.password = p;
    }
    
    /**
     * Metodo pubblico che permette la visualizzazione dell'elenco di Fruitori con relative caratteristiche
     * 
     * @param e : l'oggetto indicato dove è depositato l'array di Fruitori su cui poter invocare il metodo toString()
     * 
     * @return void
     */
    public void visualizzaElencoFruitori(AnagraficaFruitori e)
    {
    		assert (e != null) : "Errore";
    	System.out.println(e.toString());
    }
    
}
