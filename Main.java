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
		 * Nel caso in cui il caricamento non sia andato a buon fine si provvedono a costruire ex novo le strutture dati richieste
		 */
		if (!caricamentoRiuscito)				
		{
			System.out.println(MSG_NO_FILE);				
			af = new AnagraficaFruitori();
			ao = new AnagraficaOperatori();
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
	
}
