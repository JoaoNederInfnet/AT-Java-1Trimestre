package Moldes;
//============================================

//Importacoes
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
//============================================

public class Arquivo
{
    //1)Atributos
    //a)Nome do Arquivo
    private String nomeArquivo;
    //----------------------------------//--------------------------------
    //b)Nome da subpasta
    private String nomePasta;
    //----------------------------------//--------------------------------
    //c)Para o caminho do arquivo
    private Path caminhoDoArquivo;
    //----------------------------------//--------------------------------
    //d)Para usar o caminho para criar o arquivo
    private File arquivoNaPasta;
    //============================================

    //2)Setters e Getters
    //a)Nome do Arquivo
    public String getNomeArquivo()
    {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo)
    {
        this.nomeArquivo = nomeArquivo + ".txt";
    }
    //----------------------------------//--------------------------------
    //b)Nome da subpasta
    public String getNomePasta()
    {
        return nomePasta;
    }

    public void setNomePasta(String nomePasta)
    {
        this.nomePasta = nomePasta;
    }
    //----------------------------------//--------------------------------
    //c)Para o caminho do arquivo
    public Path getCaminhoDoArquivo()
    {
        return  caminhoDoArquivo;
    }

    public void setCaminhoDoArquivo(String nomePasta, String nomeArquivo)
    {
        this.caminhoDoArquivo = Paths.get(nomePasta, nomeArquivo);
    }
    //----------------------------------//--------------------------------
    //d)Para usar o caminho para criar o arquivo
    public File getArquivoNaPasta()
    {
        return arquivoNaPasta;
    }

    public void setArquivoNaPasta(Path caminhoDoArquivo)
    {
        this.arquivoNaPasta = caminhoDoArquivo.toFile();
    }
    //============================================

    //3)Construtor
    public Arquivo(String nomeArquivo, String nomePasta)
    {
        setNomeArquivo(nomeArquivo);
        setNomePasta(nomePasta);
        setCaminhoDoArquivo(getNomePasta(), getNomeArquivo());
        setArquivoNaPasta(getCaminhoDoArquivo());
    }
    //============================================

    //4)Métodos
    //a)Para criar o arquivo
    public String criarArquivo()
    {
        //Criando uma string para armazenar o retorno
        String retorno = "";

        //Tentando criar/ o arquivo
        try
        {
            //Garantindo que a pasta exista
            Files.createDirectories(caminhoDoArquivo.getParent());

            //Caso o arquivo não esteja na pasta
            if(arquivoNaPasta.createNewFile())
            {
                retorno = "Arquivo \"" + nomeArquivo + "\" criado na pasta \"" + nomePasta + " com sucesso!" + "\n" + "Caminho para a pasta do arquivo: " + arquivoNaPasta.getAbsolutePath();
            }
              //Caso o arquivo já esteja na pasta
            else
            {
                retorno = "O arquivo \"" + nomeArquivo + "\" já havia sido criado na pasta  \"" + nomePasta + "\" com sucesso!" + "\n" + "Caminho para a pasta do arquivo: " + arquivoNaPasta.getAbsolutePath();
            }
        }
        //Caso ocorra algum erro
        catch(IOException ex)
        {
          retorno = "O arquivo \"" + nomeArquivo + "\" não foi criado na pasta  \"" + nomePasta + "\" com sucesso!" + "\n" + "Leia o motivo da falha e tente novamente!" + "\n" + "Motivo da falha na criação do arquivo:\n" + ex.getMessage();
        }
        //Retorno
        return retorno + "\n----------------------------------------------------------------";
    }
    //----------------------------------//--------------------------------

    //b)Para escrever no arquivo sem sobescrever o que estava escrito antes
    public String escreverNoArquivo(String compra)
    {
        //Criando uma string para armazenar o retorno
        String retorno = "";

        //Checando se o arquivo existe
        if(!Files.exists(caminhoDoArquivo))
        {
            retorno =  "O arquivo \"" + nomeArquivo + "\" não foi encontrado!";
        }
          else
        {
            //Tentando escrever algo no arquivo
            try
            {
                //Para adicionar uma quebra de linha na compra, para que a próxima compra seja escrita na próxima linha
                String linha = compra + System.lineSeparator();

                //Escrevendo
                Files.write(caminhoDoArquivo, linha.getBytes(), StandardOpenOption.APPEND);

               //Retorno para sucesso
                retorno = "Compra adicionada ao arquivo com sucesso!";
            }
            //Caso ocorra algum erro
            catch(IOException ex)
            {
                retorno = "Não foi possível adicionar a compra ao arquivo  \"" + nomeArquivo + "\"!\n" + "Leia o motivo da falha e tente novamente!" + "\n" + "Motivo da falha:\n" + ex.getMessage();
            }
        }
        return retorno + "\n----------------------------------------------------------------";
    }
    //----------------------------------//--------------------------------

    //c)Para ler as linhas do arquivo
    public String lerArquivo()
    {
       //Tentando ler  as linhas do arquivo
        try
        {
            //Criando uma lista e colocando o conteúdo de cada linha dentro dela
            List<String> linhas = Files.readAllLines(caminhoDoArquivo);

            //Caso o arquivo não possua nenhum conteúdo
            if(linhas.isEmpty())
            {
                return "O arquivo \"" + nomeArquivo + "\" está vazio!" + "\n----------------------------------------------------------------";
            }

            //Criando uma variável para colocar as linhas do arquivo
            String linhasArquivo = "";

            //Fazendo um laço for-each para ler cada linha e adicionar  ao linhasArquivo
            for(String linha : linhas)
            {
                linhasArquivo += linha + "\n";
            }
            //Retorno de sucesso
            return linhasArquivo;
        }
         //Caso dê erro
        catch(IOException ex)
        {
            return "Não foi possível ler o arquivo  \"" + nomeArquivo + "!\n"  + "Motivo da falha:\n" + ex.getMessage() + "\n----------------------------------------------------------------";
        }
    }
}