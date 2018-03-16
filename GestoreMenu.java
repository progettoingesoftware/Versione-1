package interazione_1;

import java.io.Serializable;
import java.time.*;

import logica_1.*;
import utility.*;

/**
 * Questa classe permette una corretta gestione dell'uso dei menu'. E' essenzialmente suddivisa in due parti:
 * 1 - Metodi ausiliari per la gestione delle funzionalita' basilari del software (iscrizione, accesso)
 * 2 - Metodo logicaMenu per la realizzazione delle connessioni tra i vari menu'
 */
public class GestoreMenu implements Serializable 
{
	private static final long serialVersionUID = 1L;

    /**
	 * Metodo di interazione con l'utente per l'aggiunta di un nuovo fruitore all'elenco dei fruitori gia' presenti all'interno di af.
	 * Vengono effettuati dei controlli sulla correttezza della data di nascita inserita e sulla possibile presenza di fruitori gia' iscritti in possesso delle medesime credenziali indicate
	 * 
	 * Pre : af != null
	 * Pre : af.elenco != null
	 * 
	 * @param af : oggetto di tipo AnagraficaFruitori contenente l'elenco dei fruitori presenti ed i metodi per l'esecuzione dei vari controlli
	 */
	public void iscrizione(AnagraficaFruitori af)
	{
		String nome = "";
		String cognome = "";
		String use = "";
		String pwd = "";
		int giorno = Costanti.VUOTO;
		int mese = Costanti.VUOTO;
		int anno = Costanti.VUOTO;

		boolean end = true;
		
		boolean ins_nome = true;
		boolean ins_cognome = true;
		boolean ins_use = true;
		boolean ins_pwd = true;
		boolean ins_data = true;
		
		/**
		 * Ciclo globale per l'inserimento di un nuovo fruitore nel sistema in accordo con le condizioni indicate.
		 * E' possibile suddividere tale ciclo in 4 parti:
		 * 1 - Inserimento dei parametri richiesti
		 * 2 - Controllo sulla correttezza lessicale della data di nascita inserita
		 * 3 - Controlli sulle condizioni necessarie per l'iscrizione
		 * 4 - Completamento iscrizione o richiesta di perfezionamento della stessa
		 */
	    do
	    {
	    	/**
	    	 * Inserimento parametri
	    	 */
	    	if(ins_nome)
	    	{
				nome = InputDati.leggiStringaNonVuota(Costanti.INS_NOME);
	    	}
	    	
	    	if(ins_cognome)
	    	{
				cognome = InputDati.leggiStringaNonVuota(Costanti.INS_COGNOME);
	    	}
	    	
	    	if(ins_use)
	    	{
				use = InputDati.leggiStringaNonVuota(Costanti.INS_USERNAME);
	    	}
	    	
	    	if(ins_pwd)
	    	{
				pwd = InputDati.leggiStringaNonVuota(Costanti.INS_PASSWORD);
	    	}
	    	
			Fruitore f = null;	
			boolean exc = false;			
			end = true;
			
			/**
			 * Il controllo per la correttezza della data di nascita inserita viene gestito autonomamente dalla classe LocalDate.
			 * Nel caso in cui quest'ultima generi un'eccezione, e dunque la data inserita non sia lessicalmente corretta, viene modificata un'opportuna
			 * variabile booleana che impedisce la fuoriuscita dal ciclo do-while fintanto che non viene digitata una data valida
			 */
			while(!exc) 
			{
			
				try 
				{
					if(ins_data)
					{
						giorno = InputDati.leggiIntero(Costanti.INS_GIORNO_NASCITA);
						mese = InputDati.leggiIntero(Costanti.INS_MESE_NASCITA);
						anno = InputDati.leggiIntero(Costanti.INS_ANNO_NASCITA);
					}
					
					f = new Fruitore(nome, cognome, anno, mese, giorno, use, pwd);
					
					exc = true;
				}
				catch(DateTimeException e)
				{
					System.out.println(Costanti.DATA_DI_NASCITA_ERRATA);
				}
				
			};
			
			ins_nome = false;
			ins_cognome = false;
			ins_use = false;
			ins_pwd = false;
			ins_data = false;

			/**
			 * I metodi di controllo verificano se non vi sono casi di omonimia tra diversi fruitori, se non vi sono casi di condivisione di username
			 * e se l'utente e' maggiorenne. In caso di inesattezze vengono reimpostati i parametri di inserimento e viene impedita la fuoriuscita dal ciclo globale
			 */
			if(af.verificaOmonimiaFruitori(f.getNome(), f.getCognome(), f.getDataDiNascita()) == true)
			{
				System.out.println(Costanti.ISCRIZIONE_NON_OK_OMONIMIA_FRUITORI);
				ins_nome = true;
				ins_cognome = true;
				ins_data = true;
				end = false;
			}
			
			if(af.verificaStessoUsername(f.getUsername()) == true)
			{
				System.out.println(Costanti.ISCRIZIONE_NON_OK_STESSO_USERNAME);
				ins_use = true;
				end = false;
			}
			
			if(Period.between(f.getDataDiNascita(), LocalDate.now()).getYears() < Costanti.MAGGIORE_ETA)
			{
				System.out.println(Costanti.ISCRIZIONE_NON_OK_MAGGIORE_ETA);
				ins_nome = true;
				ins_cognome = true;
				ins_data = true;
				end = false;
			}
			
			/**
			 * Se non sono stati segnalati errori, l'iscrizione si conclude con successo.
			 * Altrimenti, a meno che l'utente non esprima la volonta' di terminare l'operazione, si procede con le modifiche necessarie sui dati inseriti
			 */
			if(end)
			{
				af.aggiungiFruitore(f);
				System.out.println(Costanti.ISCRIZIONE_OK);
			}
			else
			{
	
				if(InputDati.leggiUpperChar(Costanti.RICHIESTA_PROSECUZIONE, "SN") == 'N')
				{
					end = true;				
					System.out.println(Costanti.ISCRIZIONE_NON_OK);
				}
				
			}
			
		}while(!end);
	    
	}

	/**
	 * Metodo di interazione con l'utente per l'accesso al sistema.
	 * Vengono effettuati dei controlli sulla correttezza dello username e della password indicati
	 * 
	 * Pre : ag != null
	 * Pre : ag.elenco != null
	 * 
	 * @param ag : oggetto di tipo Anagrafica contenente l'elenco degli utenti presenti ed il metodo per l'accesso
	 * @return l'utente specificato dalle credenziali indicate
	 */
    public Utente accesso(Anagrafica ag)
    {
		String use = "";
		String pwd = "";
		boolean end = false;
		Utente ut = null;
		
	    do
	    {
			use = InputDati.leggiStringaNonVuota(Costanti.USERNAME);
			pwd = InputDati.leggiStringaNonVuota(Costanti.PASSWORD);

			/**
			 * Se viene effettivamente reperito l'utente indicato, l'accesso si conclude con successo.
			 * Altrimenti, a meno che l'utente non esprima la volonta' di terminare l'operazione, si procede con le modifiche necessarie sui dati inseriti
			 */
			if(ag.accedi(use, pwd))
			{
				ut = ag.getUtente(use, pwd);
				end = true;
			}
			else
			{
				System.out.println(Costanti.CREDENZIALI_ERRATE);
				 
				if(InputDati.leggiUpperChar(Costanti.RICHIESTA_PROSECUZIONE, "SN") == 'N')
				{
					end = true;
				}
					
			}
	
		}while(!end);
		
	    return ut;
	}

    /**
     * Vengono inizialmente creati i vari menu' con le relative intestazioni ed opzioni. 
     * In seguito l'andamento del programma e' scandito attraverso l'aggiornamento della variabile letteraMenu e l'uso di switch-case innestati,
     * in cui il primo livello (contraddistinto dalle variabili letterali) indica gli specifici menu', mentre il secondo livello (evidenziato
     * dall'uso della variabile intera 'scelta') indica le opzioni relative ad ogni menu' e le operazioni che vengono indi svolte
     * 
     * Pre : af != null
     * Pre : ao != null
     * 
     * @param af : oggetto di tipo AnagraficaFruitori
     * @param ao : oggetto di tipo AnagraficaOperatori
     */
	public void logicaMenu(AnagraficaFruitori af, AnagraficaOperatori ao) 
	{
		Menu a = new Menu(Costanti.INTESTAZIONE_A, Costanti.OPZIONI_A);
		Menu b = new Menu(Costanti.INTESTAZIONE_B, Costanti.OPZIONI_B);
		Menu c = new Menu(Costanti.INTESTAZIONE_C, Costanti.OPZIONI_C);
		Menu d = new Menu(Costanti.INTESTAZIONE_D, Costanti.OPZIONI_D_12);
		Menu e = new Menu(Costanti.INTESTAZIONE_E, Costanti.OPZIONI_E);
		Menu f = new Menu(Costanti.INTESTAZIONE_F, Costanti.OPZIONI_F_1);

		boolean esci = false;
		char letteraMenu = 'a';
		int scelta = Costanti.VUOTO;

		Fruitore attualef = null;
		Operatore attualeop = null;

		System.out.println(Costanti.SALUTO_INIZIALE);

		do 
		{
			af.decadenzaFruitore();

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
    	    		    
    				af.decadenzaFruitore();
    	    		break;
    	        }

				case ('b'): 
				{
					scelta = b.scegli();

					switch (scelta) 
					{
						case 1: iscrizione(af);
								letteraMenu = 'a';
								break;

						case 2: letteraMenu = 'c';
								break;

						case 3: letteraMenu = 'a';
								break;
					}

					af.decadenzaFruitore();
					break;
				}

				case ('c'): 
				{
					scelta = c.scegli();

					switch (scelta) 
					{
						case 1: attualef = (Fruitore) accesso(af);

								if (attualef != null) 
								{
									letteraMenu = 'd';
								} 
								else 
								{
									System.out.println(Costanti.ERRORE);
									letteraMenu = 'c';
								}

								break;

						case 2: letteraMenu = 'b';
								break;
					}

					af.decadenzaFruitore();
					break;
				}

				case ('d'): 
				{
					scelta = d.scegli();

					switch (scelta) 
					{
						case 1: if (attualef.rinnovaIscrizione())
									System.out.println(Costanti.RINNOVO_OK);
								else
									System.out.println(Costanti.RINNOVO_NON_OK);

								letteraMenu = 'd';
								break;

						case 2: System.out.println(attualef.toString());
								letteraMenu = 'd';
								break;

						case 3: letteraMenu = 'a';
								attualef = null;
								break;
					}

					af.decadenzaFruitore();
					break;
				}

				case ('e'): 
				{
					scelta = e.scegli();

					switch (scelta) 
					{
						case 1: attualeop = (Operatore) accesso(ao);

								if (attualeop != null) 
								{
									letteraMenu = 'f';
								}
								else 
								{
									System.out.println(Costanti.ERRORE);
									letteraMenu = 'e';
								}

								break;

						case 2: letteraMenu = 'a';
								break;
					}

					af.decadenzaFruitore();
					break;
				}

				case ('f'):
				{
					scelta = f.scegli();

					switch (scelta)
					{
						case 1: System.out.println(attualeop.visualizzaElencoFruitori(af));
								letteraMenu = 'f';
								break;

						case 2: letteraMenu = 'a';
								attualeop = null;
								break;
					}

					af.decadenzaFruitore();
					break;
				}

			}

		} while (!esci);

		System.out.println(Costanti.SALUTO_FINALE);
	}

}
