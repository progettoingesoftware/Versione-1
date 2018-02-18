package it.ing.sw;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Questa classe permette una corretta gestione dell'uso dei menu'. E' essenzialmente suddivisa in tre parti:
 * 1 - Elenco delle costanti che costituiscono le intestazioni dei menu' e le varie opzioni che li compongono
 * 2 - Metodi ausiliari per la gestione delle funzionalita' basilari del software (iscrizione, accesso)
 * 3 - Metodo logicaMenu per la realizzazione delle connessioni tra i vari menu'
 */
public class GestoreMenu 
{
	public static final String SALUTO_INIZIALE = "Benvenuto nell'applicazione per la gestione di risorse multimediali\n";
    public static final String SALUTO_FINALE = "Arrivederci, alla prossima!\n";
    public static final String INTESTAZIONE_A = "IN QUALE MODALITA VUOI ACCEDERE?";
	public static final String [] OPZIONI_A = {"Fruitore", "Operatore", "Esci"};
	public static final String INTESTAZIONE_B = "SCEGLI UN'OPZIONE";
	public static final String [] OPZIONI_B = {"Iscriviti come nuovo fruitore", "Accedi", "Indietro"};
	public static final String INTESTAZIONE_C = "ACCESSO FRUITORE";
	public static final String [] OPZIONI_C = {"Inserisci username e password", "Indietro"};
	public static final String INTESTAZIONE_D= "COSA DESIDERI FARE?";
	public static final String [] OPZIONI_D = {"Rinnova iscrizione", "Visualizza profilo", "Logout"};
	public static final String INTESTAZIONE_E = "ACCESSO OPERATORE";
	public static final String [] OPZIONI_E = {"Inserisci username e password", "Indietro"};
	public static final String INTESTAZIONE_F = "COSA DESIDERI FARE?";
	public static final String [] OPZIONI_F = {"Visualizza anagrafica fruitori", "Indietro"};
	
    public static final String INS_NOME = "Inserisci il tuo nome\n";
    public static final String INS_COGNOME = "Inserisci il tuo cognome\n";
    public static final String INS_USERNAME = "Inserisci il tuo username\n";
    public static final String INS_PASSWORD = "Inserisci la tua password\n";
    public static final String INS_GIORNO_NASCITA = "Inserisci il tuo giorno di nascita\n";
    public static final String INS_MESE_NASCITA = "Inserisci il tuo mese di nascita\n";
    public static final String INS_ANNO_NASCITA = "Inserisci il tuo anno di nascita\n";

    public static final String ISCRIZIONE_OK = "Complimenti, iscrizione avvenuta con successo!\n";
    public static final String ISCRIZIONE_NON_OK = "ATTENZIONE! Le credenziali inserite non sono valide poiche' gia' in uso\n";

    public static final String RINNOVO_OK = "Il rinnovo dell'iscrizione e' avvenuto con successo";
    public static final String RINNOVO_NON_OK = "Non e' possibile effettuare il rinnovo dell'iscrizione";
    
    public static final String USERNAME = "Username: ";
	public static final String PASSWORD = "Password: ";
	public static final String CREDENZIALI_ERRATE = "ATTENZIONE! Lo username e/o la password non sono validi. Riprova";
	public static final String DATA_DI_NASCITA_ERRATA = "ATTENZIONE! La data di nascita inserita non e' valida. Riprova";
	
	/**
	 * Metodo per l'aggiunta di un nuovo fruitore all'elenco dei fruitori gia' presenti all'interno di af.
	 * Vengono effettuati dei controlli sulla correttezza della data di nascita inserita e sulla possibile presenza di fruitori gia' iscritti in possesso delle medesime credenziali indicate
	 * @param af : oggetto di tipo AnagraficaFruitori contenente l'elenco dei fruitori presenti ed i metodi per l'esecuzione dei vari controlli
	 */
	public void iscrizione(AnagraficaFruitori af)
	{
		String nome = "";
		String cognome = "";
		String use = "";
		String pwd = "";
		int giorno = 0;
		int mese = 0;
		int anno = 0;
		boolean end = false;
		
	    do
	    {
			nome = InputDati.leggiStringaNonVuota(INS_NOME);
			cognome = InputDati.leggiStringaNonVuota(INS_COGNOME);
			use = InputDati.leggiStringaNonVuota(INS_USERNAME);
			pwd = InputDati.leggiStringaNonVuota(INS_PASSWORD);
			giorno = 0;
			mese = 0;
			anno = 0;
			Fruitore f = null;
			
			boolean exc = false;
			
			do {
				
				exc = false;
				
				try 
				{
					giorno = InputDati.leggiIntero(INS_GIORNO_NASCITA);
					mese = InputDati.leggiIntero(INS_MESE_NASCITA);
					anno = InputDati.leggiIntero(INS_ANNO_NASCITA);
					f = new Fruitore(nome, cognome, anno, mese, giorno, use, pwd);
				}
				catch(DateTimeException e)
				{
					System.out.println(DATA_DI_NASCITA_ERRATA);
					exc = true;
				}
				
			}while(exc);
			
			if(af.verificaOmonimiaFruitori(f.getNome(), f.getCognome(), f.getDataDiNascita()) == true || af.verificaStessoUsername(f.getUsername()) == true)
			{
				System.out.println(ISCRIZIONE_NON_OK);
			}
			else
			{
				af.aggiungiFruitore(f);
				end = true;
				System.out.println(ISCRIZIONE_OK);
			}
	
		}while(!end);
	    
	}
	
	/**
	 * Metodo per l'accesso di un utente al sistema.
	 * Vengono effettuati dei controlli sulla correttezza dello username e della password indicati
	 * @param ag : oggetto di tipo Anagrafica contenente l'elenco degli utenti presenti ed il metodo per l'accesso
	 * @return l'utente specificato dalle credenziali indicate //////////// e se null????
	 */
    public Utente accesso(Anagrafica ag)
    {
		String use = "";
		String pwd = "";
		boolean end = false;
		Utente ut = null;
		
	    do
	    {
			use = InputDati.leggiStringaNonVuota(USERNAME);
			pwd = InputDati.leggiStringaNonVuota(PASSWORD);
				
			if(ag.accedi(use, pwd))
			{
				 ut = ag.getUtente(use, pwd);
				 end = true;
			}
			else
			{
				 System.out.println(CREDENZIALI_ERRATE);
			}
	
		}while(!end);
		
	    return ut;
	}
    
    /**
     * Vengono inizialmente creati i vari menu' con le relative intestazioni ed opzioni. 
     * In seguito l'andamento del programma è scandito attraverso l'aggiornamento della variabile letteraMenu e l'uso di switch-case innestati,
     * in cui il primo livello (contraddistinto dalle variabili letterali) indica gli specifici menu', mentre il secondo livello (evidenziato
     * dall'uso della variabile intera 'scelta') indica le opzioni relative ad ogni menu' e le operazioni che vengono indi svolte
     * @param af : oggetto di tipo AnagraficaFruitori
     * @param ao : oggetto di tipo AnagraficaOperatori
     */
    public void logicaMenu(AnagraficaFruitori af, AnagraficaOperatori ao)
    {
    	Menu a = new Menu(INTESTAZIONE_A, OPZIONI_A);
	    Menu b = new Menu(INTESTAZIONE_B, OPZIONI_B);
	    Menu c = new Menu(INTESTAZIONE_C, OPZIONI_C);
	    Menu d = new Menu(INTESTAZIONE_D, OPZIONI_D);
	    Menu e = new Menu(INTESTAZIONE_E, OPZIONI_E);
	    Menu f = new Menu(INTESTAZIONE_F, OPZIONI_F);
    	
    	boolean esci = false;
    	char letteraMenu =  'a';
        int scelta = 0;
        
        Fruitore attualef = null;
        Operatore attualeop = null;
       
        System.out.println(SALUTO_INIZIALE);
          
        do
        {
        	switch(letteraMenu)
    	    {
    	    	case('a'):
    	        {
    	    		scelta = a.scegli();
	        	     
    	    		switch(scelta)
	        	    {
	        	    	case 1: letteraMenu = 'b';
	        	                break;
  	        	
	        	        case 2: letteraMenu = 'e';
  	                    		break;
  	                    		
	        	        case 3: esci = true;
	        	        		break;
	        	    }
    	    		
    	        }
    	          
    	        case('b'):
    	        {
    	        	scelta = b.scegli();
	        	     
	        	    switch(scelta)
	        	    {
	        	    	case 1: iscrizione(af);
	        	                letteraMenu = 'a';
	        	                break;
  	        	
	        	        case 2: letteraMenu = 'd';
  	                    		break;
	        	    }
	        	    
    	        }
    	          
    	        case('c'):
    	        {
    	        	scelta = c.scegli();
    	        	     
    	        	switch(scelta)
    	        	{
    	        		case 1: attualef = (Fruitore) accesso(af);
    	        	            letteraMenu = 'd';
    	        	            break;
      	        	
    	        	    case 2: letteraMenu = 'b';
      	                    	break;
    	        	}
    	        	
    	        }
    	          
    	        case('d'):
    	        {
    	        	scelta = d.scegli();
 	        	     
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
    	        	scelta = e.scegli();
 	        	     
 	        	    switch(scelta)
 	        	    {
 	        	    	case 1: attualeop = (Operatore) accesso(ao);
 	        	                letteraMenu = 'f';
 	        	                break;
 	        	                
 	        	        case 2: letteraMenu = 'a';
 	        	                break;
 	        	    }
 	        	    
    	        }
    	        
    	        case('f'):
    	        {
    	        	 scelta = f.scegli();
 	        	     
 	        	     switch(scelta)
 	        	     {
 	        	     	case 1: attualeop.visualizzaElencoFruitori(af);
 	        	                break;
 	        	                
 	        	        case 2: letteraMenu = 'a';
 	        	                break;
 	        	     }
 	        	     
    	        }
    	        
    	    }
    	      
       }while(!esci);   
       
       System.out.println(SALUTO_FINALE);       
    }
     
}
