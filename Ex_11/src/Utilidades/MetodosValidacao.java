package Utilidades;

import Moldes.ResultadoValidacao;

public class MetodosValidacao
{
    //1)Validar  a numero
    public static ResultadoValidacao validarNumero(String numero)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(numero.isEmpty())
        {
            return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um número
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = numero.replace("," , ".");

        //Tentando converter o valor inserido para int
        //Primeiro declaro int
        int number = 0;

        try
        {
            number = Integer.parseInt(entrada);
        }
        //Disparando erro
        catch (NumberFormatException e)
        {
            return new ResultadoValidacao(false,"O valor inserido não é um número!");
        }
        //----------------------------------//--------------------------------
        //c)Validando se o numero não pertence ao invtervalo de 1 a 60
        if(number < 1 || number > 60)
        {
            return new ResultadoValidacao(false,"O valor inserido não é um número de 1 a 60!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno para numero válido
        return  new ResultadoValidacao(true,"");
    }
}
