package it.ing.sw;

import java.io.File;

public class Main 
{
	public static final String NOME_FILE = "gestoreRisorse.dat";								
	public static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";			
	public static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";			
	public static final String MSG_NO_FILE = "CARICAMENTO DA FILE NON RIUSCITO. OCCORRE CREARE UNA NUOVA LISTA UTENTI E UNA NUOVA LISTA BLOG";			
	public static final String MSG_SALVA = "SALVATAGGIO DATI";
	public static final String ERRORE_CONVERSIONE_DATA = "Attenzione! Si e' verificato un errore di conversione della data";	

	/**
	 * Metodo main per l'esecuzione del software
	 * @param args
	 */
	public static void main(String[] args) 
	{
        File gestoreRisorse = new File(NOME_FILE);
        RaccoltaAnagrafiche ra = null;
        AnagraficaFruitori af = null;
        AnagraficaOperatori ao = null;
		boolean caricamentoRiuscito = false;
		
		/**
		 * Tale istruzione verifica se il file in questione esiste all'interno del sistema di memorizzazione locale.
		 * In questo caso vengono estrapolate sia la RaccoltaAnagrafiche sia l'AnagraficaFruitori e l'AnagraficaOperatori, venendo salvate nelle variabili opportune.
		 * Le probabili eccezioni vengono gestite secondo la modalità piu' adatta al tipo di eccezione ed infine viene mostrato un messaggio di conferma se il caricamento da file gia' esistente si e' concluso con successo
		 */
		if (gestoreRisorse.exists())
		{
			/**
			 * Si cercano di reperire le istanze delle classi AnagraficaFruitori ed AnagraficaOperatori salvate su file. 
			 * Vengono inoltre opportunamente gestite le eccezioni di tipo ClassCast e NullPointer.
			 * Infine, nel caso in cui le istanze siano state correttamente inizializzate, viene mostrato a video un messaggio di conferma
			 * modificando al contempo una specifica variabile booleana per la segnalazione dell'avvenuto caricamento
			 */
			try 
			{
				ra = (RaccoltaAnagrafiche)ServizioFile.caricaSingoloOggetto(gestoreRisorse);
				af = ra.getAnagraficaFruitori();
				ao = ra.getAnagraficaOperatori();
			}
			catch (ClassCastException e)
			{
				System.out.println(MSG_NO_CAST);
			}
			catch(NullPointerException a)
			{
				System.out.println();
			}
			finally
			{
				if (af != null && ao != null)
				{
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}		
		}
		
		/**
		 * Nel caso in cui il caricamento da file non sia andato a buon fine si provvedono a costruire ex novo le strutture dati richieste e a caricare i dati preimpostati degli operatori
		 */
		if (!caricamentoRiuscito)				
		{
			System.out.println(MSG_NO_FILE);				
			af = new AnagraficaFruitori();
			ao = new AnagraficaOperatori();
			
			aggiuntaOperatoriPreimpostati(ao);
		}
		
		/**
		 * Viene costruito un nuovo gestore menu' che possa dare avvio alla logica del sistema applicativo 
		 */
		GestoreMenu g = new GestoreMenu();
		g.logicaMenu(af, ao);
		
		/**
		 * L'operazione di salvataggio prevede la costruzione di una nuova RaccoltaAnagrafiche attraverso i parametri AnagraficaFruitori ed AnagraficaOperatori e l'aggiornamento del file in gestoreRisorse
		 */
		System.out.println(MSG_SALVA);
		ra = new RaccoltaAnagrafiche(af, ao);
	    ServizioFile.salvaSingoloOggetto(gestoreRisorse, ra);	
	}
	
	/**
	 * Metodo per la creazione e l'aggiunta di 5 operatori preimpostati all'elenco degli operatori presente in AnagraficaOperatori
	 * 
	 * Pre : ao.elenco != null
	 * 
	 * @param ao : l'istanza della classe AnagraficaOperatore a cui aggiungere gli operatori
	 */
	public static void aggiuntaOperatoriPreimpostati(AnagraficaOperatori ao)
	{
		Operatore primo = new Operatore("Stefano", "Metelli", "ste", "161095");
		Operatore secondo = new Operatore("Alba", "Pasini", "sum56", "33alb33");
		Operatore terzo = new Operatore("Marco", "Bellini", "mark4", "starwars2");
		Operatore quarto = new Operatore("Fabio", "Piccinelli", "picci", "fighter118");
		Operatore quinto = new Operatore("Ottavia", "Lauretti", "oct4565", "ppla210");
		
		ao.elenco.addElement(primo);
		ao.elenco.addElement(secondo);
		ao.elenco.addElement(terzo);
		ao.elenco.addElement(quarto);
		ao.elenco.addElement(quinto);
	}
	
}
