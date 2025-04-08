import java.util.ArrayList;

public class ConsultarLivroComando implements Comando {
	public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
		
		Livro livro = biblioteca.obterLivroPorId(carregadorParametros.getParametroUm());

		if(livro == null){
			GerenciadorSaidaErro.TratamentoNullLivro();
			return;
		}

		GerenciadorReservas reservas = Biblioteca.obterReservas();
		GerenciadorExemplares exemplares = livro.getExemplares();

		ArrayList<Reserva> reservasLivro = reservas.getReservaLivro(livro);
		ArrayList<Exemplar> exemplaresLivro = exemplares.getExemplares();
		
		GerenciadorSaida.printarLivro(livro, exemplaresLivro, reservasLivro);
	}

}
