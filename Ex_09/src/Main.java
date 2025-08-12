 /*  Contexto: Um banco quer proteger os dados das contas dos clientes.

Enunciado:

Crie a classe ContaBancaria com:

titular (String)
saldo (double, privado)
Métodos:

depositar(double valor)
sacar(double valor) (somente se houver saldo suficiente)
exibirSaldo()
Teste no main() criando uma conta e realizando operações.  */
//#########################################################################################

//Importações
//1)Importando o pacote moldes
 import Moldes.*;
 //============================================

 public class Main
 {
     public static void main(String[] args)
     {
         //Etapas
         //1)Instanciando a classe
         ContaBancaria conta = new ContaBancaria("João", 10000);
         //----------------------------------------------------------------------------

         //2)Realizando um depósito
         conta.depositar(5000);
         //----------------------------------------------------------------------------

         //3)Exibindo dados
         System.out.println(conta.exibirSaldo());
         //----------------------------------------------------------------------------

         //4)Realizando um saque
         conta.sacar(10000);
         //----------------------------------------------------------------------------

         //5)Exibindo dados
         System.out.println(conta.exibirSaldo());
     }
 }
