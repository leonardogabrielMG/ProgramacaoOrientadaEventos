package polimorfismo;
public class Polimorfismo 
{
    public static void main(String[] args) 
    {
        Personalidade[] personalidades = new Personalidade[4];
        
        personalidades[0] = new Pessimista ();
        personalidades[1] = new Otimista ();
        personalidades[2] = new Extrovertido ();
        personalidades[3] = new Introvertido ();
        
        System.out.println("Pessimista: " + personalidades[0].falar());
        System.out.println("Otimista: " + personalidades[1].falar());
        System.out.println("Extrovertido: " + personalidades[2].falar());
        System.out.println("Introvertido: " + personalidades[3].falar());
    }
}
