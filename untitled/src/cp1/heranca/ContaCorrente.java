package cp1.heranca;

public class ContaCorrente extends ContaBancaria{

    private int limiteSaques = 4;
    private int quantidadeSaques = 0;
    private boolean taxaAdicionada = false;

    ContaCorrente(String numeroConta, String titular, double saldo){
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar (double valor) throws SaldoInsuficienteException, LimiteSaquesException{
        if (valor > getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente para completar operação.");
        } else if (this.quantidadeSaques == this.limiteSaques) {
            throw new LimiteSaquesException("Limite de saques mensal atingido!");
        }
        this.setSaldo(getSaldo() - valor);
        this.quantidadeSaques ++;
        System.out.println("Operação concluída com sucesso.");
    }

    public void adicionaTaxa(){
        if (getSaldo() > 10 && !taxaAdicionada){
            setSaldo(getSaldo() - 10);
            taxaAdicionada = true;
            System.out.println("Taxa de manutenção mensal de R$ 10,00 cobrada automaticamente.");
        }
    }

    @Override
    public void depositar(double valor){
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de " + valor + " feito com sucesso!");
        adicionaTaxa();
    }

}