
public class MecanismoSMS implements IMecanismoMensagem {

	@Override
	public void enviarMensagem(Funcionario funcionario, String mensagem) {
		System.out.println("Simulando o envio de SMS para " + funcionario.getNome());

	}

}
