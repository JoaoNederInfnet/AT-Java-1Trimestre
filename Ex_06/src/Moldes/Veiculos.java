package Moldes;

/* Placa (String)
Modelo (String)
Ano de fabricação (int)
Quilometragem (double)
Implemente os seguintes métodos:

exibirDetalhes() - Exibe os dados do veículo.
registrarViagem(double km) - Adiciona km ao total.
No main(), crie dois veículos com dados fictícios e registre viagens para testar o sistema. */

public class Veiculos
{
    //Atributos
    //a)Placa
    private String placa;
    //----------------------------------//--------------------------------
    //b)Modelo
    private String modelo;
    //----------------------------------//--------------------------------
    //c)Ano de fabricação
    private int anoDeFabricacao;
    //----------------------------------//--------------------------------
    //d)Quilometragem
    private double quilometragem;
    //----------------------------------------------------------------------------

    //2)Getters
    //a)Placa
    public String getPlaca()
    {
        return placa;
    }
    //----------------------------------//--------------------------------
    //b)Modelo
    public String getModelo()
    {
        return modelo;
    }
    //----------------------------------//--------------------------------
    //c)Ano de fabricação
    public int getAnoDeFabricacao()
    {
        return anoDeFabricacao;
    }
    //----------------------------------//--------------------------------
    //d)Quilometragem
    public double getQuilometragem()
    {
        return quilometragem;
    }
    //----------------------------------------------------------------------------

    //3)Construtor
    public Veiculos(String placa, String modelo, int anoDeFabricacao, double quilometragem)
    {
        this. placa =  placa;
        this. modelo =  modelo;
        this. anoDeFabricacao =  anoDeFabricacao;
        this. quilometragem =  quilometragem;
    }
    //----------------------------------------------------------------------------

    //4)Métodos
    //a)
    public String exibirDetalhes()
    {
        return "Placa: " + placa + "\nModelo: " + modelo + "\nAno de Fabricação: " + anoDeFabricacao + "\nQuilometragem: " + quilometragem + "\n----------------------------------------------------------------------------";
    }
    //----------------------------------//--------------------------------
    //b)
    public void registrarViagem(double km)
    {
        quilometragem = km + quilometragem;
    }
}
