import java.util.ArrayList;

public class UsuarioProfessor implements Usuario, Observador {
    private String id;
    private String nome;
    private int totalNotificacoes;
    private ArrayList<String> notificacoes;

    public UsuarioProfessor(String id, String nome){
        this.id = id;
        this.nome = nome;
        this.notificacoes = new ArrayList<>();
    }

    public String getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean podeEmprestar(Livro livro, EmprestimoStrategy estrategia){
        return estrategia.podeEmprestar(this, livro);
    }

    public EmprestimoStrategy obterEstrategia() {
        return new EmprestimoProfessor();
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }

    public ArrayList<String> getNotificacoes() {
        return notificacoes;
    }

    public void notificar(String mensagem) {
        this.totalNotificacoes++;

        this.notificacoes.add(mensagem);
    }

}
