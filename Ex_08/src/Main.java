/*  Contexto: Uma empresa precisa de um sistema para calcular salários de diferentes tipos de funcionários.

Enunciado:

Crie a classe Funcionario com: nome, salário base e crie duas subclasses:

Gerente: Salário recebe um bônus de 20%.
Estagiario: Salário tem um desconto de 10%.
No main(), crie um gerente e um estagiário, e exiba os salários finais. */
//#########################################################################################

//Importações
//1)Para conseguir usar tudo dentro do pacote Moldes
import Moldes.*;
//============================================

public class Main
{
    public static void main(String[] args)
    {
        //Etapas
        //1)Gerente
        //a)Instanciando
        Gerente gerente = new Gerente("Bololo", 1000);
        //----------------------------------//--------------------------------

        //b)Exibindo as informações
        System.out.println(gerente.montarExibicao());
        //----------------------------------------------------------------------------

        //2)Estagiario
        //a)Instanciando
        Estagiario estagiario = new Estagiario("Haha", 1000);
        //----------------------------------//--------------------------------

        //b)Exibindo as informações
        System.out.println(estagiario.montarExibicao());
        //============================================
    }
}
