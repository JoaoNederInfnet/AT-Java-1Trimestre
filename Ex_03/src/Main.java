/*  Contexto: Você precisa calcular o imposto de renda de uma pessoa com base no seu salário anual.

Enunciado:

Crie um programa que:

Peça ao usuário seu nome e seu salário mensal.
Aplique a seguinte tabela:
Até R$ 22.847,76 → Isento
De R$ 22.847,77 a R$ 33.919,80 → 7,5%
De R$ 33.919,81 a R$ 45.012,60 → 15%
Acima de R$ 45.012,61 → 27,5%
O programa deve calcular e exibir o valor do imposto e o salário líquido.*/
//#########################################################################################

//1)Importações
//a)Importando o scanner
import Moldes.ResultadoValidacao;
import Utilidades.MetodosValidacao;

import java.util.Scanner;
import java.util.function.Function;
//----------------------------------//--------------------------------
//b)Importanto a classe MetodoSalario
import static Utilidades.MetodosSalario.*;
import static Utilidades.MetodosValidacao.*;
//============================================

public class Main
{
    //Preparações
    //1)Abrindo o scanner
    static Scanner scan = new Scanner(System.in);
    //============================================

    //Métodos Utilitários (irei chamar em outros métodos)
    //1)Para solicitar as entradas ao usuário
    public static String pedirEntrada(String msg) {
        //Exibindo msg
        System.out.print(msg);

        //Variável entrada
        String entrada = scan.nextLine().trim();

        //Retornando a entrada
        return entrada;
    }
    //----------------------------------------------------------------------------

    //Métodos principais (irei chamar no código principal)
    //1))Para perdir e validar as entradas até que sejam válidas
    public static String pedirEConferirEntrada(String msg, Function<String, ResultadoValidacao> metodoValidacao) {
        //Criando variáveis para usar no controle do loop
        //a)Para o resultado e a mensagem correspondente
        ResultadoValidacao resultadoValidacao;
        //----------------------------------//--------------------------------
        //b)Para armazenar a entrada e retornar quando for válida
        String entrada;

        //Laço para pedir a entrada e validar até ser válido
        do {
            entrada = pedirEntrada(msg);

            resultadoValidacao = metodoValidacao.apply(entrada);

            //Conferindo se errou
            if (!resultadoValidacao.isValido()) {
                //Mensagem de erro
                System.out.println(resultadoValidacao.getMsg());
            }

        } while (!resultadoValidacao.isValido());

        //Retornando
        return entrada;
    }
    //----------------------------------------------------------------------------

    //2)Para montar a saida
    public static String montarSaida(double salarioAnual, String aliquota,double valorImposto, double salarioAnualLiquido)
    {
        //Convertendo os valores no formato brasileiro antes de montar a saída
        String[] valoresFormatados = formatarValores(salarioAnual, salarioAnualLiquido, valorImposto);
        //----------------------------------------------------------------------------
        //Montando a saída para cada caso
        String saida = "";

        if(aliquota == "0%")
        {
            saida = ("Seu salário anual: " + valoresFormatados[0] + "\nVocê está isento de impostos!" + "\nImposto total a pagar: " + valoresFormatados[2] + "\nSeu salário anual líquido: " + valoresFormatados[1]);
        }
        else
        {
            saida = ("Seu salário anual: " + valoresFormatados[0] + "\nA sua alíquota do imposto de renda é de " + aliquota + "\nImposto total a pagar: " + valoresFormatados[2] + "\nSeu salário anual líquido: " + valoresFormatados[1]);
        }
        //Retornando a mensagem de saída
        return saida;
    }
    //============================================

    //Código principal
    public static void main(String[] args)
    {
        //Etapas
        //1)Pedindo e validando o nome
        String nome = pedirEConferirEntrada("Digite aqui o seu nome: ", MetodosValidacao::validarNome);
        //----------------------------------------------------------------------------

        //2)Pedindo e validando
        String salarioMensal = pedirEConferirEntrada("Digite aqui o valor do seu salário mensal: ", MetodosValidacao::validarSalario);
        //----------------------------------------------------------------------------

        //3)Convertendo o salario salário para o formato double caso seja válido
        double salario = converterSalarioMensal(salarioMensal);
        //----------------------------------------------------------------------------

        //4)Calciulando o valor do salarioAnual
        double salarioAnual = calcularSalarioAnual(salario);
        //----------------------------------------------------------------------------

        //5)Recebendo o valor da alíquota correspondente ao salário anual
        String aliquota = retornarAliquota(salarioAnual);
        //----------------------------------------------------------------------------

        //6)Calculando o valor do imposto sobre o salário
        double imposto = calcularImposto(salarioAnual, aliquota);
        //----------------------------------------------------------------------------

        //7)Calculando o salario liquido
        double salarioLiquido = calcularSalarioLiquido(salarioAnual, imposto);
        //----------------------------------------------------------------------------

        //8)Montando a saída
        System.out.print(montarSaida(salarioAnual, aliquota, imposto, salarioLiquido));
        //============================================

        //9)Fechando o scanner
        scan.close();
    }
}
