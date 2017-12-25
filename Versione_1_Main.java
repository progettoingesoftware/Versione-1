package it.ing.sw;

public class Versione_1_Main {

	public static void main(String[] args) 
	{
		AnagraficaFruitori Archivio = new AnagraficaFruitori();
		 
	     Menu.mostraSalutoIniziale();
	     
	     int scelta = Menu.eseguiMenuB();
	     
	     Menu.selettoreMenuB(scelta);
	     
	     scelta = Menu.eseguiMenuC();
	     
		Menu.selettoreMenuC(scelta);
	     
	     
	}

}
