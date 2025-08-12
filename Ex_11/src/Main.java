 /*  Contexto: Você foi contratado para desenvolver um jogo de loteria simples.

Enunciado:

Gere 6 números aleatórios entre 1 e 60.
Peça ao usuário para inserir 6 números.
Compare os números e informe quantos acertos ele teve. */
//#########################################################################################
//----------------------------------//--------------------------------
//Importações
//1)Importando o scanner
 import java.util.Scanner;
 //----------------------------------//--------------------------------
 //2)
 import java.util.function.Function;
 //----------------------------------//--------------------------------
 //3)
import Utilidades.*;
//----------------------------------//--------------------------------
//4)
import Moldes.*;
//----------------------------------//--------------------------------
//5)
 import static Utilidades.GeradorDeNumeros.*;
 //----------------------------------//--------------------------------
 //6)
 import java.util.Arrays;
 //============================================

 public  class Main
 {
     //Preparações
     //1)Abrindo o scanner
    public static Scanner scan = new Scanner(System.in);
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

     //2)Para pedir os numeros
     public static int[] pedirNumeros(String msg, int vezes) {
         //Vou criar um array de int para preencher com as entradas convertidas em int de uma vez
         int[] numeros = new int[6];

         //Vou fazer um laço para pedir todas as 6 numeros
         while (vezes < 6)
         {
             String numero = pedirEConferirEntrada(msg + (vezes + 1) +": ", MetodosValidacao::validarNumero);

             //Para permitir que o usuário insira números com vírgulas
             numero = numero.replace("," , ".");

             //Adicionando o numero  convertida em int ao array
             numeros[vezes] = Integer.parseInt(numero);

             //Incrementando vezes
             ++vezes;
         }
         //Retornando o array
         return numeros;
     }
     //----------------------------------//--------------------------------
     //3)Para comparar os arrays
     public static int contarAcertos(int[] numeros, int[] numerosAleatorios)
     {
         //Declarando uma variável para modificar a cada acerto
         int acertos = 0;

         //Laço for para fazer com cada número de entrada
         for (int numerosEntrada : numeros)
         {
             //Laço for para fazer com cada numero dos números gerados
             for (int numeroSorteados : numerosAleatorios)
             {
                 //Comparando os números
                 if (numerosEntrada == numeroSorteados)
                 {
                     //Incrementando a variável com os acertos
                     acertos++;

                     //Para não comparar duplicadamente os números
                     break;
                 }
             }
         }
         //Retornando quantos acertos houveram
         return acertos;
     }
     //============================================

     //Código principal
     public static void main(String[] args)
     {
         //Etapas
         //1)Pedindo os numeros
         //Para passar como parametro
         int vezes = 0;

         int[] numeros = pedirNumeros("Digite aqui o seu número ", vezes);
         //----------------------------------------------------------------------------

         //2)Gerando os números aleatórios
         int[] numerosAleatorios = gerarNumeros(6);
         //----------------------------------------------------------------------------

         //3)Comparando
         int acertos = contarAcertos(numeros, numerosAleatorios);
         //----------------------------------------------------------------------------

         //4)Fazendo a saída
         System.out.println("Números sorteados: " + Arrays.toString(numerosAleatorios) + "\n" + "Números escolhidos por você: " + Arrays.toString(numeros) + "\n" + "Você acertou " + acertos + " dos seus palpites!");

         //============================================
         //5))Fechando o scanner
         scan.close();
     }
 }



