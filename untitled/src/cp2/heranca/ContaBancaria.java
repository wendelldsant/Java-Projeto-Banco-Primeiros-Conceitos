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

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public String getTitular(){
        return this.titular;
    }

    public void setTitular(String nome){
        this.titular = nome;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double valor){
        this.saldo += valor;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Depósito de " + valor + " feito com sucesso!");
    }

    public void sacar(double valor) throws SaldoInsuficienteException, LimiteSaquesException{
        if (valor > this.saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente para completar operação.");
        }
        saldo -= valor;
    }

}