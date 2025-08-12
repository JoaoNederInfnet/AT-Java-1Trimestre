package Utilidades;
//============================================

//Importações
import Moldes.ResultadoValidacao;
import static Utilidades.MetodosRegex.*;
//============================================

public  class MetodosValidacao
{
    //1)Validando os dados do arquivo
    //a)Nome do arquivo/Nome da pasta
    public static ResultadoValidacao validarNomeArquivoOuPasta(String nome)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(nome.isEmpty())
        {
            return new ResultadoValidacao(false,"Você precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um nome de arquivo válido
        //Criando o regex para validar o nome do arquivo
        String regexNome = "^(?=.*[a-zA-Z\\d]).*$";

        //Conferindo matching entre o regex e a entrada
        boolean resultadoCombinacao =  conferirMatching(regexNome, nome);

        //Caso não seja válido
        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "Você precisa digitar um nome sem caracteres especiais e nem letras acentuadas!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno caso passe na validação
        return new ResultadoValidacao(true, "");
    }
    //----------------------------------------------------------------------------

    //2)Validando os dados do produto
    //a)Nome
    public static ResultadoValidacao validarProduto(String produto)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(produto.isEmpty())
        {
            return new ResultadoValidacao(false,"Você precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um produto válido
        //Criando o regex para validar os nomes dos produtos
        String regexNomesProdutos = "^[\\p{Lu}][\\p{Ll}]+(\\s?(de|da)?\\s([\\p{Lu}][\\p{Ll}]+))*$";

        //Conferindo matching entre o regex e a entrada
        boolean resultadoCombinacao =  conferirMatching(regexNomesProdutos, produto);

        //Caso não seja válido
        if(!resultadoCombinacao)
        {
            return new ResultadoValidacao(false, "Você precisa digitar o nome de um produto!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno caso passe na validação
        return new ResultadoValidacao(true, "");
    }
    //----------------------------------//--------------------------------

    //b)Quantidade
    public static ResultadoValidacao validarQuantidade(String quantidade)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(quantidade.isEmpty())
        {
            return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um número
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = quantidade.replace("," , ".").trim();

        //Tentando converter o valor inserido para int
        //Primeiro declaro int
        int quantia = 0;

        try
        {
            quantia = Integer.parseInt(entrada);
        }
        //Disparando erro
        catch (NumberFormatException e)
        {
            return new ResultadoValidacao(false,"O valor inserido não é um número!");
        }
        //----------------------------------//--------------------------------
        //c)Validando se a quantidade é maior que zero
        if(quantia <= 0)
        {
            return new ResultadoValidacao(false,"O valor inserido não é uma quantidade válida!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno para quantidade válida
        return  new ResultadoValidacao(true,"");
    }
    //----------------------------------//--------------------------------

    //c)Preco
    public static ResultadoValidacao validarPreco(String preco)
    {
        //1)Validações
        //a)Validando se a entrada está vazia
        if(preco.isEmpty())
        {
            return new ResultadoValidacao(false,"Voce precisa digitar algo antes de apertar \"Enter\"!");
        }
        //----------------------------------//--------------------------------
        //b)Validando se é um número
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = preco.trim().replace("," , ".");

        //Tentando converter o valor inserido para double
        //Primeiro declaro double
        double valor = 0;

        try
        {
            valor = Double.parseDouble(entrada);
        }
        //Disparando erro
        catch (NumberFormatException e)
        {
            return new ResultadoValidacao(false,"O valor inserido não é um número!");
        }
        //----------------------------------//--------------------------------
        //c)Validando se o preço é maior que zero
        if(valor <= 0)
        {
            return new ResultadoValidacao(false,"O valor inserido não é um preço válido!");
        }
        //----------------------------------------------------------------------------

        //2)Retorno para preço válido
        return  new ResultadoValidacao(true,"");
    }
}
