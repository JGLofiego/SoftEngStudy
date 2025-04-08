package criarNota;

public class Comentario {

	private String texto;
	private String dataCriacao;
	private Usuario autor;
	
	public Comentario(String texto, String dataCriacao, Usuario autor) {
		this.texto = texto;
		this.dataCriacao = dataCriacao;
		this.autor = autor;
	}
}
