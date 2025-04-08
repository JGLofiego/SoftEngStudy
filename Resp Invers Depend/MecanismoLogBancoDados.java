
public class MecanismoLogBancoDados implements IMecanismoLog {

	@Override
	public void log(String mensagem) {
		System.out.println("Registrado no banco de dados: " + mensagem);
		
	}

}
