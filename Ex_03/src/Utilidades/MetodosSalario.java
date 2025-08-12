package Utilidades;
//============================================

//1)Importacoes
//a)Importando a classe ResultadoValidacao
//----------------------------------//--------------------------------
//2)Importando as classes NumberFormat e Locale para deixar os números formatados
import java.text.NumberFormat;
import java.util.Locale;
//============================================

//Classe para  cuidar de todos os métodos relacionados a manipulação do dado salário
public class MetodosSalario
{
    //1)Para converter o salário para o formato number caso seja válido
    public static double converterSalarioMensal(String salarioMensal)
    {
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = salarioMensal.replace("." , "").replace("," , ".");

        //Convertendo
        //Primeiro declaro double
        double salario = Double.parseDouble(entrada);

        return salario;
    }
    //----------------------------------------------------------------------------
    //2)Método para retornar o valor do sálario anual
    public static double calcularSalarioAnual(double salario)
    {
        double salarioAnual = salario * 12;

        return salarioAnual;
    }
    //----------------------------------------------------------------------------
    //3)Método para retornar o valor da alíquota correspondente ao salário anual
    public static String retornarAliquota(double salarioAnual)
    {
        //1)Definindo uma varíavel a ser preenchida com a aliquota
        String aliquota = "";
        //----------------------------------------------------------------------------
        //2Verificando caso a caso
        //a)Até R$ 22.847,76 → Isento
        if(salarioAnual <= 22847.76)
        {
            aliquota = "0%";
        }
        //----------------------------------//--------------------------------
        //b)De R$ 22.847,77 a R$ 33.919,80 → 7,5%
        else if(salarioAnual >= 22847.77  && salarioAnual <= 33919.80)
        {
            aliquota = "7,5%";
        }
        //----------------------------------//--------------------------------
        //c)De R$ 33.919,81 a R$ 45.012,60 → 15%
        else if(salarioAnual >= 33919.81 && salarioAnual <= 45012.60)
        {
            aliquota = "15%";
        }
        //----------------------------------//--------------------------------
        //d)Acima de R$ 45.012,61 → 27,5%
        else if(salarioAnual > 45012.61)
        {
            aliquota = "27,5%";
        }
        //----------------------------------------------------------------------------
        //3)Retornando a aliquota
        return aliquota;
    }
    //----------------------------------------------------------------------------
    //4)Método para calcular o valor do imposto sobre o salário
    public static double calcularImposto (double salarioAnual, String aliquota)
    {
        //Definindo uma variavel a ser preenchida com o valor do imposto
        double valorImposto = 0;

        //Fazendo um calculo para cada aliquota
        switch(aliquota)
        {
            case "0%" : valorImposto = 0;
                break;

            case "7,5%" : valorImposto = salarioAnual *  (7.5/100) ;
                break;

            case "15%" : valorImposto = salarioAnual *  (15.0/100) ;
                break;

            case "27,5%" : valorImposto = salarioAnual * (27.5/100) ;
                break;
        }
        return valorImposto;
    }
    //----------------------------------------------------------------------------
    //5)Para calcular o salario liquido
    public static double calcularSalarioLiquido(double salarioAnual,  double valorImposto)
    {
        //Fazendo o cálculo
        double salarioLiquido = salarioAnual - valorImposto;

        //Retornando o salario liquido
        return salarioLiquido;
    }
    //----------------------------------------------------------------------------
    //6)Método para formatar os valores que irei usar no método de montar saida
    public static String[] formatarValores(double salarioAnual, double salarioLiquido, double valorImposto)
    {
        //1)Preparações para formatar
        //Definindo o locale como o brasil e NumberFormat para o real
        Locale brasil = new Locale("pt" , "BR");
        NumberFormat real = NumberFormat.getCurrencyInstance(brasil);
        //Para ter no máximo 2 casas decimais
        real.setMaximumFractionDigits(2);
        //Para ter no máximo 2 casas decimais
        real.setMinimumFractionDigits(2);
        //----------------------------------------------------------------------------
        //2)Formatando os valores
        //a)
        String salarioAnualFormatado = real.format(salarioAnual);
        //----------------------------------//--------------------------------
        //b
        String salarioLiquidoFormatado = real.format(salarioLiquido);
        //----------------------------------//--------------------------------
        //c)
        String valorImpostoFormatado = real.format(valorImposto);
        //----------------------------------------------------------------------------
        //3)
        String[] valoresFormatados =
        {
        salarioAnualFormatado,
        salarioLiquidoFormatado,
        valorImpostoFormatado
        };
        //3)Retornando os valores formatados
        return valoresFormatados;
    }
}
