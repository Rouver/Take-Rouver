public class Aresta {

    private Integer custo;
    private String  origem;
    private String  destino;
    private String  id;


    public Aresta(String origem, String destino, int custo, String id) {

        this.custo = custo;
        this.origem = origem;
        this.destino = destino;
        this.setId(id);

    }

    public Integer getCusto() {
        return custo;
    }



    public void setCusto(int custo) {
        this.custo = custo;
    }





    public String getOrigem() {
        return origem;
    }





    public void setOrigem(String origem) {
        this.origem = origem;
    }





    public String getDestino() {
        return destino;
    }





    public void setDestino(String destino) {
        this.destino = destino;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}