package Moldes;
//============================================


//Classe para criar um construtor que será usado para retornar o resultado da validação e a mensagem específica relacionada.
public class ResultadoValidacao
{
    //1)Atributos
    //a)para conferir o resultado da validação
    private boolean valido;
    //----------------------------------//--------------------------------
    //b)para receber a mensagem referente ao motivo do resultado da validação (caso retornre false)
    private String msg;
    //============================================

    //2)Getters
    //a)valido
    public boolean isValido()
    {
        return valido;
    }
    //----------------------------------//--------------------------------
    //b)msg
    public String getMsg()
    {
        return msg;
    }
    //============================================

    //3)Construtor
    public ResultadoValidacao(boolean valido, String msg)
    {
        this.valido = valido;
        this.msg = msg;
    }
    //============================================
}
