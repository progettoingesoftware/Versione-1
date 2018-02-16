package it.ing.sw;

import java.io.File;

public class Main 
{
	public static final String NOME_FILE = "gestoreRisorse.dat";								
	public static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";			
	public static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";			
	public static final String MSG_NO_FILE = "CARICAMENTO DA FILE NON RIUSCITO. OCCORRE CREARE UNA NUOVA LISTA UTENTI E UNA NUOVA LISTA BLOG";			
	public static final String MSG_SALVA = "SALVATAGGIO DATI";
	public static final String ERRORE_CONVERSIONE_DATA = "Attenzione! Si è verificato un errore di conversione della data";	

	public static void main(String[] args) 
	{
        File gestoreRisorse = new File(NOME_FILE); 
        AnagraficaFruitori anagrafica = null;
		boolean caricamentoRiuscito = false;
					
		if (gestoreRisorse.exists())
		{
			try 
			{
				anagrafica = (AnagraficaFruitori)ServizioFile.caricaSingoloOggetto(gestoreRisorse);
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
				if (anagrafica != null)
				{
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}		
		}
				
		if (!caricamentoRiuscito)				
		{
			System.out.println(MSG_NO_FILE);				
			anagrafica = new AnagraficaFruitori();			
		}
		
		GestoreMenu g = new GestoreMenu();
		g.logicaMenu(anagrafica);
		
		//alla fine di tutto
		System.out.println(MSG_SALVA);			
	    ServizioFile.salvaSingoloOggetto(gestoreRisorse, anagrafica);	

	}
	
}
