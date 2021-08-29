package polimorfismo.com.inclusao;
public class Personalidade {
    public String falar()
    {
        return "";
    }
    
    public void acionaFalar(Personalidade obj)
    {
        System.out.println(obj.falar());
    }
}