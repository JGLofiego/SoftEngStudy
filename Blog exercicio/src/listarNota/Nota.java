
import java.util.ArrayList;
import java.util.List;

public class Nota {
	private String texto;
	private String dataCriacao;
	private List<Comentario> comentarios = new ArrayList<Comentario>();

	public Nota(String texto) {
		this.texto = texto;
	}

	public String getTexto() {	
		return texto;
	}
}
