package Moldes;

public class Aluno
{
    //Atributos
    //a)Nome
    private String nome;
    //----------------------------------//--------------------------------
    //b)Matricula
    private String matricula;
    //----------------------------------//--------------------------------
    //c)nota1
    private double nota1;
    //----------------------------------//--------------------------------
    //c)nota2
    private double nota2;
    //----------------------------------//--------------------------------
    //c)nota3
    private double nota3;


    //2)Construtor
    public Aluno(String nome, String matricula, double[]notas)
    {
        this. nome =  nome;
        this. matricula =  matricula;
        this. nota1 =  notas[0];
        this. nota2 =  notas[1];
        this. nota3 =  notas[2];
    }
    //----------------------------------------------------------------------------

    //3)Métodos
    //a)calcularMedia()
    public double calcularMedia()
    {
        return (nota1 + nota2 + nota3) / 3;
    }
    //----------------------------------//--------------------------------
    //b)verificarAprovacao
    public String verificarAprovacao(double media)
    {
        if(media >= 7)
        {
            return "Aprovado!";
        }
        else
        {
            return "Reprovado!";
        }
    }
    //----------------------------------//--------------------------------
    //c)Para montar a exibição dos dados
    public String montarExibicao(double media)
    {
        return
       (
        "Nome: "+ nome + "\n"+
        "Matrícula: "+ matricula + "\n"+
        "1ª nota: "+ nota1 + "\n"+
        "2ª nota: "+ nota2 + "\n"+
        "3ª nota: "+ nota3 + "\n"+
        "Média: "+ media + "\n"+
        "Situação: "+ verificarAprovacao(media) + "\n"+
         "----------------------------------------------------------------------------"
        );
    }
}
