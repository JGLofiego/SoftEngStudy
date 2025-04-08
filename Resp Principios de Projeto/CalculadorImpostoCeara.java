
public class CalculadorImpostoCeara implements ICalculadorImposto {

	@Override
	public double calcularImpostoVenda(Venda venda) {
		double imposto;
		if (venda.getValor() < 1500)
			imposto = 0.05 * venda.getValor();
		else
			imposto = 0.07 * venda.getValor();
		
		return imposto;
	}

}
