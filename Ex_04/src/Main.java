/*  Contexto: Um banco deseja automatizar a simulação de empréstimos para clientes.

Enunciado:
Solicite o nome do cliente e o valor do empréstimo.
✔ Pergunte em quantas parcelas ele deseja pagar (mínimo 6, máximo 48).
✔ Calcule o juros mensal fixo de 3% e mostre:

O valor total pago.
O valor da parcela mensal.  */
//#########################################################################################

//1)Importações
//a)Importando o scanner
import java.util.Scanner;
import java.util.function.Function;
//----------------------------------//--------------------------------
import Moldes.ResultadoValidacao;
//----------------------------------//--------------------------------
import Moldes.Emprestimo;
import Utilidades.MetodosValidacao;
//----------------------------------//--------------------------------
import static Utilidades.MetodosValidacao.*;
//----------------------------------//--------------------------------



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
    public static String montarSaida(Emprestimo emprestimoX, double parcelaMensal, double valorTotal)
    {
       String saida = ("Parabéns " + emprestimoX.getNome() + ", você realizou um empréstimo de " + emprestimoX.formatarEmprestimo() + " parcelados de " + (int) emprestimoX.getParcelas() + " vezes!" + "\n" + "Com isso, o valor da parcela mensal, com juros, é de " + emprestimoX.formatarParcelaMensal(parcelaMensal) + ", o que configura um valor total de " + emprestimoX.formatarValorTotal(valorTotal) + ".");

       return saida;
    }
    //============================================
    //Código principal
    public static void main(String[] args)
    {
        //Etapas
        //1)Nome
        String nome = pedirEConferirEntrada("Digite o aqui o seu nome: ", MetodosValidacao::validarNome);
        //----------------------------------------------------------------------------

        //2)Emprestimo
        String emprestimo = pedirEConferirEntrada("Digite o aqui o valor do seu empréstimo: ", MetodosValidacao::validarEmprestimo);
        //----------------------------------------------------------------------------

        //3)Parcelas
        String parcelas = pedirEConferirEntrada("Digite aqui a quantidade de parcelas do empréstimo: ", MetodosValidacao::validarParcelas);
        //----------------------------------------------------------------------------

        //4)Criando um objeto emprestimoA com os valores de entrada
        Emprestimo emprestimoA = new Emprestimo (nome, emprestimo, parcelas);
        //----------------------------------------------------------------------------

        //5)Calculando ovalor total a ser pago
        double valorTotal = emprestimoA.calcularValorTotal();
        //----------------------------------------------------------------------------

        //6)Calculando o valor da parcelaMensal
        double parcelaMensal = emprestimoA.calcularValorParcelaMensal(valorTotal);
        //----------------------------------------------------------------------------

        //7)Montando e Realizando a saída
        System.out.print(montarSaida(emprestimoA, parcelaMensal, valorTotal));
        //============================================

        //)Fechando o scanner
        scan.close();
    }
}
