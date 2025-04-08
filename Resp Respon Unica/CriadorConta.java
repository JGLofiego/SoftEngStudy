public class CriadorConta {
	public static void criarId(Pessoa pessoa) {
		System.out.println("Seu id de usu�rio � " + pessoa.getPrimeiroNome().substring(0, 1) + pessoa.getUltimoNome());
	}
}
