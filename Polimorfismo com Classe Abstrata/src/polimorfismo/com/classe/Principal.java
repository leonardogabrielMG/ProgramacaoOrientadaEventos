package polimorfismo.com.classe;
public class Principal {
    public static void main(String[] args) 
    {
        Personalidade p1 = new Pessimista();
        Personalidade p2 = new Otimista();
        Personalidade p3 = new Extrovertido();
        Personalidade p4 = new Introvertido();
        
        System.out.println("Pessimista: " + p1.falar());
        System.out.println("Otimista: " + p2.falar());
        System.out.println("Extrovertido: " + p3.falar());
        System.out.println("Introvertido: " + p4.falar());
    }
    
}
