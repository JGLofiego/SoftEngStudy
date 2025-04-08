import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColetorDadosPessoa {
	public static Pessoa obterDadosPessoa() throws IOException {
		Pessoa pessoa = new Pessoa();
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Qual � seu primeiro nome?");
		pessoa.setPrimeiroNome(teclado.readLine());
		
		System.out.println("Qual � seu �ltimo nome?");
		pessoa.setUltimoNome(teclado.readLine());
		
		return pessoa;
	}

}
