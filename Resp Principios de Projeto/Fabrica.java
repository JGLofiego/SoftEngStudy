
public class Fabrica {
	public static IMecanismoRegistro obterMecanismoRegistro() {
		return new RepositorioWeb();
	}
	
	public static ICalculadorImposto obterCalculadorImposto() {
		return new CalculadorImpostoCeara();
	}
}
