package Moldes;

public class ContaBancaria
{
    //Atributos
    //a)Titular
    private String titular;
    //----------------------------------//--------------------------------
    //b)saldo
    private double  saldo;
    //----------------------------------------------------------------------------

    //Getters e setters
    //a)Titular
    public String getTitular()
    {
        return titular;
    }
    //----------------------------------//--------------------------------
    //b)Saldo
    public double getSaldo()
    {
        return saldo;
    }

    public void  setSaldo(double novoSaldo)
    {
        this.saldo = novoSaldo;
    }
    //----------------------------------------------------------------------------

    //3)Construtor
    public ContaBancaria(String titular, double saldo)
    {
        this.titular = titular;
        this.saldo = saldo;
    }
    //----------------------------------------------------------------------------

    //4)Métodos
    //a)depositar
    public String depositar(double valor)
    {
        if(valor > 0)
        {
            double novoSaldo = getSaldo() + valor;

            setSaldo(novoSaldo);

            return "Depósito realizado com sucesso!" + "\n---------------------------------------------------------------------------";
        }

        return "Não foi póssivel realizar o depósito" + "\n---------------------------------------------------------------------------";
    }
    //----------------------------------//--------------------------------
    //b)sacar
    public String sacar(double valor)
    {
        if(valor <= getSaldo())
        {
            double novoSaldo = getSaldo() - valor;

            setSaldo(novoSaldo);

            return "Saque realizado com sucesso!" + "\n---------------------------------------------------------------------------";
        }

        return "Não foi póssivel realizar o saque" + "\n---------------------------------------------------------------------------";
    }
    //----------------------------------//--------------------------------
    //c)exibir
    public  String  exibirSaldo()
    {
        return "Titular: " + getTitular() + "\n" + "Saldo: " + getSaldo() + "\n---------------------------------------------------------------------------";
    }
}

