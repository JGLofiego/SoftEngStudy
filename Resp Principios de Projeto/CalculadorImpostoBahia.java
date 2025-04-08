
public class CalculadorImpostoBahia implements ICalculadorImposto {
	public double calcularImpostoVenda(Venda venda) {
		double imposto;
		if (venda.getValor() < 1000)
			imposto = 0.05 * venda.getValor();
		else
			imposto = 0.07 * venda.getValor();
		
		return imposto;
	}
}
