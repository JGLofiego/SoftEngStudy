

public class DevolucaoComando implements Comando {

	public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
		
		Usuario usuario = biblioteca.obterUsuarioPorId(carregadorParametros.getParametroUm());

		if(usuario == null){
			GerenciadorSaidaErro.TratamentoNullUsuario();
			return;
		}
		
		Livro livro = biblioteca.obterLivroPorId(carregadorParametros.getParametroDois());

		if(livro == null){
			GerenciadorSaidaErro.TratamentoNullLivro();
			return;
		}

		GerenciadorEmprestimos emprestimos = Biblioteca.obterEmprestimos();

		Emprestimo emprestimo = emprestimos.obterEmprestimo(usuario, livro);

		if(emprestimo == null){
			GerenciadorSaidaErro.TratamentoNullEmprestimo();
			return;
		}

		biblioteca.removerEmprestimo(emprestimo);
		GerenciadorSaida.printarDevolucao(livro.getTitulo(), usuario.getNome());
	}

}
