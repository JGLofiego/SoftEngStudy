
public class MecanismoEmail implements IMecanismoMensagem {

	public void enviarMensagem(Funcionario funcionario, String mensagem){
		System.out.println("Simulando o envio de email para " + funcionario.getNome());
	}
}
