package Utilidades;
//============================================

//Importando regex
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//============================================

//Classe para cuidar de todos os métodos relacionados diretamente com a manipulação de regex
public class MetodosRegex
{
    //1)Métodos
    //a)Para fazer  o padrão do regex
    public static Pattern fazerPadraoRegex(String regex)
    {
        Pattern padraoRegex = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);

        return padraoRegex;
    }
    //----------------------------------//--------------------------------
    //b)Para fazer o matching do regex com as entradas
    public static Matcher fazerMatching(Pattern padraoRegex, String entrada)
    {
        Matcher combinacao = padraoRegex.matcher(entrada);

        return combinacao;
    }
    //----------------------------------//--------------------------------
    //c)Para conferir o matching
    public static boolean conferirMatching(String regex, String entrada)
    {
        //1)Chamando o método para fazer o padrão específico
        Pattern padraoRegex = fazerPadraoRegex(regex);
        //----------------------------------------------------------------------------

        //2)Chamando o método para fazer o matching do padrão e da entrada
        Matcher combinacao = fazerMatching(padraoRegex, entrada);
        //----------------------------------------------------------------------------

        //3)Conferindo
        if(combinacao.find())
        {
            //Caso haja correspondência
            return true;
        }

        //Caso não haja correspondência
        return false;
    }
}
