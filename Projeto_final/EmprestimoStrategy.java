public interface EmprestimoStrategy {
    boolean podeEmprestar(Usuario usuario, Livro livro);
    int getPrazoDias();
    int getMaximoEmprestimos();
}
