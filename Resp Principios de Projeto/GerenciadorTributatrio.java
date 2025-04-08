import java.util.List;

public class GerenciadorTributatrio {

	public void registraTotalImpostoMes(int ano, int mes, List<Venda> vendasMes) {
		
		//ICalculadorImposto calculador = Fabrica.obterCalculadorImposto();
		double imposto = 0;
		for (Venda venda : vendasMes)
		{	
			imposto += venda.calcularImposto();
		}
		
		//registra valor do imposto total
		IMecanismoRegistro mecanismoRegistro = Fabrica.obterMecanismoRegistro();
		mecanismoRegistro.save(ano, mes, imposto);
		
	}

}
