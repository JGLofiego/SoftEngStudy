package criarNota;
import java.util.ArrayList;
import java.util.List;

public class Blog {
	private int idBlog;
	private String titulo;
	private String dataCriacao;
	private List<Nota> notas;
	private Usuario dono;
	
	public Blog(String titulo, String dataCriacao, Usuario dono) {
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.dono = dono;
	}
	
	public List<String> obterTextosNotas() {
		List<String> textosNotas = new ArrayList<String>();
		for (Nota nota: notas) {
			textosNotas.add(nota.getTexto());
		}
		
		return textosNotas;
	}
	
	public int getIdBlog() {
		return idBlog;
	}
	
	public void inserirNota(Nota novaNota) {
		this.notas.add(novaNota);
	}

	public void criarNovaNota(String texto, String dataCriacao2) {
		Nota novaNota = new Nota(texto, dataCriacao);
		this.inserirNota(novaNota);
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void criarComentarioNota(String texto, String dataCriacao, Usuario autor, int idNota) {
		Nota nota = this.buscarNotaPorId(idNota);
		nota.criarComentario(texto, dataCriacao, autor);
		
	}
	
	public Nota buscarNotaPorId(int idNota) {
		//Loop de buscar a nota pelo id
		Nota nota = null;
		return nota;
	}
}
