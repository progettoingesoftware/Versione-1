package it.ing.sw;

public class Versione_1_Main {

	public static void main(String[] args) 
	{
		 AnagraficaFruitori Archivio = new AnagraficaFruitori();
		 
	     Menu.mostraSalutoIniziale();
	     
	     int scelta = Menu.eseguiMenuSceltaModalita(); //viene eseguito tutto nella classe Menu
	     
	     Menu.selettoreMenuSceltaModalita(scelta);
	     
	     scelta = Menu.eseguiMenuSceltaAzioneFruitore();
	     
	     Menu.selettoreMenuSceltaAzioneFruitore(scelta);
	     
	     
	}

}
