
public class GerenciadorSaidaErro {

    public static void TratamentoNullLivro(){
        System.out.println("Erro: O livro passado não existe.");
    }

    public static void TratamentoNullUsuario(){
        System.out.println("Erro: O usuario passado não existe.");
    }

    public static void TratamentoNullEmprestimo(){
        System.out.println("Erro: O emprestimo passado não existe.");
    }

    public static void TratamentoNullComando(){
        System.out.println("Erro: Digite um comando.");
    }

    public static void TratamentoEmprestimoNaoPermitido(Livro livro, Usuario usuario, EmprestimoStrategy estrategia, GerenciadorEmprestimos emprestimos, GerenciadorReservas reservas){
        if (!livro.temExemplarDisponivel()) {
            System.out.println("Erro: O emprestimo não foi permitido, o livro não possui exemplar disponível.");
            return;
        }else if(emprestimos.isDevedor(usuario)){
            System.out.println("Erro: O emprestimo não foi permitido, o usuário é devedor, portanto não pode realizar empréstimos.");
            return;
        }else if(emprestimos.numEmprestimosAtivos(usuario) >= estrategia.getMaximoEmprestimos()){
            System.out.println("Erro: O emprestimo não foi permitido, o usuário já atingiu o limite de empréstimos.");
            return;
        }else if(!livro.temExemplarSemReserva(reservas.getReservaLivro(livro)) && !reservas.temReserva(usuario, livro)){
            System.out.println("Erro: O emprestimo não foi permitido, o livro não possui exemplar disponível e o usuário não possui reserva.");
            return;
        }else if(emprestimos.existeEmprestimo(usuario, livro)){
            System.out.println("Erro: O emprestimo não foi permitido, o usuário já possui um empréstimo deste livro.");
            return;
        }
    }

    public static void TratamentoReservaNaoPermitida(){
        System.out.println("Erro: A reserva não foi permitida, o usuário já possui 3 reservas.");
    }

}
