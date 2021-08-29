package polimorfismo.com.inclusao;
public class Principal {
    public static void main(String[] args) 
    {
        Personalidade personalidades = new Personalidade();
        
        personalidades.acionaFalar(new Pessimista ());
        personalidades.acionaFalar(new Otimista ());
        personalidades.acionaFalar(new Extrovertido ());
        personalidades.acionaFalar(new Introvertido ());
    }
}