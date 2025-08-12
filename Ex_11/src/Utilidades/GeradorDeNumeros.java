package Utilidades;

public class GeradorDeNumeros
{
    //Criando um método que retorna um array com 6 números
    public static int[] gerarNumeros(int quantidade) {
        //Vou criar um array de int para preencher com as entradas convertidas em int de uma vez
        int[] numeros = new int[6];

        //Vou fazer um laço para pedir todas as 6 numeros
        while(quantidade > 0)
        {
            //Decrementando
            --quantidade;

            //Gerando um numero aleatório entre de 1 a 60
            int numero = (int) Math.ceil(Math.random() * 60);

            //Adicionando o número gerado  ao array
            numeros[quantidade] = numero;
        }
        //Retornando o array
        return numeros;
    }
}
