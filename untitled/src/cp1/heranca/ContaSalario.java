package cp1.heranca;

public class ContaSalario extends ContaBancaria{

    private int limiteSaques = 1;
    private int quantidadeSaques = 0;

    ContaSalario(String numeroConta, String titular, double saldo){
        super(numeroConta, titular, saldo);
    }

    @Override

    public void sacar(double valor) throws SaldoInsuficienteException, LimiteSaquesException{
        if (valor > getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente para completar a operação.");
        } else if (this.quantidadeSaques == this.limiteSaques) {
            throw new LimiteSaquesException("Limite de saques mensal atingido!");
        } else {
            setSaldo(getSaldo() - valor);
            this.quantidadeSaques++;
            System.out.println("Operação concluída com sucesso.");
        }
    }

}
