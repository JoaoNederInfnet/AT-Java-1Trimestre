package Moldes;

public class Estagiario extends Funcionario
{
    //1)Construtor
    public Estagiario(String nome, double salario)
    {
        super( nome,  salario * (1 - 0.1));
    }
    //----------------------------------------------------------------------------

    //2)Método para exibir as informações
    @Override
    public String montarExibicao()
    {
        return
        (
        "Estagiário: " + getNome() + "\n" +
        "Salário: " + getSalario() + "\n" +
        "----------------------------------------------------------------------------"
        );
    }
}
