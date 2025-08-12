/*   Crie a classe Aluno com os atributos: nome, matrícula e três notas. Implemente os métodos:

calcularMedia() → Retorna a média das notas.
verificarAprovacao() → Exibe se o aluno foi aprovado (média >= 7) ou reprovado.
No main(), peça os dados do aluno e exiba sua situação final. */
//#########################################################################################

//1)Importações
//a)Importando o scanner
import  java.util.Scanner;
//----------------------------------//--------------------------------
//b)Para usar tudo dentro do pacote utilidades
import Utilidades.*;
//----------------------------------//--------------------------------
//c)Para usar tudo dentro do pacote moldes
import Moldes.*;
//----------------------------------//--------------------------------
//d)Para conseguir passar uma função como parâmetro de um método
import java.util.function.Function;
//============================================

//============================================
public class Main {
    //Preparações
    //1)Abrindo o scanner
    static Scanner scan = new Scanner(System.in);
    //----------------------------------------------------------------------------

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

    //2)Para pedir as notas
    public static double[] pedirNotas(String msg, int vezes) {
        //Vou criar um array de double para preencher com as entradas convertidas em double de uma vez
        double[] notas = new double[3];

        //Vou fazer um laço para pedir todas as 3 notas
        while (vezes < 3) {
            String nota = pedirEConferirEntrada(msg + (vezes + 1) + ": ", MetodosValidacao::validarNota);

            //Para permitir que o usuário insira números com vírgulas
            nota = nota.replace("," , ".");

            //Adicionando a nota  convertida em double ao array
            notas[vezes] = Double.parseDouble(nota);

            //Incrementando vezes
            ++vezes;
        }
        //Retornando o array
        return notas;
    }

    //============================================
    //Código principal
    public static void main(String[] args) {
        //Etapas
        //1)Pedindo e validando o nome do usuário
        String nome = pedirEConferirEntrada("Digite aqui o seu nome: ", MetodosValidacao::validarNome);
        //----------------------------------------------------------------------------

        //2)Pedindo e validando a matricula
        String matricula = pedirEConferirEntrada("Digite aqui a sua matricula (precisa ter 5 caracteres, ex: 12EDr): ", MetodosValidacao::validarMatricula);
        //----------------------------------------------------------------------------

        //3)Pedindo as notas
        //Para passar como parametro
        int vezes = 0;

        double[] notas = pedirNotas("Digite aqui a sua nota ", vezes);
        //----------------------------------------------------------------------------

        //4)Instanciando a classe aluno com os dados de entrada
        Aluno aluno = new Aluno(nome, matricula, notas);
        //----------------------------------------------------------------------------

        //5)Obtendo a média
        double media = aluno.calcularMedia();
        //----------------------------------------------------------------------------

        //6)Exibindo os dados com a situação
        System.out.print(aluno.montarExibicao(media));
        //============================================

        //7)Fechando o scanner
        scan.close();
    }
}
