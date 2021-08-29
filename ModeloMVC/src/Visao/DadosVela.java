package Visao;

import Controlador.CVela;
import Modelo.MVela;
import java.util.ArrayList;
import java.util.Scanner;

public class DadosVela 
{
    public static void main(String[] args) 
    {
        Scanner ler = new Scanner(System.in);
        
        int SN, opc = 0;
        String tipoVela, validade, fornecedor;
        double tamanho, preco;
        boolean castical = false;
        MVela mve = new MVela();
        ArrayList<MVela> mvela = new ArrayList();
        CVela cve = new CVela();
        
        do
        {
            if (opc < 0 || opc > 3)
            {
                System.out.println("Opção inválida!");
            }
            System.out.println("1 - Adicionar vela");
            System.out.println("2 - Mostrar velas");
            System.out.println("3 - Excluir vela");
            System.out.println("0 - sair");
            opc = ler.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Você escolheu adicionar uma nova vela.");
                    clearBuffer(ler);
                    System.out.printf("Informe o tipo da vela: ");
                    tipoVela = ler.nextLine();
                    mve.setTipoVela(tipoVela);
                    System.out.printf("Informe o tamanho da vela em cm: ");
                    tamanho = ler.nextDouble();
                    mve.setTamanho(tamanho);
                    clearBuffer(ler);
                    System.out.printf("Informe a validade da vela(DD/MM/AAAA): ");
                    validade = ler.nextLine();
                    mve.setValidade(validade);
                    System.out.printf("Informe o preço da vela R$ ");
                    preco = ler.nextDouble();
                    mve.setPreco(preco);
                    clearBuffer(ler);
                    System.out.printf("Informe o fornecedor da vela: ");
                    fornecedor = ler.nextLine();
                    mve.setFornecedor(fornecedor);
                    do
                    {
                        System.out.printf("Possui castiçal(tecle 1 caso possua ou 0 caso não): ");
                        SN = ler.nextInt();
                    }while(SN < 0 || SN > 1);
                    if(SN == 1)
                    {
                        castical = true;
                    }else if(SN == 0)
                    {
                        castical = false;
                    }   mve.setCastical(castical);
                    cve.adicionarVela(mve);
                    mvela.add(mve);
                    break;
                case 2:
                    System.out.println("Você escolheu ver todas as velas cadastradas. + \n");
                    cve.imprimirVela(mve);
                    for(int i = 0; i < mvela.size(); i++)
                    {
                        System.out.println("Vela na posição " + i);
                        System.out.println("Tipo da vela: " + mvela.get(i).getTipoVela());
                        System.out.println("Tamanho da vela: " + mvela.get(i).getTamanho() + "cm");
                        System.out.println("Validade: " + mvela.get(i).getValidade());
                        System.out.println("Preço R$ " + mvela.get(i).getPreco());
                        System.out.println("Fornecedor: " + mvela.get(i).getFornecedor());
                        System.out.println("Possui castiçal: " + mvela.get(i).getCastical());
                        System.out.println("*********************");
                    }   break;
                case 3:
                    System.out.printf("Informe a posição que deseja apagar:");
                    int apaga = ler.nextInt();
                    boolean ans = cve.apagaVela(mve, apaga, mvela.size());
                    if (ans == true){
                        mvela.remove(apaga);
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por usar o nosso sistema =)");
            }
        }while(opc != 0 );
        
    }

    private static void clearBuffer(Scanner ler) 
    {
         if (ler.hasNextLine()) 
         {
            ler.nextLine();
         }
    }
}