public interface Usuario {
    
    public String getId();
    public String getNome();
    public boolean podeEmprestar(Livro livro, EmprestimoStrategy estrategia);
    public EmprestimoStrategy obterEstrategia();
}
