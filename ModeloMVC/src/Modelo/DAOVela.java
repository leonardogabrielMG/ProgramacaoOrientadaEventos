package Modelo;
public class DAOVela {
    public boolean cadastro(MVela vela){
        System.out.println("Vela cadastrada com sucesso!");
        return true;
    }
    
    public boolean busca(MVela vela){
        System.out.println("Todos as velas foram carregados com sucesso.\n*********************");
        return true;
    }
    
    public boolean apaga(MVela vela)
    {
        System.out.println("Dado apagado com sucesso.");
        return true;
    }
}