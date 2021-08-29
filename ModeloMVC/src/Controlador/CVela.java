package Controlador;

import Modelo.DAOVela;
import Modelo.MVela;

public class CVela 
{
    DAOVela valida = new DAOVela();
    public boolean adicionarVela(MVela vela)
    {
        if(vela.getTipoVela().equals(""))
        {
            System.out.println("Tipo inválido");
            vela.setTipoVela("Tipo não informado.");
        }
        if(vela.getValidade().length() < 10)
        {
            System.out.println("Modelo de data inválida!");
            vela.setValidade("Validade inválida.");
        }
        if(vela.getFornecedor().equals(""))
        {
            System.out.println("Fornecedor não informado!");
            vela.setFornecedor("Fornecedor não informado.");
        }
        return valida.cadastro(vela);
    }
    
    public boolean imprimirVela(MVela vela){
        return valida.busca(vela);
    }
    
    public boolean apagaVela(MVela vela, int apaga, int tamanho){
        if(apaga < 0)
        {
            System.out.println("Indive inválido!");
            return false;
        }else if(apaga >= tamanho)
        {
            System.out.println("Indice ainda não foi cadastrado!");
            return false;
        }else{
            return valida.apaga(vela);
        }
    }
}