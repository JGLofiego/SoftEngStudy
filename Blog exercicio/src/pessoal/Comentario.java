package pessoal;
import java.util.Calendar;

public class Comentario extends Conteudo {
    Nota nota;

    public Comentario(String texto, Usuario autor, Nota nota){
        this.texto = texto;
        this.data_criacao = Calendar.getInstance();
        this.autor = autor;
    }
}
