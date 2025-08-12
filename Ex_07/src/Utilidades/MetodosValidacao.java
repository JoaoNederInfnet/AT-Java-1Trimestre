package Utilidades;
//============================================

//Importações
import Moldes.*;
import static Utilidades.MetodosRegex.*;
//============================================

public class MetodosValidacao
{
    //1)Validar nome
    public static ResultadoValidacao validarNome(String nome)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(nome.isEmpty())
        {
            return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um nome válido
        //Criando o regex para validar as nomes próprios
        String regexNomesProprios = "^[\\p{Lu}][\\p{Ll}]+(\\s?(de|da|das|do|dos)?\\s([\\p{Lu}][\\p{Ll}]+))*$";

        //Conferindo matching entre o regex e a entrada
        boolean resultadoCombinacao =  conferirMatching(regexNomesProprios, nome);

        //Caso não seja válido
        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "Você precisa digitar um nome próprio!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno caso passe na validação
        return new ResultadoValidacao(true, "");
    }
    //----------------------------------//--------------------------------

    //b)Validar a matricula
    public static ResultadoValidacao validarMatricula(String matricula)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(matricula.isEmpty())
        {
            return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um matricula válido
        //Criando o regex para validar a matrícula, vou permitir qualquer coisa menos caracteres especiais e espaços vazios
        String regexMatriculas = "^(?=(?:.*\\p{Lu}|.*\\p{Ll}|.*\\d)).{5,}$";

        //Conferindo matching entre o regex e a entrada
        boolean resultadoCombinacao =  conferirMatching(regexMatriculas, matricula);

        //Caso não seja válido
        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "Você precisa digitar uma matrícula válida!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno caso passe na validação
        return new ResultadoValidacao(true, "");
    }
    //----------------------------------//--------------------------------

    //c)Validar  a nota
    public static ResultadoValidacao validarNota(String nota)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(nota.isEmpty())
        {
            return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um número
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = nota.replace("," , ".");

        //Tentando converter o valor inserido para double
        //Primeiro declaro double
        double score = 0;

        try
        {
            score = Double.parseDouble(entrada);
        }
        //Disparando erro
        catch (NumberFormatException e)
        {
            return new ResultadoValidacao(false,"O valor inserido não é um número!");
        }
        //----------------------------------//--------------------------------
        //c)Validando se a nota é maior que zero
        if(score <= 0)
        {
            return new ResultadoValidacao(false,"O valor inserido não é uma nota válida!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno para nota válido
        return  new ResultadoValidacao(true,"");
    }
}
