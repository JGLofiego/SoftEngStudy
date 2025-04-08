import java.util.ArrayList;

public class ReservaComando implements Comando {
    public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
		
		Usuario usuario = biblioteca.obterUsuarioPorId(carregadorParametros.getParametroUm());
		
		Livro livro = biblioteca.obterLivroPorId(carregadorParametros.getParametroDois());

		if(usuario == null){
			GerenciadorSaidaErro.TratamentoNullUsuario();
			return;
		}

		if(livro == null){
			GerenciadorSaidaErro.TratamentoNullLivro();
			return;
		}

		GerenciadorReservas reservas = Biblioteca.obterReservas();

		ArrayList<Reserva> reservasUsuario = reservas.getReservaUsuario(usuario);
		
		if(VerificadorReservas.usuarioPodeReservar(usuario, reservasUsuario)){
			Reserva reserva = new Reserva(usuario, livro);

			biblioteca.adicionarReserva(reserva);
			GerenciadorSaida.printarReservaSucesso(livro.getTitulo(), usuario.getNome());

			if(VerificadorReservas.precisaNotificar(reservas.getReservaLivro(livro).size())){
				GerenciadorObservadores observadores = livro.getObservadores();
				

				observadores.notificarObservadores(livro, reservas.getReservaLivro(livro).size());
			}
		}else{
			GerenciadorSaidaErro.TratamentoReservaNaoPermitida();
		}
	}
}
