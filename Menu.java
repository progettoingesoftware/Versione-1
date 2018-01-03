package it.ing.sw;

/**
 * Questa classe rappresenta il modello di un Menù
 */
public class Menu 
{
	   public static final String CORNICE = "*************************************************************";
	   public static final String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata: ";
	   public static final String VOCE_USCITA = "0 - Esci";
	   
	   private String titolo;
	   private String [] voci;
	   
	   /**
	    * Metodo costruttore della classe menù
	    * @param titolo : titolo del menù
	    * @param voci : voci del menù
	    */
	   public Menu(String titolo, String [] voci)
	   {
		   this.titolo  = titolo;
		   this.voci = voci;
	   }
	   
	   /**
	    * Richiama il metodo stampa() per la visualizzazione del menù e prende in input l'opzione digitata dall'utente.
	    * @return il numero corrispondente all'opzione digitata dall'utente
	    */
	   public int scegli()
	   {
		   stampa();
		   int opzione = InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);
		   
		   return opzione;
	   }
	   
	   /**
	    * Mostra a video il menù.
	    */
	   public void stampa()
	   {
		   System.out.println(CORNICE);
		   System.out.println(titolo);
		   System.out.println(CORNICE);
		   
		   for(int i = 0; i < voci.length; i++)
		   {
			   System.out.println( (i+1) + "-" + voci[i]);
		   }
		   
		   System.out.println(VOCE_USCITA);
		   System.out.println();
	   }
	   
}
