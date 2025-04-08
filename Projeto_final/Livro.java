import java.util.ArrayList;

public class Livro {
    private String id;
    private String titulo;
    private String editora;
    private String[] autores;
    private String edicao;
    private int ano_publicacao;
    private GerenciadorExemplares exemplares;
    private GerenciadorObservadores observadores;

    public Livro(String id, String titulo, String editora, String[] autores, String edicao, int ano_publicacao){
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.ano_publicacao = ano_publicacao;
        this.exemplares = new GerenciadorExemplares();
        this.observadores = new GerenciadorObservadores();
    }

    public String getId() { return this.id; }
    public String getTitulo() { return this.titulo; }
    public String getEditora() { return this.editora; }
    public String[] getAutores() { return this.autores; }
    public String getEdicao() { return this.edicao; }
    public int getAnoPublicacao() { return this.ano_publicacao; }
    public GerenciadorExemplares getExemplares() {return this.exemplares; }
    public GerenciadorObservadores getObservadores() { return this.observadores; }

    public boolean temExemplarDisponivel(){
        return this.exemplares.temExemplarDisponivel();
    }

    public boolean temExemplarSemReserva(ArrayList<Reserva> reservas){
        return this.exemplares.exemplaresDisponiveis() > reservas.size();
    }

    public Exemplar getExemplarDisponivel(){
        return this.exemplares.getExemplarDisponivel();
    }

    public void  adicionarExemplar(String id, boolean status){
        this.exemplares.adicionarExemplar(id, status, this);
    }

}
