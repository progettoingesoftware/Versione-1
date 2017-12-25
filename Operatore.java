package it.ing.sw;

/**
 * Questa classe rappresenta il modello di un Operatore
 */
public class Operatore 
{
	/**
	 * Gli attributi privati assegnati alla classe Operatore sono il nome, il cognome e la password
	 */
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
   	     this.nome = n;
   	     this.cognome = c;
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
   	     System.out.println(e.toString());
    }
    
}
