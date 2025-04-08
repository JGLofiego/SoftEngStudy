import java.util.ArrayList;

public class GerenciadorReservas {
    private ArrayList<Reserva> reservas;

    public GerenciadorReservas(){
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva r){
        this.reservas.add(r);
    }

    public void removerReserva(Reserva r){
        this.reservas.removeIf(reserva -> reserva.equals(r));
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public int reservasAtivas(){
        return this.reservas.size();
    }

    public boolean temReserva(Livro livro) {
        for(Reserva r : this.reservas){
            if(r.getLivro().equals(livro)){
                return true;
            }
        }
        return false;
    }

    public Reserva getReserva(Livro livro){
        for(Reserva r : this.reservas){
            if(r.getLivro().equals(livro)){
                return r;
            }
        }
        return null;
    }

    public ArrayList<Reserva> getReservaUsuario(Usuario usuario){
        ArrayList<Reserva> reservasUsuario = new ArrayList<>();

        for(Reserva r : this.reservas){
            if(r.getUsuario().equals(usuario)){
                reservasUsuario.add(r);
            }
        }

        return reservasUsuario;
    }

    public ArrayList<Reserva> getReservaLivro(Livro livro){
        ArrayList<Reserva> reservasLivro = new ArrayList<>();

        for(Reserva r : this.reservas){
            if(r.getLivro().equals(livro)){
                reservasLivro.add(r);
            }
        }

        return reservasLivro;
    }

    public boolean temReserva(Usuario usuario, Livro livro){
        for(Reserva r : this.reservas){
            if(r.getUsuario().equals(usuario) && r.getLivro().equals(livro)){
                return true;
            }
        }

        return false;
    }

    public Reserva encontrarReserva(Usuario usuario, Livro livro){
        for(Reserva r : this.reservas){
            if(r.getUsuario().equals(usuario) && r.getLivro().equals(livro)){
                return r;
            }
        }
        return null;
	}
}
