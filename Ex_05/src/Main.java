/*  Crie um programa em Java que simule um script CGI, imprimindo os headers HTTP necessários e uma saudação personalizada no corpo da resposta. O programa não precisa rodar em um servidor, apenas ser executado diretamente na linha de comando.

Requisitos do programa:

O programa deve imprimir os headers necessários para uma resposta HTTP válida.
O header obrigatório Content-Type: text/html deve ser incluído.
Deve haver uma linha em branco entre os headers e o corpo da resposta.
No corpo da resposta, o programa deve exibir a mensagem:
Olá, Terráqueos!
O código deve ser executado via linha de comando e imprimir a resposta simulando a saída de um CGI.
Saída esperada do programa (quando executado na linha de comando):

Content-Type: text/html

<html>
<head><title>Saudação CGI</title></head>
<body>
<h1>Olá, Terráqueos!</h1>
</body>
</html>
Dicas para Implementação:

Utilize System.out.println() para imprimir os headers HTTP antes de qualquer outro conteúdo.
Lembre-se de incluir uma linha em branco entre os headers e o conteúdo da página.
O corpo da resposta deve estar formatado em HTML para que o navegador consiga interpretá-lo corretamente.  */
//#########################################################################################


public class Main
{
    //Código principal
    public static void main(String[] args)
    {
        //Etapas
        //Imprimindo a mensagem
        System.out.print(
        "Content-Type: text/html\n" +
        "\n" +
        "<html>\n" +
        "<head><title>Saudação CGI</title></head>\n" +
        "<body>\n" +
        "<h1>Olá, Terráqueos!</h1>\n" +
        "</body>\n" +
        "</html>\n");
        //----------------------------------------------------------------------------
    }

}
