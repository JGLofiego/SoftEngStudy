import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		GerenciadorMensagens.mostrarMensagemBoasVindas();
		
		Pessoa usuario = ColetorDadosPessoa.obterDadosPessoa();

		if (VerificadorDadosPessoa.verificaDadosPessoa(usuario) == false) {		
			GerenciadorMensagens.mostrarMensagemFimPrograma();
			return;
		}
		
		CriadorConta.criarId(usuario);
		
		GerenciadorMensagens.mostrarMensagemFimPrograma();
		
	}

}