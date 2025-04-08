
import java.util.ArrayList;
import java.util.List;

public class SistemaBlog {
	private List<Blog> blogs = new ArrayList<Blog>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public List<String> obterTextosNotas(int idBlog) {
		Blog blog = this.buscarBlogPorId(idBlog);
		
		List<String> textos = blog.obterListaTextosNotas();
		
		return textos;
	}
	
	private Blog buscarBlogPorId(int idBlog) {
		for (Blog blog: blogs) {
			if(idBlog == blog.getIdBlog()) 
				return blog;
		}
		return null;
	}
}
