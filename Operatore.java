package it.ing.sw;

public class Operatore 
{
     private String nome;
     private String cognome;
     private int password;
     									// non ho messo lo username
     
     
     
     public Operatore(String nome, String cognome, int password)
     {
    	     this.nome = nome;
    	     this.cognome = cognome;
    	     this.password = password;
     }
     
     public void visualizzaElencoFruitori()
     {
    	     System.out.println(AnagraficaFruitori.visualizzaElementi());
     }
     
     
}
