package criarNota;
import java.util.List;

public class Nota {
	private int idNota;
	private String texto;
	private String dataCriacao;
	private List<Comentario> comentarios;
	
	public Nota(String texto, String dataCriacao) {
		this.texto = texto;
		this.dataCriacao = dataCriacao;
	}

	public String getTexto() {
		return this.texto;
	}

	public void criarComentario(String texto, String dataCriacao, Usuario autor) {
		Comentario novoComentario = new Comentario(texto, dataCriacao, autor);
		this.insereNovoComentario(novoComentario);
	}
	
	private void insereNovoComentario(Comentario novoComentario) {
		comentarios.add(novoComentario);
	}
}
