package polimorfismoparametricoatv1;

import java.util.ArrayList;

public class Familia {
    private ArrayList<String> nomePais;
    private ArrayList<String> nomeIrmaos;

    public ArrayList<String> getNomePais() {
        return nomePais;
    }

    public void setNomePais(ArrayList<String> nomePais) {
        if(!nomePais.isEmpty()){
            this.nomePais = nomePais;
        }else{
            System.out.println("Nome de pais não informado");
        }
    }

    public ArrayList<String> getNomeIrmaos() {
        return nomeIrmaos;
    }

    public void setNomeIrmaos(ArrayList<String> nomeIrmaos) {
        if(!nomeIrmaos.isEmpty()){
            this.nomeIrmaos = nomeIrmaos;
        }else{
            System.out.println("Nome dos irmãos não informado");
        }
    }
}