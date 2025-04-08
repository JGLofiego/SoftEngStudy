import java.util.ArrayList;

public class GerenciadorObservadores {
    private ArrayList<Observador> observadores;

    public GerenciadorObservadores(){
        this.observadores = new ArrayList<>();
    }

    public void adicionarObservador(Observador observador){
        this.observadores.add(observador);
    }

    public void notificarObservadores(Livro livro, int numReservas){
        String mensagem = String.format("NOTIFICACAO: %s está com %s reservas", livro.getTitulo(), numReservas);

        for(Observador o : this.observadores){
            o.notificar(mensagem);
        }
    }
}
