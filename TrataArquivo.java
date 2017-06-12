import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TrataArquivo{

    public void lerArquivo(String pathName, String nomeArquivo){
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(pathName.concat(nomeArquivo)));
            while(arquivo.ready()){
                String linha = arquivo.readLine();
                //listaCidades.add(linha);
            }
            arquivo.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public List <String> lerArquivoLista(String pathName, String nomeArquivo){
        List <String> listaCidades = new ArrayList<String>();
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(pathName.concat(nomeArquivo)));
            while(arquivo.ready()){
                String linha = arquivo.readLine();
                listaCidades.add(linha);
            }
            arquivo.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return listaCidades;
    }

    public void escreverArquivo(String pathName, String nomeArquivo, String texto){
        try{
            FileWriter arq = new FileWriter(pathName.concat(nomeArquivo));
            BufferedWriter bw = new BufferedWriter(arq);
            if (bw != null){
                bw.write( texto);
                bw.newLine();
            }

            bw.close();
            arq.close();

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void gerarArquivo(String pathName, String nomeArquivo){
        File file = new File(pathName.concat(nomeArquivo));
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}


