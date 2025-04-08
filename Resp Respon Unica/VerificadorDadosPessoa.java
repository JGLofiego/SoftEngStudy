public class VerificadorDadosPessoa {
	public static boolean verificaDadosPessoa(Pessoa pessoa) {
		if (pessoa.getPrimeiroNome().isEmpty()) {
			GerenciadorMensagens.mostrarMensagemDadoInvalido("primeiro nome");
			return false;
		}
		
		if (pessoa.getUltimoNome().isEmpty()) {
			GerenciadorMensagens.mostrarMensagemDadoInvalido("�ltimo nome");
			return false;
		}
		
		return true;
	}
	
}
