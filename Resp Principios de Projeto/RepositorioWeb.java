
public class RepositorioWeb implements IMecanismoRegistro {
	public void save(int ano, int mes, double valor) {
		System.out.println("Simulando o registro em repositório Web: " + ano + "/" + mes + " " + valor);
	}

}
