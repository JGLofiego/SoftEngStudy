package criarNota;
import java.util.ArrayList;
import java.util.List;

public class SistemaBlog {
	private List<Blog> blogs;
	private List<Usuario> usuarios;
	
	public void criarComentario(String texto, String dataCriacao, int idBlog, int idNota, Usuario autor) {
		Blog blog = this.buscarBlogPorId(idBlog);
		blog.criarComentarioNota(texto, dataCriacao, autor, idNota);
		
	}
	
	
	
	
	public List<String> mostrarTextoNotas(int idBlog) {
		Blog blog = this.buscarBlogPorId(idBlog);
		List<String> textosNotas = blog.obterTextosNotas();
		
		return textosNotas;
	}
	
	public void criarBlog(String titulo, String dataCriacao, Usuario dono) {
		Blog novoBlog = new Blog(titulo, dataCriacao, dono);
		this.blogs.add(novoBlog);
	}
	
	public void criarNota(String texto, String dataCriacao, int idBlog) {
		Blog blog = this.buscarBlogPorId(idBlog); 
		blog.criarNovaNota(texto, dataCriacao);
		
		// O c�digo comentado abaixo viola os padr�es Creator e Baixo Acoplamento
		//Nota novaNota = new Nota(texto, dataCriacao);
		//blog.inserirNota(novaNota);
	}
	
	private Blog buscarBlogPorId(int idBlog) {
		for (Blog blog: blogs) {
			if(idBlog == blog.getIdBlog()) 
				return blog;
		}
		return null;
	}
}
