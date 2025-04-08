import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Seja bem-vinda ou bem-vindo.");
		
		// Obt�m dados da pessoa
		Pessoa usuario = new Pessoa();
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Qual � seu primeiro nome?");
		usuario.setPrimeiroNome(teclado.readLine());
		
		System.out.println("Qual � seu �ltimo nome?");
		usuario.setUltimoNome(teclado.readLine());

		
		// Verifica se os nomes s�o v�lidos
		if (usuario.getPrimeiroNome().isEmpty()) {
			System.out.println("Voc� n�o forneceu um primeiro nome v�lido");
			teclado.readLine();
			return;
		}
		
		if (usuario.getUltimoNome().isEmpty()) {
			System.out.println("Voc� n�o forneceu um �ltimo nome v�lido");
			teclado.readLine();
			return;
		}
		
		// Cria um id para o usu�rio
		System.out.println("Seu id de usu�rio � " + usuario.getPrimeiroNome().substring(0, 1) + usuario.getUltimoNome());
	
		teclado.readLine();
		
	}

}