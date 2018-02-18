package it.ing.sw;

/**
 * Questa classe rappresenta il modello di un Operatore
 */
public class Operatore extends Utente
{
    /**
     * Metodo costruttore della classe Operatore
     * @param n : nome dell'operatore
     * @param c : cognome dell'operatore
     * @param u : username dell'operatore
     * @param p : password dell'operatore
     */
    public Operatore(String n, String c, String u, String p)
    {
   	     super(n, c, u, p);
    }
    
    /**
     * Metodo pubblico che permette la visualizzazione dell'elenco di Fruitori con relative caratteristiche
     * 
     * Pre : e != null
     * 
     * @param e : l'oggetto indicato dove e' depositato l'array di Fruitori su cui poter invocare il metodo toString()
     */
    public void visualizzaElencoFruitori(AnagraficaFruitori e)
    {
   	     System.out.println(e.toString());
    }
    
}
