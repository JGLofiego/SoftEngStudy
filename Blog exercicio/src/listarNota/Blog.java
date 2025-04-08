
import java.util.ArrayList;
import java.util.List;

public class Blog {
	private int idBlog;
	private String titulo;
	private String dataCriacao;
	private List<Nota> notas = new ArrayList<Nota>();
	private Usuario dono;
	
	public Blog(String titulo, Usuario dono) {
		this.titulo = titulo;
		this.dono = dono;
	}

	public int getIdBlog() {	
		return idBlog;
	}

	public List<String> obterListaTextosNotas() {
		List<String> textos = new ArrayList<String>();
		for (Nota nota: this.notas) {
			String texto = nota.getTexto();
			textos.add(texto);
		}

		return textos;
	}

}
