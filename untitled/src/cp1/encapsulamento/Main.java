package cp1.encapsulamento;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        System.out.println("Crie sua conta no Banco FIAP!");
        System.out.print("Digite seu nome do Titular: ");
        String titular = leitura.nextLine();

        Conta conta = new Conta(0, titular);

        System.out.println("********************************\n");
        System.out.println("Seja bem vindo ao Banco FIAP!");
        System.out.println("Titular da Conta: " + conta.getTitular());
        System.out.println("Saldo: R$ " + conta.consultarSaldo() + "\n");
        System.out.println("********************************");

        int userChoice = 0;
        while (userChoice != 6){
            String[] menu = {"Consultar saldo", "Depósito", "Saque", "Alterar Titular", "Dados Cadastrais", "Sair"};
            System.out.println("\nEscolha uma das opções abaixo");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i+1) + ". " + menu[i]);
            }
            System.out.print("Digite a opção escolhida: ");
            userChoice = leitura.nextInt();

            switch (userChoice){
                case 1:
                    double saldo = conta.consultarSaldo();
                    System.out.println("\nSeu saldo é de R$ " + saldo);
                    break;
                case 2:
                    System.out.print("\nDigite o valor de depósito: ");
                    double valor = leitura.nextDouble();
                    conta.depositar(valor);
                    break;
                case 3:
                    System.out.print("\nDigite o valor que você deseja sacar: ");
                    valor = leitura.nextDouble();
                    conta.sacar(valor);
                    break;
                case 4:
                    System.out.print("\nDigite o novo nome de titular: ");
                    leitura.nextLine();
                    titular = leitura.nextLine();
                    conta.setTitular(titular);
                    System.out.println("Titular alterado com sucesso. O novo titular é " + conta.getTitular());
                    break;
                case 5:
                    System.out.println("\nTitular da Conta: " + conta.getTitular());
                    System.out.println("Saldo: R$ " + conta.consultarSaldo());
                    break;
                case 6:
                    System.out.println("Encerrando login...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }

        }



        }
    }