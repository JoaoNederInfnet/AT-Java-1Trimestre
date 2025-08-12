package Utilidades;

//Classe para armazenar os padrões regex que irei usar
public class PadroesRegex
{
    //1)Atributos (regex)
    //a)Criando o regex para validar as nomes próprios
    public static String regexNomesProprios = "^[\\p{Lu}][\\p{Ll}]+$";
    //----------------------------------//--------------------------------
    //b)Para conferir se tem no mínimo 8 caracteres
    public static String regexQuantidade = "^.{8,}$";
    //----------------------------------//--------------------------------
    //c)Para letras maiúsculas
    public static String regexLetrasMaiusculas = "[\\p{Lu}]";
    //----------------------------------//--------------------------------
    //d)Para letras minusculas
    public static String regexLetrasMinusculas = "[\\p{Ll}]";
    //----------------------------------//--------------------------------
    //e)Para dígitos
    public static String regexDigitos = "[0-9]";
    //----------------------------------//--------------------------------
    //f)Para caracteres especiais
    public static String regexCaracteresEspeciais = "[^\\p{Lu}\\p{Ll}0-9\\s]";
}
