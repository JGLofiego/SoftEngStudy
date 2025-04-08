import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GerenciadorMensagens {
	public static void mostrarMensagemBoasVindas() {
		System.out.println("Seja bem-vinda ou bem-vindo.");
	}
	
	public static void mostrarMensagemFimPrograma() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Digite enter para sair do programa...");
		teclado.readLine();
	}
	
	public static void mostrarMensagemDadoInvalido(String nomeCampo) {
		System.out.println("Voc� n�o forneceu um " + nomeCampo + " v�lido");
	}

}
