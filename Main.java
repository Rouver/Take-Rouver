import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        String pathName = "C:\\Take\\";
        String arquivoTrecho = "trecho.txt";
        String arquivoEncomenda = "encomenda.txt";
        String arquivoRota = "rota.txt";
        TrataArquivo arquivo = new TrataArquivo();
        List<String>listaEncomendas = arquivo.lerArquivoLista(pathName, arquivoEncomenda);
        List<String> listaArqTrecho = arquivo.lerArquivoLista(pathName, arquivoTrecho);
        List<Aresta> arestasAtual = new ArrayList<Aresta>();
        String rotaTexto = null;

        for (String trecho:listaArqTrecho) {
            String origem = trecho.substring(0,2).trim();
            String destino = trecho.substring(3,5).trim();
            Integer custo = Integer.parseInt(trecho.substring(6,trecho.length()).trim());
            String id = trecho.substring(0,5).trim();
            arestasAtual.add(new Aresta(origem, destino, custo, id));
        }

        for (String cidadeEncomenda: listaEncomendas) {

            String primeiraCidade = cidadeEncomenda.substring(0,2).trim();
            String ultimaCidade = cidadeEncomenda.substring(3,5).trim();
            ListIterator<Aresta> itOrigem = arestasAtual.listIterator();
            ListIterator<Aresta> itDestino = arestasAtual.listIterator();


            List<String> teste = new ArrayList<String>();
            List<String> testeD = new ArrayList<String>();

            while (itOrigem.hasNext()) {
                Aresta obj = itOrigem.next();
                if (obj.getOrigem().equals(primeiraCidade)) {
                    teste.add(obj.getDestino());
                }
            }
            while (itDestino.hasNext()) {
                Aresta obj2 = itDestino.next();
                if (obj2.getDestino().equals(ultimaCidade)) {
                    testeD.add(obj2.getOrigem());
                }
            }
            String concat = null;
            List<String> novaLista = new ArrayList<String>();
            String valorRepetido = null;
            for (int i = 0; i < teste.size(); i++) {
                String string = teste.get(i);
                String string2 = null;
                for (int j = 0; j < testeD.size(); j++) {
                    string2 = testeD.get(j);
                    concat = string + " " + string2;
                }
                if (string.equals(string2)) {
                    valorRepetido = string;
                }
                novaLista.add(concat);
            }
            String trecho = null;
            String rotaFinal = null;
            String rotaIni = null;
            String rotaFim = null;
            int custo = 0;
            int menorCusto = 0;
            int calcFinal = 0;
            for (int i = 0; i < novaLista.size(); i++) {
                String concatLista = novaLista.get(i);
                for (int j = 0; j < arestasAtual.size(); j++) {
                    String idTrecho = arestasAtual.get(j).getId();
                    custo = arestasAtual.get(j).getCusto();
                    if (concatLista.equals(idTrecho)) {
                        if(valorRepetido != null) {
                            trecho = valorRepetido;
                            menorCusto = 1;
                            rotaIni = primeiraCidade +" "+ valorRepetido.trim();
                            rotaFim = valorRepetido +" "+ ultimaCidade;
                            for (int k = 0; k < arestasAtual.size(); k++) {
                                String idTrechoRep = arestasAtual.get(k).getId();
                                if(idTrechoRep.equals(rotaIni)|| idTrechoRep.equals(rotaFim)) {
                                    calcFinal += arestasAtual.get(k).getCusto();
                                }
                            }
                            rotaFinal = primeiraCidade +" "+ valorRepetido +" "+ ultimaCidade + " " + calcFinal;
                            rotaTexto = rotaFinal;
                        }else if (custo > menorCusto){
                            trecho = idTrecho;
                            rotaIni = primeiraCidade +" "+ trecho.substring(0, 2).trim();
                            rotaFim = trecho.substring(3, 5).trim() +" "+ ultimaCidade;
                            for (int L = 0; L < arestasAtual.size(); L++) {
                                String idTrechoRep = arestasAtual.get(L).getId();
                                menorCusto = arestasAtual.get(L).getCusto();
                                if(idTrechoRep.equals(rotaIni)|| idTrechoRep.equals(rotaFim) || idTrechoRep.equals(trecho)) {
                                    calcFinal += arestasAtual.get(L).getCusto();

                                }
                            }
                            rotaFinal = rotaIni + " " + rotaFim + " " + calcFinal;
                            rotaTexto = rotaFinal;
                            System.out.println(rotaFinal);
                        }
                    }
                }
            }
        }

        arquivo.lerArquivo(pathName, arquivoEncomenda);
        arquivo.gerarArquivo(pathName, arquivoRota);
        arquivo.escreverArquivo(pathName, arquivoRota, rotaTexto);

    }
}


