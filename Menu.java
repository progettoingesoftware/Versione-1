package it.ing.sw;

public class Menu 
{
    public static final String SALUTO_INIZIALE = "Benvenuto nell'applicazione per la gestione di risorse multimediali\n";
    public static final String SALUTO_FINALE = "Arrivederci, alla prossima!\n";

    public static final String SCELTA_MODALITA = "In quale modalità vuoi accedere?\n";
    public static final String SCELTA_AZIONE = "Cosa vuoi fare?\n";
    	
    public static void mostraSalutoIniziale()
    {
	     System.out.println(SALUTO_INIZIALE);
    }
    
    public static void mostraSalutoFinale()
    {
	     System.out.println(SALUTO_FINALE);
    }
    
    public static String mostraMenuSceltaModalita()
    {
    	 return (SCELTA_MODALITA + "1 - Fruitore\n" + "2 - Operatore\n" + "3 - Esci\n");
	   /*  System.out.println(SCELTA_MODALITA);
	     System.out.println("1 - Fruitore");
	     System.out.println("2 - Operatore");
	     System.out.println("3 - Esci"); */
    }
    
    public static void eseguiMenuSceltaModalita()
    {	 
    	 int comando = InputDati.leggiIntero(mostraMenuSceltaModalita(), 1, 3);
    	 
    	 switch(comando)
    	 {
    	 	case 1: mostraMenuSceltaAzione();
    	 			break;
    	 	case 2: //da definire
    	 	
    	 	case 3: mostraSalutoFinale();
    	 			break;   // termina l'esecuzione del programma
    	 }
    	 
    }
    
    public static String mostraMenuSceltaAzione()
    {
    		return (SCELTA_AZIONE + "1 - Iscriviti come nuovo Fruitore\n" + "2 - Accedi se sei già iscritto\n" + "3 - Ritorna al menù precedente\n");
    }
    
    public static void eseguiMenuSceltaAzione()
    {	 
    	 int comando = InputDati.leggiIntero(mostraMenuSceltaAzione(), 1, 3);
    	 
    	 switch(comando)
    	 {
    	 	case 1: mostraMenuSceltaAzione();///////////
    	 			break;
    	 	case 2: //da definire
    	 	
    	 	case 3: mostraSalutoFinale();
    	 			break;   // termina l'esecuzione del programma
    	 }
    	 
    }
}
