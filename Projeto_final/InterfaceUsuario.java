import java.util.HashMap;

public class InterfaceUsuario {
	private HashMap<String,Comando> comandos = new HashMap<String,Comando>();

	public InterfaceUsuario(){
		this.inicializarComandos();
	}
	
	private void inicializarComandos() {
		comandos.put("emp", new EmprestarComando());
		comandos.put("usu", new ConsultarUsuarioComando());
		comandos.put("dev", new DevolucaoComando());
		comandos.put("res", new ReservaComando());
		comandos.put("obs", new ObservacaoLivrosComando());
		comandos.put("liv", new ConsultarLivroComando());
		comandos.put("ntf", new ConsultarNotificacoesComando());
		comandos.put("sai", new SairComando());
	}
	
	public void executarComando(String strComando, CarregadorParametros parametros) {
		Comando comando = comandos.get(strComando);
		if(comando == null){
			GerenciadorSaidaErro.TratamentoNullComando();
			return;
		}
		comando.executar(parametros);
	}

}
