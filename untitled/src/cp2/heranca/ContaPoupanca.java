package cp2.heranca;

public class ContaPoupanca extends ContaBancaria {

    ContaPoupanca(String numeroConta, String titular, double saldo){
        super(numeroConta, titular, saldo);
    }

    private void acrescentaRendimento(){
        this.setSaldo(getSaldo() + (0.15 * getSaldo()));
    }

    @Override

    public void depositar(double valor){
        setSaldo((getSaldo() + valor));
        acrescentaRendimento();
        System.out.println("Depósito de " + valor + " feito com sucesso!");
    }

}