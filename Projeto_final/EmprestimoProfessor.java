public class EmprestimoProfessor implements EmprestimoStrategy {
    public boolean podeEmprestar(Usuario usuario, Livro livro){
        GerenciadorEmprestimos emprestimos = Biblioteca.obterEmprestimos();

        if(livro == null){
            GerenciadorSaidaErro.TratamentoNullLivro();
            return false;
        }

        if(!livro.temExemplarDisponivel()){
            return false;   
        }

        if(emprestimos.isDevedor(usuario)){
            return false;
        }

        return true;
    }

    public int getMaximoEmprestimos() {
        return Integer.MAX_VALUE;
    }

    public int getPrazoDias(){
        return 8;
    }
}
