import java.util.ArrayList;

public class ConsultarNotificacoesComando implements Comando {
	public void executar(CarregadorParametros carregadorParametros) {
		Biblioteca biblioteca = Biblioteca.obterInstancia();
		
		Observador usuario = (Observador) biblioteca.obterUsuarioPorId(carregadorParametros.getParametroUm());

		if(usuario == null){
			GerenciadorSaidaErro.TratamentoNullUsuario();
			return;
		}
		
		ArrayList<String> notificacoes = usuario.getNotificacoes();

		GerenciadorSaida.printarNotificacoes(notificacoes);

	}

}
