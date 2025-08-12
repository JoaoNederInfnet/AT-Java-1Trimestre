package Moldes;
//============================================

//Importações
import static Utilidades.MetodoFormatacao.*;

public class Emprestimo
{
    //1)Atributos
    //a)Para o valor do nome
    private String nome;
    //----------------------------------//--------------------------------
    //b)Para o valor do empréstimo
    private double emprestimo;
    //----------------------------------//--------------------------------
    //c)para a quantidade de parcelas do empréstimo
    private int  parcelas;
    //----------------------------------------------------------------------------
    //2)Getters e Setters
    //a)nome
    public String getNome() {return nome;}
    //----------------------------------//--------------------------------
    //b)emprestimo
    public double getEmprestimo()
    {
        return emprestimo;
    }
    //----------------------------------//--------------------------------
    //c)parcelas
    public double getParcelas()
    {
        return parcelas;
    }
    //----------------------------------------------------------------------------
    //3)Construtor
    public Emprestimo(String nome, String emprestimo, String parcelas)
    {
       this.nome = nome;

       this.emprestimo = converterEmprestimo(emprestimo);

       this.parcelas = converterParcelas(parcelas);
    }
    //----------------------------------------------------------------------------
    //4)Métodos internos (uso dentro de outro método dessa classe)
    //a)Para converter o valor do emprestimo para double
    public static double converterEmprestimo(String emprestimo)
    {
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = emprestimo.replace("." , "").replace("," , ".");

        //Convertendo
        //Primeiro declaro double
        double emprestimoDouble = Double.parseDouble(entrada);

        return emprestimoDouble;
    }
    //----------------------------------//--------------------------------
    //b)Para converter o valor das parcelas para int
    public static int converterParcelas(String parcelas)
    {
        //Para o usuário conseguir inserir valores com vírgula
        String entrada = parcelas.replace("." , "").replace("," , ".");

        //Convertendo
        //Primeiro declaro int
        int parcelasInt = Integer.parseInt(entrada);

        return parcelasInt;
    }
    //-----------------------------------------------------------------------------
    //5)Métodos externos (irei usar no Main)
    //a)Para calcular o valor total a ser pago
    public double calcularValorTotal()
    {
        double valorTotal = emprestimo * (1 + 0.03 * parcelas);

        return valorTotal;
    }
    //----------------------------------//--------------------------------
    //b)// Para calcular o valor da parcela mensal
        public  double calcularValorParcelaMensal(double valorTotal)
        {
            //1)Calculando o valor da parcela mensal
            double parcelaMensal = valorTotal / parcelas;

            return parcelaMensal;
        }
    //----------------------------------//--------------------------------
    //c)Para formatar o valor do empréstimo
    public String formatarEmprestimo()
    {
        String formatado = formatarValor(emprestimo);

        return formatado;
    }
    //----------------------------------//--------------------------------
    //d)Para formatar o valor da parcela mensal
    public String formatarParcelaMensal(double parcelaMensal)
    {
        String formatado = formatarValor(parcelaMensal);

        return formatado;
    }
    //----------------------------------//--------------------------------
    //e)Para formatar o valorTotal
    public String formatarValorTotal(double valorTotal)
    {
        String formatado = formatarValor(valorTotal);

        return formatado;
    }
}
