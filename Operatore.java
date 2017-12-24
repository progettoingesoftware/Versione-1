package it.ing.sw;

public class Operatore 
{
	private String nome;
    private String cognome;
    private String password;
    							
    public Operatore(String n, String c, String p)
    {
   	     this.nome = n;
   	     this.cognome = c;
   	     this.password = p;
    }
    
    public void visualizzaElencoFruitori(AnagraficaFruitori e)
    {
   	     System.out.println(e.toString());
    }
    
}
