package polimorfismoparametricoatv2;

import java.util.ArrayList;

public class PratosFeitos {
    private ArrayList<String> graos;
    private ArrayList<String> massas;
    private ArrayList<String> carnes;
    private ArrayList<String> salada;

    public ArrayList<String> getGraos() {
        return graos;
    }

    public void setGraos(ArrayList<String> graos) {
        if(graos.contains("Arroz")||graos.contains("Feijão Tropeiro")||graos.contains("Feijão de Caldo")||graos.contains("Feijoada")){
            this.graos = graos;
        }else{
            System.out.println("Grão inválido!");
        }
    }

    public ArrayList<String> getMassas() {
        return massas;
    }

    public void setMassas(ArrayList<String> massas) {
        if(massas.contains("Macarrão")||massas.contains("Lasanha")||massas.contains("Nhoque")){
            this.massas = massas;
        }else{
            System.out.println("Massa inválida!");
        }
    }

    public ArrayList<String> getCarnes() {
        return carnes;
    }

    public void setCarnes(ArrayList<String> carnes) {
        if(carnes.contains("Boi")||carnes.contains("Porco")||carnes.contains("Frango")){
            this.carnes = carnes;
        }else{
            System.out.println("Carne inválida!");
        }
        
    }

    public ArrayList<String> getSalada() {
        return salada;
    }

    public void setSalada(ArrayList<String> salada) {
        if(salada.contains("Alface")||salada.contains("Tomate")||salada.contains("Rucula")||salada.contains("Pepino")){
            this.salada = salada;
        }else{
            System.out.println("Saláda inválida!");
        }
    }
    
}
