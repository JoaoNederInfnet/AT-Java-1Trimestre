package Moldes;

public class Compra
{
    //produto, quantidade e preço unitário.
    //1)Atributos
    //a)produto
    private String produto;
    //----------------------------------//--------------------------------
    //b)quantidade
    private int quantidade;
    //----------------------------------//--------------------------------
    //c)preco
    private double preco;
    //============================================

    //2)Getters e setters
    //a)valido
    public String getProduto()
    {
        return produto;
    }

    public void setProduto(String produto)
    {
        this.produto = produto;
    }
    //----------------------------------//--------------------------------
    //b)msg
    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(String quantidade)
    {
        this.quantidade = Integer.parseInt(quantidade);
    }
    //----------------------------------//--------------------------------
    //c)preco
    public double getPreco()
    {
        return preco;
    }

    public void setPreco(String preco)
    {
        this.preco = Double.parseDouble(preco.replace("," , ".").trim());
    }
    //============================================

    //3)Construtor
    public Compra (String produto, String quantidade, String preco)
    {
        setProduto(produto);
        setQuantidade(quantidade);
        setPreco(preco);
    }
    //============================================

    //4)Métodos
    //a)Para montar a exibição dos dados
    public String montarExibicao()
    {
        return "Produto: " + getProduto() + " | "  + "Quantidade: " + getQuantidade() + " | " + "Preco: " + getPreco();
    }
}
