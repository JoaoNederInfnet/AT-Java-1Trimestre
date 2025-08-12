
 /* Contexto:Você está desenvolvendo um sistema simples de troca de mensagens que será utilizado em um terminal de linha de comando. Dois usuários poderão enviar mensagens alternadamente e visualizar as mensagens enviadas. O objetivo é permitir a comunicação entre os usuários de forma interativa, sem interface gráfica.
Enunciado:
Crie um programa em Java que permita que dois usuários troquem mensagens alternadamente através da linha de comando.
Regras do Programa:
* O programa deve iniciar solicitando os nomes dos dois usuários.
* Cada usuário poderá enviar até 5 mensagens cada (total de 10 mensagens no sistema).
* As mensagens devem ser armazenadas em um Array de Strings.
* O envio das mensagens deve ser feito alternadamente, ou seja, um usuário envia, depois o outro.
* Após as 5 mensagens de cada usuário, o programa deve exibir todas as mensagens trocadas e encerrar com uma mensagem de despedida.
Fluxo esperado da execução:
1. Solicitação dos nomes dos usuários:
2. Digite o nome do primeiro usuário: Alice
3. Digite o nome do segundo usuário: Bob
4.
5.
6. Troca de mensagens alternada na linha de comando:Alice, digite sua mensagem: Olá Bob, como você está?
7. Bob, digite sua mensagem: Oi Alice! Estou bem, e você?
8. Alice, digite sua mensagem: Estou ótima, obrigada por perguntar.
9. Bob, digite
10.         sua mensagem: Que bom! O que tem feito ultimamente?
11. ... (continua até 5 mensagens por usuário)
12. Exibição do histórico de mensagens:
13. ===== Histórico de Mensagens =====
14. Alice: Olá Bob, como você está?
15. Bob: Oi Alice! Estou bem, e você?
16. Alice: Estou ótima, obrigada por perguntar.
17. Bob: Que bom! O que tem feito ultimamente?
18. …
19.
20.
21. Mensagem final antes de encerrar o programa: Obrigado por utilizarem o sistema! Boa sorte para vocês! 🚀
Considerações:
* O programa solicita os nomes dos usuários corretamente.
* As mensagens são armazenadas e exibidas corretamente.
* O programa alterna corretamente entre os usuários a cada mensagem.
* O programa finaliza após 10 mensagens trocadas, exibindo o histórico e a mensagem de despedida.
Dicas para Implementação:
* Utilize um array de Strings de tamanho 10 para armazenar as mensagens.
* Use um loop para alternar os envios entre os usuários.
* Utilize a classe Scanner para capturar as mensagens digitadas.
* Certifique-se de exibir corretamente as mensagens ao final da execução.
  */
//#########################################################################################

//Importações
//1)Importando o scanner
 import java.util.Scanner;
 //
import Moldes.ResultadoValidacao;
//
 import Utilidades.MetodosValidacao;
//
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
        do
        {
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

    //2)Para pedir os numeros
    public static String[] pedirMensagens(String msg, String nomeA, String nomeB) {
        //Vou criar um array de String para preencher com as entradas convertidas em String de uma vez
        String[] mensagens = new String[10];

        //Variável de controle para preencher corretamente o array
        int posicao = 0;

        //Vou fazer um laço para pedir todas as 10 mensagens
        for(int vezes = 0; vezes < 5; ++vezes)
        {
            //1)Pedindo a mensagem do primeiro usuário
            String mensagem = pedirEConferirEntrada( nomeA + msg, MetodosValidacao::validarMensagem);

            //Adicionando a mensagem ao array
            mensagens[posicao++] = nomeA + ": " + mensagem;

            //2)Pedindo a mensagem do segundo usuário
            mensagem = pedirEConferirEntrada(nomeB + msg, MetodosValidacao::validarMensagem);

            //Adicionando a mensagem ao array
            mensagens[posicao++] = nomeB + ": " + mensagem;
        }
        //Retornando o array
        return mensagens;
    }
    //----------------------------------------------------------------------------

    //2)Para montar a exibição
    public static String montarSaida(String[] mensagens)
    {
        //Para preencher com as mensagens
        String saida = "===== Histórico de Mensagens =====" + "\n";

       for(int vezes = 0; vezes < mensagens.length; vezes++)
       {
           saida += mensagens[vezes] + "\n";
       }
       //Mensagem final
        saida += "Obrigado por utilizarem o sistema! Boa sorte para vocês! \uD83D\uDE80" ;

       //Retornando
        return saida;
    }
    //============================================

    //Código principal
    public static void main(String[] args)
    {
        //Etapas
        //1)Pedindo os nomes
        //a)
        String nomeA = pedirEConferirEntrada("Digite aqui o nome do primeiro usuário: ", MetodosValidacao::validarNome);
        //----------------------------------//--------------------------------
        //b)
        String nomeB = pedirEConferirEntrada("Digite aqui o nome do segundo usuário: ", MetodosValidacao::validarNome);
        //----------------------------------------------------------------------------

        //2)Pedindo as mensagens
        String[] mensagens = pedirMensagens(", digite sua mensagem: ", nomeA, nomeB);
        //----------------------------------------------------------------------------

        //4)Montando a saída
        String saida = montarSaida(mensagens);
        //----------------------------------------------------------------------------

        //5)Exibindo a saida
        System.out.println(saida);
    }

}
