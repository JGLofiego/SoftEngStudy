import java.util.ArrayList;

public class EmprestimoPosGraduacao implements EmprestimoStrategy {
    public boolean podeEmprestar(Usuario usuario, Livro livro){
        GerenciadorEmprestimos emprestimos = Biblioteca.obterEmprestimos();
        GerenciadorReservas reservas = Biblioteca.obterReservas();

        ArrayList<Reserva> reservasUsuario = reservas.getReservaLivro(livro);

        if(!livro.temExemplarDisponivel()){
            return false;
        }

        if(emprestimos.isDevedor(usuario)){
            return false;
        }

        if(emprestimos.numEmprestimosAtivos(usuario) >= getMaximoEmprestimos()){
            return false;
        }
        
        if(!livro.temExemplarSemReserva(reservasUsuario) && !reservas.temReserva(usuario, livro)){
            return false;
        }

        if(emprestimos.existeEmprestimo(usuario, livro)){
            return false;
        }

        return true;
    }

    public int getMaximoEmprestimos() {
        return 3;
    }

    public int getPrazoDias(){
        return 5;
    }
}
