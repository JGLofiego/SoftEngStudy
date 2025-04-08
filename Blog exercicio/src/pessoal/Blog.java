package pessoal;
import java.util.ArrayList;
import java.util.Calendar;

public class Blog {
    String titulo;
    Usuario autor;
    Calendar data_criacao;
    ArrayList<Conteudo> conteudos;

    public Blog(String titulo, Usuario autor){
        this.titulo = titulo;
        this.data_criacao = Calendar.getInstance();
        this.autor = autor;
        this.conteudos = new ArrayList<Conteudo>();
    }

    public boolean criarNota(String texto, Usuario usuario){
        if(!usuario.equals(this.autor)){
            return false;
        }

        this.conteudos.add(new Nota(texto, usuario));

        return true;
    }
}
