package cp2.heranca;

public class ContaPoupanca extends ContaBancaria {

    ContaPoupanca(String numeroConta, String titular, double saldo){
        super(numeroConta, titular, saldo);
    }

    public void acrescentaRendimento(){
        this.setSaldo(getSaldo() + (0.15 * getSaldo()));
    }

}