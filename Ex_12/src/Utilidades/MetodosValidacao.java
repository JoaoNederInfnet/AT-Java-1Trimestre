package Utilidades;

import Moldes.ResultadoValidacao;

import static Utilidades.MetodosRegex.conferirMatching;

public class MetodosValidacao
{
    //1)Validar nome
    public static ResultadoValidacao validarNome(String nome)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(nome.isEmpty())
        {
            return new ResultadoValidacao(false,"Você precisa digitar algo antes de apertar \"Enter\"!");
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

    public static ResultadoValidacao validarMensagem(String nome) {
        //1)Validações
        //a)Validando se a entrada está vazia
        if (nome.isEmpty())
        {
            return new ResultadoValidacao(false, "Você precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno caso passe na validação
        return new ResultadoValidacao(true, "");
    }
}
