public class Exemplar {
    private String id;
    private boolean disponivel;
    private Livro livro;

    public Exemplar(String id, boolean disponivel, Livro livro){
        this.id = id;
        this.disponivel = disponivel;
        this.livro = livro;
    }

    public String getId() {
        return id;
    }

    public boolean estaDisponivel(){
        return this.disponivel;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setDisponibilidade(boolean disponivel){
        this.disponivel = disponivel;
    }
}
