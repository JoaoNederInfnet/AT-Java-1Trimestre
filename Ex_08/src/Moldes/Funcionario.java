package Moldes;

public class Funcionario
{
    //Atributos
    //a)Nome
    private String nome;
    //----------------------------------//--------------------------------
    //b)Salário
    private double salario;
    //----------------------------------------------------------------------------

    //Getters
    //a)Nome
    public String getNome()
    {
        return nome;
    }
    //----------------------------------//--------------------------------
    //b)Salário
    public double getSalario()
    {
        return salario;
    }
    //----------------------------------------------------------------------------

    //3)Construtor
    public Funcionario(String nome, double salario)
    {
        this.nome = nome;
        this.salario = salario;
    }
    //----------------------------------------------------------------------------

    //4)Método para exibir as informações
    public  String montarExibicao()
    {
        return "";
    }
}
