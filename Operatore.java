package it.ing.sw;

public class Operatore 
{
     private String nome;
     private String cognome;
     private String password;
     									// non ho messo lo username
     
     
     
     public Operatore(String nome, String cognome, String password)
     {
    	     this.nome = nome;
    	     this.cognome = cognome;
    	     this.password = password;
     }
     
     public void visualizzaElencoFruitori(AnagraficaFruitori elenco)
     {
    	     System.out.println(elenco.toString());
     }
     
     
}
