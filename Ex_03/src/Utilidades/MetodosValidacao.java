package Utilidades;
//============================================

//1)Importacoes
//a)Importando a classe ResultadoValidacao
import Moldes.ResultadoValidacao;
//----------------------------------//--------------------------------
//b)Para conseguir chamar as stringsde MetodosRegex diretamente
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
        //Criando o regex para validar as nomes próprios
         String regexNomesProprios = "^[\\p{Lu}][\\p{Ll}]+$";

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
        //b)Validar o salário mensal
        public static ResultadoValidacao validarSalario(String salarioMensal)
        {
            //1)Validações
            //a)Validando se a entrada está vazia
            if(salarioMensal.isEmpty())
            {
                return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
            }
            //----------------------------------//--------------------------------
            //b)Validando se é um número
            //Para o usuário conseguir inserir valores com vírgula
            String entrada = salarioMensal.replace("," , ".");

            //Tentando converter o valor inserido para double
            //Primeiro declaro double
            double salario = 0;

            try
            {
                salario = Double.parseDouble(entrada);
            }
            //Disparando erro
            catch (NumberFormatException e)
            {
                return new ResultadoValidacao(false,"O valor inserido não é um número!");
            }
            //----------------------------------//--------------------------------
            //c)Validando se o salário é maior que zero
            if(salario <= 0)
            {
                return new ResultadoValidacao(false,"O valor inserido não é um salário válido!");
            }
            //----------------------------------------------------------------------------

            //2)Retorno para salário válido
            return  new ResultadoValidacao(true,"");
        }
}

