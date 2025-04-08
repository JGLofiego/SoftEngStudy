

public class EmprestarComando implements Comando {
	public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
		
		Usuario usuario = biblioteca.obterUsuarioPorId(carregadorParametros.getParametroUm());
		GerenciadorEmprestimos emprestimos = Biblioteca.obterEmprestimos();

		if(usuario == null){
			GerenciadorSaidaErro.TratamentoNullUsuario();
			return;
		}
		
		Livro livro = biblioteca.obterLivroPorId(carregadorParametros.getParametroDois());

		if(livro == null){
			GerenciadorSaidaErro.TratamentoNullLivro();
			return;
		}

		GerenciadorReservas reservas = Biblioteca.obterReservas();
		
		EmprestimoStrategy estrategia = usuario.obterEstrategia();
		if(usuario.podeEmprestar(livro, estrategia)){
			biblioteca.criarEmprestimo(usuario, livro);
			GerenciadorSaida.printarEmprestimo(livro.getTitulo(), usuario.getNome());

			Reserva r = reservas.encontrarReserva(usuario, livro);

			if(r != null){				
				reservas.removerReserva(r);
				GerenciadorSaida.printarReservaRemovida(livro.getTitulo(), usuario.getNome());
			}
		}else{
			GerenciadorSaidaErro.TratamentoEmprestimoNaoPermitido(livro, usuario, estrategia, emprestimos, reservas);
		}
	}

}
