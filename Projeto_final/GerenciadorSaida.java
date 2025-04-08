import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorSaida {

    private static void printarReservaUsuario(Reserva r){
        System.out.println(String.format("Reserva de %s | Data: %s", r.getUsuario().getNome(), r.getDataReserva()));
    }

    private static void printarEmprestimo(Emprestimo e){

        String status, label;
        LocalDate date;

        if(e.estaEmAndamento()){
            status = "EM CURSO";
            label = "Maxima";
            date = e.getDataMaximaDevolucao();
        } else {
            status = "FINALIZADO";
            label = "Devolucao";
            date = e.getDataDevolucao();
        }

        String template = "Emprestimo %s | %s | %s | Data %s: %s";

        Livro livro = e.getLivroDoExemplar();

        System.out.println(String.format(template, livro.getTitulo(), e.getDataEmprestimo(), status, label, date));
    }

    private static void printarReservaLivro(Reserva r){
        System.out.println(String.format("Reserva %s | Data: %s", r.getLivro().getTitulo(), r.getDataReserva()));
    }

    private static void printarExemplar(Exemplar exemplar, Emprestimo emprestimo){
        
        if(exemplar.estaDisponivel()){
            String template = "Exemplar %s | DISPONIVEL";
            System.out.println(String.format(template, exemplar.getId()));
        } else {
            String template = "Exemplar %s | EMPRESTADO | Usuario: %s | Data: %s | Data Prevista: ";
            System.out.println(String.format(template, exemplar.getId(), emprestimo.getUsuario().getNome(), emprestimo.getDataEmprestimo(), emprestimo.getDataMaximaDevolucao()));
        }
        
    }

    public static void printarUsuario(Usuario u, ArrayList<Emprestimo> emprestimos, ArrayList<Reserva> reservas){
        if(u == null){
            GerenciadorSaidaErro.TratamentoNullUsuario();
            return;
        }
        System.out.println("Informacoes do usuario:");
        System.out.println(String.format("Nome: %s", u.getNome()));
        System.out.println("Emprestimos: ");

        for(Emprestimo e : emprestimos){
            printarEmprestimo(e);
        }

        for(Reserva r : reservas){
            printarReservaLivro(r);
        }
    }

    public static void printarLivro(Livro livro, ArrayList<Exemplar> exemplares, ArrayList<Reserva> reservas){
        GerenciadorEmprestimos emprestimosBiblioteca = Biblioteca.obterEmprestimos();

        System.out.println("Informacoes do livro:");
        System.out.println(String.format("Titulo: %s", livro.getTitulo()));
        System.out.println(String.format("Numero de reservas: %d", reservas.size()));

        if(reservas.size() != 0){
            for(Reserva r : reservas){
                printarReservaUsuario(r);
            }
        }

        for(Exemplar e : exemplares){
            Emprestimo emprestimo = null;
            if(!e.estaDisponivel()){
                emprestimo = emprestimosBiblioteca.encontraEmprestimoPeloExemplar(e);
            }
            printarExemplar(e, emprestimo);
        }


    }

    public static void printarNotificacoes(ArrayList<String> notificacoes){
        if(notificacoes.isEmpty()){
            System.out.println("Sem notificacoes");
            return;
        }

        for(String n : notificacoes){
            System.out.println(n);
        }
    }

    public static void printarDevolucao(String titulo, String nome){
        System.out.println("Devolução do livro " + titulo + " do usuário " + nome + " realizada com sucesso!");
    }
    
    public static void printarEmprestimo(String titulo, String nome){
        System.out.println("Emprestimo do livro " + titulo + " para o usuário " + nome + " realizado com sucesso!");
    }

    public static void printarReservaRemovida(String titulo, String nome){
        System.out.println("Reserva do livro " + titulo + " para o usuário " + nome + " removida com sucesso!");
    }

    public static void printarReservaRealizada(String titulo, String nome){
        System.out.println("Reserva do livro " + titulo + " para o usuário " + nome + " realizada com sucesso!");
    }

    public static void printarObservadorAdicionado(String titulo){
        System.out.println("Observador adicionado ao livro " + titulo + " com sucesso!");
    }

    public static void printarReservaSucesso(String titulo, String nome){
        System.out.println("Reserva do livro " + titulo + " para o usuário " + nome + " realizada com sucesso!");
    }

}
