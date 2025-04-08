
public class Tarefa {
	
	private String nome;
	private Funcionario responsavel;
	private double horasTrabalhadas;
	private boolean completa = false;
	
    public void realizarTrabalho(double horas)
    {
        this.horasTrabalhadas += horas;
        IMecanismoLog log = Fabrica.obterMecanismoLog();
        log.log("Trabalho realizado em " + nome + ".");
    }

    public void completarTarefa()
    {
        completa = true;

        IMecanismoLog log = Fabrica.obterMecanismoLog();
        log.log("Tarefa " + nome + " completa.");

        IMecanismoMensagem mecanismoMensagem = Fabrica.obterMecanismoMensagem();
        mecanismoMensagem.enviarMensagem(responsavel, "A tarefa " + nome + " foi finalizada.");
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Funcionario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public boolean isCompleta() {
		return completa;
	}
	
	
}
