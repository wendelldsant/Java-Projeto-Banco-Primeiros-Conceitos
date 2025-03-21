package cp2.heranca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ContaBancaria conta = null;

        System.out.println("Crie sua conta no Banco FIAP!");
        System.out.print("Digite seu nome: ");
        String titular = leitura.nextLine();

        while (conta == null){
            String[] tiposDeContas= {"Corrente", "Poupança", "Salário"};
            System.out.println("Qual tipo de conta você deseja criar?");
            for (int i = 0; i < tiposDeContas.length; i++) {
                System.out.println(i + ". " + tiposDeContas[i]);
            }
            System.out.print("Digite a opção escolhida: ");
            int tipoContaEscolhida = leitura.nextInt();
            switch (tipoContaEscolhida){
                case 0:
                    conta = new ContaCorrente("0001", titular, 0 );
                    break;
                case 1:
                    conta = new ContaPoupanca("0001", titular, 0);
                    break;
                case 2:
                    conta = new ContaSalario("0001", titular, 0);
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }

        int userChoice = 0;

        String[] operacoes = {"Depositar", "Sacar", "Exibir Informações", "Alterar Titular", "Sair"};
        while(userChoice != (operacoes.length-1)){
            System.out.println("\nOPERAÇÕES");
            for (int i = 0; i < operacoes.length; i++) {
                System.out.println(i + " ." + operacoes[i]);
            }
            System.out.print("Digite a opção escolhida: ");
            userChoice = leitura.nextInt();
            switch (userChoice){
                case 0:
                    System.out.print("Digite o valor que deseja depositar: ");
                    double valor = leitura.nextDouble();
                    conta.depositar(valor);
                    if (conta instanceof ContaCorrente) {
                        conta.adicionaTaxa();  // Chama o método apenas se for ContaCorrente
                    }
                    break;
                case 1:
                    System.out.print("Digite o valor que deseja sacar: ");
                    valor = leitura.nextDouble();
                    try {
                        conta.sacar(valor);
                        break;
                    } catch (SaldoInsuficienteException e){
                        System.out.println("Erro: " + e.getMessage());
                    } catch (LimiteSaquesException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    conta.exibeDados();
                    break;
                case 3:
                    System.out.print("Digite o novo nome do titular: ");
                    leitura.nextLine();  //adicionado devido ao buffer \n deixado na entrada
                    String nome = leitura.nextLine();
                    conta.setTitular(nome);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }





    }
}
