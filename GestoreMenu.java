package it.ing.sw;

public class GestoreMenu 
{
	public static final String SALUTO_INIZIALE = "Benvenuto nell'applicazione per la gestione di risorse multimediali\n";
    public static final String SALUTO_FINALE = "Arrivederci, alla prossima!\n";
    public static final String INTESTAZIONE_A = "IN QUALE MODALITA VUOI ACCEDERE?";
	public static final String [] OPZIONI_A = {"Fruitore", "Operatore"};
	public static final String INTESTAZIONE_B = "SCEGLI UN'OPZIONE";
	public static final String [] OPZIONI_B = {"Iscriviti come nuovo fruitore", "Accedi", "Indietro"};
	public static final String INTESTAZIONE_C = "ACCESSO";
	public static final String [] OPZIONI_C = {"Inserisci username e password", "Indietro"};
	public static final String INTESTAZIONE_D= "	COSA DESIDERI FARE?";
	public static final String [] OPZIONI_D = {"Rinnova iscrizione", "Visualizza profilo", "Logout"};
	public static final String INTESTAZIONE_E = "COSA DESIDERI FARE?";
	public static final String [] OPZIONI_E = {"Visualizzare anagrafica fruitori", "Indietro"};
	
    public static final String ISCRIZIONE_AVVENUTA = "Complimenti, iscrizione avvenuta con successo!\n";
    public static final String INS_NOME = "Inserisci il tuo nome\n";
    public static final String INS_COGNOME = "Inserisci il tuo cognome\n";
    public static final String RINNOVO_OK = "Il rinnovo dell'iscrizione è avvenuto con successo";
    public static final String RINNOVO_NON_OK = "Non è possibile effettuare il rinnovo dell'iscrizione";
    
    public static final String USERNAME = "Username: ";
	public static final String PASSWORD = "Password: ";
	public static final String CREDENZIALI_ERRATE = "ATTENZIONE! Lo username e/o la password non sono validi. Riprova";
    
    
    public Fruitore accesso(AnagraficaFruitori af)
	{
		String use = "";
		String pwd = "";
		boolean end = false;
		Fruitore f = null;
		
	    do
	    {
			use = InputDati.leggiStringaNonVuota(USERNAME);
			pwd = InputDati.leggiStringaNonVuota(PASSWORD);
				
			if(af.accedi(use, pwd))
			{
				 f = af.getFruitore(use, pwd);
				 end = true;
			}
			else
				System.out.println(CREDENZIALI_ERRATE);
				
		}while(!end);
		
	   return f;
	}
    
    
    
    public void logicaMenu(AnagraficaFruitori af)
    {
  	   Menu a = new Menu(INTESTAZIONE_A, OPZIONI_A);
	   Menu b = new Menu(INTESTAZIONE_B, OPZIONI_B);
	   Menu c = new Menu(INTESTAZIONE_C, OPZIONI_C);
	   Menu d = new Menu(INTESTAZIONE_D, OPZIONI_D);
	   Menu e = new Menu(INTESTAZIONE_E, OPZIONI_E);
    	
    	   boolean esci = false;
    	   char letteraMenu =  'a';
       int scelta = 0;
       Fruitore attualef = null;
       
       System.out.println(SALUTO_INIZIALE);
          
       do
       {
    	      switch(letteraMenu)
    	      {
    	          case('a'):
    	          {
    	        	  
    	          }
    	          
    	          case('b'):
    	          {
    	        	  
    	          }
    	          
    	          case('c'):
    	          {
    	        	     scelta = c.scegli();
    	        	     
    	        	     switch(scelta)
    	        	     {
    	        	        case 1: attualef = accesso(af);
    	        	                letteraMenu = 'd';
      	                    break;
      	        	
      	            case 2: letteraMenu = 'b';
      	                    break;
    	        	     }
    	          }
    	          
    	          case('d'):
    	          {
    	        	     scelta = c.scegli();
 	        	     
 	        	     switch(scelta)
 	        	     {
 	        	        case 1: if(af.rinnovoIscrizioneFruitore(attualef.getUsername()))
 	        	                    System.out.println(RINNOVO_OK);
 	        	                else
 	        	                  	System.out.println(RINNOVO_NON_OK);
 	        	                break;
 	        	                
 	        	        case 2: attualef.toString();
 	        	                break;
 	        	        	
 	        	        case 3: letteraMenu = 'a';
 	        	                break;
 	        	     }
    	          }
    	          
    	          case('e'):
    	          {
    	        	     scelta = c.scegli();
 	        	     
 	        	     switch(scelta)
 	        	     {
 	        	        case 1: 
 	        	     }
    	          }
    	      }
    	      
       }while(!esci);   
       
       System.out.println(SALUTO_FINALE);       
    }
     
}
