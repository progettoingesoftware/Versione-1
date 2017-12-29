package it.ing.sw;

import java.io.File;

public class Versione_1_Main {

	public static final String NOME_FILE = "Versione_1.dat";								
	public static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";			
	public static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";			
	public static final String MSG_NO_FILE = "CARICAMENTO DA FILE NON RIUSCITO. OCCORRE CREARE UN ELENCO DI FRUITORI";			
	public static final String MSG_RICHIESTA_SALVATAGGIO = "SI DESIDERA SALVARE LE MODIFICHE EFFETTUATE? (Y/N)";
	public static final String MSG_SALVA = "SALVATAGGIO DATI";

	public static void main(String[] args) 
	{
		File versione_1 = new File(NOME_FILE); 
		
		AnagraficaFruitori archivio = null;      			
		
		boolean caricamentoRiuscito = false;
					
		if (versione_1.exists())
		{
			try 
			{
				archivio = (AnagraficaFruitori)ServizioFile.caricaSingoloOggetto(versione_1);
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
				if (archivio != null)
				{
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}
					
		}
				
		if (!caricamentoRiuscito)				
		{
			System.out.println(MSG_NO_FILE);				
			archivio = new AnagraficaFruitori();							
		}
		
		
		//////////
		AnagraficaFruitori Archivio = new AnagraficaFruitori();
		 
	    Menu.mostraSalutoIniziale();
	     
	    int scelta = Menu.eseguiMenuB();
	     
	    Menu.selettoreMenuB(scelta);
	   
	    ////////
	    char salva = InputDati.leggiUpperChar(MSG_RICHIESTA_SALVATAGGIO, "YN");
	    
	    if(salva == 'Y')
	    {
	    	System.out.println(MSG_SALVA);			

	    	ServizioFile.salvaSingoloOggetto(versione_1, archivio);	
	    }
	     
	}

}
