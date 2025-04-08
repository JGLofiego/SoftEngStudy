public class UsuarioGraduacao implements Usuario {
    private String id;
    private String nome;

    public UsuarioGraduacao(String id, String nome){
        this.id = id;
        this.nome = nome;
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
        return new EmprestimoGraduacao();
    }
    
}
