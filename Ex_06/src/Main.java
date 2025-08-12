/*  Contexto: Você está desenvolvendo um sistema para gerenciar veículos em uma locadora.

Enunciado:

Crie uma classe Veiculo com os seguintes atributos:

Placa (String)
Modelo (String)
Ano de fabricação (int)
Quilometragem (double)
Implemente os seguintes métodos:

exibirDetalhes() - Exibe os dados do veículo.
registrarViagem(double km) - Adiciona km ao total.
No main(), crie dois veículos com dados fictícios e registre viagens para testar o sistema.  */
//#########################################################################################
//----------------------------------//--------------------------------
//Importações
//1)
//============================================

import Moldes.Veiculos;

public class Main
{
    //Código principal
    public static void main(String[] args)
    {
        //Etapas
        //1)Testando a classe
        //A)Ferrari
        //a)Instanciando
        Veiculos ferrari = new Veiculos("SFDF-2334", "Ferrari", 2010, 100);
        //----------------------------------//--------------------------------
        //b)Exibindo
        System.out.println(ferrari.exibirDetalhes());
        //----------------------------------//--------------------------------
        //c)Alterando a quilometragem
        ferrari.registrarViagem(45);
        //----------------------------------//--------------------------------
        //d)Exibindo após alteração
        System.out.println(ferrari.exibirDetalhes());
        //----------------------------------///--------------------------------

        //B)Doblô
        //a)Instanciando
        Veiculos doblo = new Veiculos("FERG-1234", "Doblô", 2001, 1000);
        //----------------------------------//--------------------------------
        //b)Exibindo
        System.out.println(doblo.exibirDetalhes());
        //----------------------------------//--------------------------------
        //c)Alterando a quilometragem
        doblo.registrarViagem(700);
        //----------------------------------//--------------------------------
        //d)Exibindo após alteração
        System.out.println(doblo.exibirDetalhes());
    }

}
