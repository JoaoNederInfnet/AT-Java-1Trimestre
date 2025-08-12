/*  Enunciado:
Crie um programa que:

Solicite ao usuário seu nome e uma senha.
A senha deve:
Ter no mínimo 8 caracteres.
Conter pelo menos uma letra maiúscula, um número e um caractere especial (@, #, $, etc.).
Caso a senha seja inválida, o programa deve informar o erro específico e solicitar uma nova tentativa.*/
//#########################################################################################

//1)Importações
//a)Importando o scanner
import  java.util.Scanner;
//----------------------------------//--------------------------------
//b)Para usar a classe ResultadoValidacao
import  Moldes.ResultadoValidacao;
import Utilidades.MetodosValidacao;
//----------------------------------//--------------------------------
//c)Para usar os métodos da classe MetodosValidacao diretamente
import static Utilidades.MetodosValidacao.*;
//----------------------------------//--------------------------------
//d)Para passar métodos como parâmetro
import java.util.function.Function;
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
    //============================================

    //Código principal
    public static void main(String[] args)
    {
        //Etapas
        //1)Solicitando e retornando o nome do usuário
        String nome = pedirEConferirEntrada("Digite aqui o seu nome: ", MetodosValidacao::validarNome);
        //----------------------------------------------------------------------------

        //2)Solicitando e retornando a senha do usuário
        String senha = pedirEConferirEntrada("Digite aqui a sua senha: ", MetodosValidacao::validarSenha);
        //----------------------------------------------------------------------------

        //3)Fazendo a saída
        System.out.print("Login realizado com sucesso. Bem vindo " + nome + "!");
        //============================================

        //5)Fechando o scanner
        scan.close();
    }
}
