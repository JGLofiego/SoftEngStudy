
public class Fabrica {
	public static IMecanismoLog obterMecanismoLog() {
		return new MecanismoLogBancoDados();
	}
	
	public static IMecanismoMensagem obterMecanismoMensagem() {
		return new MecanismoSMS();
	}

}
