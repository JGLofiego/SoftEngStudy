package pessoal;
import java.util.ArrayList;

public class Usuario {
    public String email;
    public ArrayList<Blog> blogs;
    
    public Usuario(String email) {
        this.email = email;
        this.blogs = new ArrayList<Blog>();
    }

    public Blog criarBlog(String titulo){
        Blog blog = new Blog(titulo, this);
        this.blogs.add(blog);
        return blog;
    }

    public boolean removerConteudo(Conteudo conteudo){
        if(conteudo.autor.equals(this)){
            return true;
        }

        if(conteudo instanceof Comentario){
            if(((Comentario)conteudo).nota.autor == this){
                return true;
            }
        }

        return false;
    }
}
