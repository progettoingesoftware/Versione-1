package it.ing.sw;

public class Menu 
{
    public static final String SALUTO_INIZIALE = "Benvenuto nell'applicazione per la gestione di risorse multimediali\n";
    public static final String SALUTO_FINALE = "Arrivederci, alla prossima!\n";
    
    public static final String ISCRIZIONE_AVVENUTA = "Complimenti, iscrizione avvenuta con successo!\n";

    public static final String SCELTA_MODALITA = "In quale modalit� vuoi accedere?\n";
    public static final String SCELTA_AZIONE = "Cosa vuoi fare?\n";
    public static final String INSERIMENTO_NOME = "Inserisci il tuo nome\n";
    public static final String INSERIMENTO_CREDENZIALI = "Inserisci il tuo nome\n";
    	
    public static void mostraSalutoIniziale()
    {
	     System.out.println(SALUTO_INIZIALE);
    }
    
    public static void mostraSalutoFinale()
    {
	     System.out.println(SALUTO_FINALE);
    }
    
    public static void mostraMessaggioIscrizioneAvvenuta()
    {
	     System.out.println(ISCRIZIONE_AVVENUTA);
    }
    
    public static String mostraMenuB()
    {
    	 return (SCELTA_MODALITA + "1 - Fruitore\n" + "2 - Operatore\n" + "3 - Esci\n");
    }
    
    public static int eseguiMenuB()
    {	 
    	 int comando = InputDati.leggiIntero(mostraMenuB(), 1, 3);
    	 
    	 return comando;
    }
    
    public static void selettoreMenuB(int scelta)
    {
    	switch(scelta)
   	 	{
   	 		case 1: mostraMenuC();
   	 				break;
   	 		case 2: //da definire (mostra menuSceltaAzioneOperatore
   	 	
   	 		case 3: mostraSalutoFinale();
   	 				break;
   	 	}
    	
    }
    
    public static String mostraMenuC()
    {
    	return (SCELTA_AZIONE + "1 - Iscriviti come nuovo Fruitore\n" + "2 - Accedi se sei gi� iscritto\n" + "3 - Ritorna al men� precedente\n");
    }
    
    public static int eseguiMenuC()
    {	 
    	 int comando = InputDati.leggiIntero(mostraMenuSceltaAzioneFruitore(), 1, 3);
    	 
    	 return comando;
    	 
    	 /*switch(comando)
    	 {
    	 	case 1: mostraMenuSceltaAzione();///////////
    	 			break;
    	 	case 2: //da definire
    	 	
    	 	case 3: mostraSalutoFinale();
    	 			break;   // termina l'esecuzione del programma
    	 }*/
    	 
    }
    
    public static void selettoreMenuC(int scelta, AnagraficaFruitori af)
    {
   	 		switch(scelta)
   	 		{
   	 			case 1: Fruitore nuovo = iscrizione();
   	 					af.aggiungiFruitore(nuovo);
   	 					mostraMessaggioIscrizioneAvvenuta();
   	 					eseguiMenuB();
   	 					break;
   	 			case 2: 
   	 	
   	 			case 3: eseguiMenuB();
   	 					break;   // termina l'esecuzione del programma
   	 		}
    }
    
    public static Fruitore iscrizione()
    {
    		String nome = InputDati.leggiStringaNonVuota(INSERIMENTO_NOME);
    		
    		
    		
    		return new Fruitore(nome,  )
    }
    
    public static String mostraMenuD()
    {
    	return ("1 - Effettua il login\n" + "2 - Ritorna al men� precedente\n");
    }
    
    public static int eseguiMenuD()
    {	 
    	 int comando = InputDati.leggiIntero(mostraMenuD(), 1, 2);
    	 
    	 return comando;
    	 
    	 /*switch(comando)
    	 {
    	 	case 1: mostraMenuSceltaAzione();///////////
    	 			break;
    	 	case 2: //da definire
    	 	
    	 	case 3: mostraSalutoFinale();
    	 			break;   // termina l'esecuzione del programma
    	 }*/
    	 
    }
    
    public static void selettoreMenuD(int scelta, AnagraficaFruitori af)
    {
   	 		switch(scelta)
   	 		{
   	 			case 1: String nome = InputDati.leggiStringaNonVuota(INSERIMENTO_USERNAME);
   	 					String password = InputDati.leggiStringaNonVuota(INSERIMENTO_PASSWORD);
   	 					af.accedi(nome, password);
   	 					mostraMessaggioAccessoAvvenuto();
   	 					break;
   	 					
   	 			case 2: eseguiMenuC();
   	 					break;   // termina l'esecuzione del programma
   	 		}
   	 		
    }
    

    
}
