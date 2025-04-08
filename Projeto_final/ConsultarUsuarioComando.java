import java.util.ArrayList;

public class ConsultarUsuarioComando implements Comando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
				
		Usuario usuario = biblioteca.obterUsuarioPorId(carregadorParametros.getParametroUm());

		if (usuario == null) {
			GerenciadorSaidaErro.TratamentoNullUsuario();
			return;
		}

		GerenciadorEmprestimos emprestimos = Biblioteca.obterEmprestimos();
		GerenciadorReservas reservas = Biblioteca.obterReservas();

		ArrayList<Emprestimo> emprestimosUsuario = emprestimos.getEmprestimosUsuario(usuario);
        ArrayList<Reserva> reservasUsuario = reservas.getReservaUsuario(usuario);

		GerenciadorSaida.printarUsuario(usuario, emprestimosUsuario, reservasUsuario);
	}

}
