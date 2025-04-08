package pessoal;
import java.util.ArrayList;
import java.util.Calendar;

public class Nota extends Conteudo {
    ArrayList<Comentario> comentarios;

    public Nota(String texto, Usuario autor){
        this.texto = texto;
        this.data_criacao = Calendar.getInstance();
        this.autor = autor;
        this.comentarios = new ArrayList<Comentario>();
    }

    public boolean adicionarComentario(String texto, Usuario autor){
        comentarios.add(new Comentario(texto, autor, this));
        return true;
    }
}
