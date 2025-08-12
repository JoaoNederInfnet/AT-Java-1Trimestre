package Moldes;

public class Gerente extends Funcionario
{
    //1)Construtor
    public Gerente(String nome, double salario)
    {
        super( nome,  salario * (1 + 0.2 ));
    }
    //----------------------------------------------------------------------------

    //2)Método para exibir as informações
    @Override
    public String montarExibicao()
    {
        return
        (
        "Gerente: " + getNome() + "\n" +
        "Salário: " + getSalario() + "\n" +
        "----------------------------------------------------------------------------"
        );
    }
}

