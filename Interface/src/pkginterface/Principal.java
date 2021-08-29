package pkginterface;
public class Principal {
    public static void main(String[] args) 
    {
        Personalidade[] p = new Personalidade[4];
        
        p[0] = new Pessimista();
        p[1] = new Otimista();
        p[2] = new Extrovertido();
        p[3] = new Introvertido();
        
        System.out.println("Pessimista: " + p[0].falar());
        System.out.println("Otimista: " + p[1].falar());
        System.out.println("Extrovertido: " + p[2].falar());
        System.out.println("Introvertido " + p[3].falar());
    }
}
