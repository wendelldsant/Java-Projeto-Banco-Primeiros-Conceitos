package cp1.encapsulamento;

public class Conta {

    private String nome;
    private double saldo;

    public Conta(double saldo, String nome){
        this.saldo = saldo;
        this.nome = nome;
    }

    public String getTitular(){
        return this.nome;
    }

    public double consultarSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setTitular(String nome){
        this.nome = nome;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " feito com sucesso!");
    }

    public void sacar(double valor){
        if (valor > this.saldo){
            System.out.println("Saldo insuficiente para realizar o saque. Tente novamente.");
        } else {
            this.saldo -= valor;
            System.out.println("Saque efetuado com sucesso!");
        }
    }

}
