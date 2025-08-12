package Utilidades;
//============================================
//1)Importacoes
//a)Importando a classe ResultadoValidacao
import Moldes.ResultadoValidacao;
//----------------------------------//--------------------------------
//b)Para conseguir chamar as strings de PadroesRegex diretamente
import static Utilidades.PadroesRegex.*;
//----------------------------------//--------------------------------
//c)Para conseguir chamar as stringsde MetodosRegex diretamente
import static Utilidades.MetodosRegex.*;
//============================================

//Classe para cuidar de todos os métodos relacionados diretamente com a as validações das entradas
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
        boolean resultadoCombinacao =  conferirMatching(regexNomesProprios, nome);

        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "Você precisa digitar um nome próprio!");
        }
        //----------------------------------------------------------------------------
        //2)Caso passe na validação
        return new ResultadoValidacao(true, "");
    }
    //----------------------------------//--------------------------------
    //b)Validação da senha
    public static ResultadoValidacao validarSenha(String senha)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(senha.isEmpty())
        {
            return new ResultadoValidacao(false,"Você precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se a senha possui no mínimo 8 caracteres
        boolean resultadoCombinacao = conferirMatching(regexQuantidade, senha);

        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "A senha precisa ter no mínimo 8 caracteres!");
        }
        //----------------------------------//--------------------------------
        //c)Validando se a senha possui pelo menos uma letra maiúscula
        resultadoCombinacao = conferirMatching(regexLetrasMaiusculas, senha);

        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "A senha precisa ter no mínimo 1 letra maiúscula!");
        }
        //----------------------------------//--------------------------------
        //d)Validando se a senha possui pelo menos uma letra minúscula
        resultadoCombinacao = conferirMatching(regexLetrasMinusculas, senha);

        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "A senha precisa ter no mínimo 1 letra minúscula!");
        }
        //----------------------------------//--------------------------------
        //e)Validando se a senha possui pelo menos um dígito
        resultadoCombinacao = conferirMatching(regexDigitos, senha);

        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "A senha precisa ter no mínimo 1 dígito!");
        }
        //----------------------------------//--------------------------------
        //f)Validando se a senha possui pelo menos um caractere especial
        resultadoCombinacao = conferirMatching(regexCaracteresEspeciais, senha);

        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "A senha precisa ter no mínimo 1 caractere especial!");
        }
        //----------------------------------------------------------------------------

        //2)Caso passe nas validações
        return new ResultadoValidacao(true, "");
    }
}
