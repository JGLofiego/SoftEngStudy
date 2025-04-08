import java.util.ArrayList;

public interface Observador {
    public void notificar(String mensagem);
    public int getTotalNotificacoes();
    public ArrayList<String> getNotificacoes();
}
