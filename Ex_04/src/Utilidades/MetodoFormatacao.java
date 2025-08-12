package Utilidades;
//============================================

//Importando as classes NumberFormat e Locale para deixar os números formatados
import java.text.NumberFormat;
import java.util.Locale;
//============================================

public class MetodoFormatacao
{
    //)Método para formatar os valores que irei usar no método de montar saida
    public static String  formatarValor(double valor)
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
        //2)Formatando o valor
        String valorFormatado = real.format(valor);

        return valorFormatado;
    }
}
