 /*  Contexto: Uma loja quer armazenar registros de compras.

Enunciado:

Peça ao usuário para cadastrar 3 compras com: produto, quantidade e preço unitário.

Salve os dados em um arquivo compras.txt.
Leia o arquivo e exiba as compras registradas. */
//#########################################################################################

//1)Importações
//a)Importando o scanner
 import  java.util.Scanner;
//----------------------------------//--------------------------------
//b)Para usar tudo dentro do pacote utilidades
 import Utilidades.MetodosValidacao;
//----------------------------------//--------------------------------
//c)Para usar tudo dentro do pacote moldes
 import Moldes.*;
//----------------------------------//--------------------------------
//d)Para conseguir passar uma função como parâmetro de um método
 import java.util.function.Function;
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
     //============================================

     //Código principal
     public static void main(String[] args)
     {
         //Etapas
         //1)Pedindo e Validando os dados
         // a)nome do arquivo
         String nomeArquivo = pedirEConferirEntrada("Digite aqui o nome do arquivo que deseja criar: ", MetodosValidacao::validarNomeArquivoOuPasta);
         //----------------------------------//--------------------------------

         //b)o nome da pasta
         String nomePasta = pedirEConferirEntrada("Digite aqui o nome da pasta que deseja criar: ", MetodosValidacao::validarNomeArquivoOuPasta);
         //----------------------------------//--------------------------------

         //c)o produto
         String produto = pedirEConferirEntrada("Digite aqui o nome do produto: ", MetodosValidacao::validarProduto);
         //----------------------------------//--------------------------------

         //d)a quantidade
         String quantidade = pedirEConferirEntrada("Digite aqui a quantidade: ", MetodosValidacao::validarQuantidade);
         //----------------------------------//--------------------------------

         //e)o preco
         String preco = pedirEConferirEntrada("Digite aqui a preço: ", MetodosValidacao::validarPreco);
         //----------------------------------------------------------------------------

         //2)Instanciando as classes
         //a)Instanciando arquivo
         Arquivo arquivo = new Arquivo(nomeArquivo, nomePasta);
         //----------------------------------//--------------------------------

         //b)Instanciando compra
         Compra compra = new Compra(produto, quantidade, preco);
         //----------------------------------------------------------------------------

         //3)Criando o arquivo
         //a)
         String criandoArquivo = arquivo.criarArquivo();
         //----------------------------------//--------------------------------
         //b)Fazendo o retorno
         System.out.println(criandoArquivo);
         //----------------------------------------------------------------------------

         //4)Escrevendo no arquivo
         String escrevendoNoArquivo = arquivo.escreverNoArquivo(compra.montarExibicao());
         //----------------------------------//--------------------------------
         //b)Fazendo o retorno
         System.out.println(escrevendoNoArquivo);
         //----------------------------------------------------------------------------

         //5)Lendo o arquivo
         String lendoArquivo = arquivo.lerArquivo();
         //----------------------------------//--------------------------------
         //b)Fazendo o retorno
         System.out.println(lendoArquivo);
         //============================================

         //6)Fechando o scanner
         scan.close();
     }
 }