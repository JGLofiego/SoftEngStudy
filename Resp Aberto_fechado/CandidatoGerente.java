package modelo;

public class CandidatoGerente implements ICandidato {
	private String nome;
	private String sobrenome;
	
	public CandidatoGerente(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}	
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	@Override
	public ICriadorContas obterCriadorContas() {
		// TODO Auto-generated method stub
		return new CriadorContasGerente();
	}
}
