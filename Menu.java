package it.ing.unibs.fp.mylib;

public class Menu 
{
	   public static final String CORNICE = "*************************************************************";
	   public static final String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata: ";
	   public static final String VOCE_USCITA = "0 - Esci";
	   
	   private String titolo;
	   private String [] voci;
	   
	   
	   public Menu(String titolo, String [] voci)
	   {
		   this.titolo  = titolo;
		   this.voci = voci;
	   }
	   
	  
	   public int scegli()
	   {
		   stampa();
		   int opzione = InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);
		   
		   return opzione;
	   }
	   
	  
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
		   System.out.println();;
		   
	   }
}
