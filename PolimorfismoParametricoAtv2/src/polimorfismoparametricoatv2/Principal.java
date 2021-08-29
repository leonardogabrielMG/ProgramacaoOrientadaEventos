package polimorfismoparametricoatv2;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //1º prato
        ArrayList g1 = new ArrayList();
        g1.add("Feijão Tropeiro");
        g1.add("Arroz");
        ArrayList m1 = new ArrayList();
        m1.add("Lasanha");
        ArrayList c1 = new ArrayList();
        c1.add("Boi");
        ArrayList s1 = new ArrayList();
        s1.add("Rucula");
        
        PratosFeitos p1 = new PratosFeitos();
        p1.setGraos(g1);
        p1.setMassas(m1);
        p1.setCarnes(c1);
        p1.setSalada(s1);
        
        System.out.println("1º prato:");
        System.out.println("Graos: " + p1.getGraos());
        System.out.println("Massas: " + p1.getMassas());
        System.out.println("Carnes: " + p1.getCarnes());
        System.out.println("Salada: " + p1.getSalada());
        System.out.println("*********************");
        
        //2º prato
         ArrayList g2 = new ArrayList();
        ArrayList m2 = new ArrayList();
        ArrayList c2 = new ArrayList();
        ArrayList s2 = new ArrayList();
        
        PratosFeitos p2 = new PratosFeitos();
        p1.setGraos(g2);
        p1.setMassas(m2);
        p1.setCarnes(c2);
        p1.setSalada(s2);
        
        System.out.println("2º prato:");
        System.out.println("Graos: " + p2.getGraos());
        System.out.println("Massas: " + p2.getMassas());
        System.out.println("Carnes: " + p2.getCarnes());
        System.out.println("Salada: " + p2.getSalada());
        System.out.println("*********************");
        
        //3º prato
        ArrayList g3 = new ArrayList();
        g1.add("Milho");
        ArrayList m3 = new ArrayList();
        m1.add("Capelete");
        ArrayList c3 = new ArrayList();
        c1.add("Peixe");
        ArrayList s3 = new ArrayList();
        s1.add("Palmito");
        
        PratosFeitos p3 = new PratosFeitos();
        p1.setGraos(g3);
        p1.setMassas(m3);
        p1.setCarnes(c3);
        p1.setSalada(s3);
        
        System.out.println("1º prato:");
        System.out.println("Graos: " + p3.getGraos());
        System.out.println("Massas: " + p3.getMassas());
        System.out.println("Carnes: " + p3.getCarnes());
        System.out.println("Salada: " + p3.getSalada());
    }   
}