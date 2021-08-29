package polimorfismoparametricoatv1;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //1º pessoa
        ArrayList<String> pais1 = new ArrayList<>();
        pais1.add("João");
        pais1.add("Maria");
        ArrayList<String> irmaos1 = new ArrayList<>();
        irmaos1.add("Andre");
        
        Familia f1 = new Familia();
        
        f1.setNomePais(pais1);
        f1.setNomeIrmaos(irmaos1);
        System.out.println("Pessoa 1:"+"\n"+"Nome dos pais: "+f1.getNomePais()+"\n"+"Nome do irmão: "+f1.getNomeIrmaos());
        System.out.println("*********************");
        //2º pessoa
        ArrayList<String> pais2 = new ArrayList<>();
        ArrayList<String> irmaos2 = new ArrayList<>();
        
        Familia f2 = new Familia();
        
        f2.setNomePais(pais2);
        f2.setNomeIrmaos(pais2);
        System.out.println("Pessoa 2:"+"\n"+"Nome dos pais: "+f2.getNomePais()+"\n"+"Nome do irmão: "+f2.getNomeIrmaos());
        System.out.println("*********************");
        //3º pessoa
        ArrayList<String> pais3 = new ArrayList<>();
        pais3.add("Caio");
        pais3.add("Caroline");
        ArrayList<String> irmaos3 = new ArrayList<>();
        irmaos3.add("Cecilia");
        irmaos3.add("Carla");
        
        Familia f3 = new Familia();
        
        f3.setNomePais(pais3);
        f3.setNomeIrmaos(irmaos3);
        System.out.println("Pessoa 3:"+"\n"+"Nome dos pais: "+f3.getNomePais()+"\n"+"Nome do irmão: "+f3.getNomeIrmaos());
    }
    
}
