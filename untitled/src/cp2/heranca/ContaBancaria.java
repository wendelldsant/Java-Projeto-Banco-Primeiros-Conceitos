package cp2.heranca;

public class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;

    ContaBancaria(String numeroConta, String titular, double saldo){
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void exibeDados(){
        System.out.println("\n********************************\n");
        System.out.println("Titular: " + this.titular);
        System.out.println("Número da conta: " + this.numeroConta);
        System.out.println("Saldo Atual: R$" + this.saldo);
        System.out.println("\n********************************\n");

    }

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public String getTitular(){
        return this.titular;
    }

    public void setTitular(String nome){
        this.titular = nome;
        System.out.println("Titular alterado com sucesso!");
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double valor){
        this.saldo = valor;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Depósito de " + valor + " feito com sucesso!");

    }

    public void sacar(double valor) throws SaldoInsuficienteException, LimiteSaquesException{
        if (valor > this.saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente para completar operação.");
        }
        System.out.println("Saque concluído com sucesso!");
        saldo -= valor;
    }

}