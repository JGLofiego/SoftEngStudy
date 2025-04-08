
public class ObservacaoLivrosComando implements Comando {
	public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
		
		Observador observador = (Observador) biblioteca.obterUsuarioPorId(carregadorParametros.getParametroUm());

		if(observador == null){
			GerenciadorSaidaErro.TratamentoNullUsuario();
			return;
		}
		
		Livro livro = biblioteca.obterLivroPorId(carregadorParametros.getParametroDois());

		if(livro == null){
			GerenciadorSaidaErro.TratamentoNullLivro();
			return;
		}

		GerenciadorObservadores observadores = livro.getObservadores();

		observadores.adicionarObservador(observador);
		GerenciadorSaida.printarObservadorAdicionado(livro.getTitulo());
	}

}
