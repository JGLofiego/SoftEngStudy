
public class Venda {
	private String data;
	private double valor;
	private ICalculadorImposto calculador;
	
	public Venda(String data, double valor) {
		this.data = data;
		this.valor = valor;
		this.calculador = Fabrica.obterCalculadorImposto();
	}
	
	public String getData() {
		return data;
	}
	
	public double getValor() {
		return valor;
	}
	
	public double calcularImposto() {
		return this.calculador.calcularImpostoVenda(this);
	}
}
