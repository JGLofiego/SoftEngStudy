import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private static Biblioteca instancia;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Livro> livros = new ArrayList<Livro>();
	private GerenciadorEmprestimos emprestimos = new GerenciadorEmprestimos();
	private GerenciadorReservas reservas = new GerenciadorReservas();
	
	private Biblioteca() {
		this.usuarios.add(new UsuarioGraduacao("123", "João da Silva"));
		this.usuarios.add(new UsuarioPosGraduacao("456", "Luiz Fernando Rodrigues"));
		this.usuarios.add(new UsuarioGraduacao("789", "Pedro Paulo"));
		this.usuarios.add(new UsuarioProfessor("100", "Carlos Lucena"));

		this.livros.add(new Livro("100", "Engenharia de Software", "Addison Wesley",
		new String[]{"Ian Sommervile"}, "6", 2000));
		this.livros.add(new Livro("101", "UML - Guia do Usuário", "Campus",
		new String[]{"Grady Booch", "James Rumbaugh", "Ivar Jacobson"}, "7", 2000));
		this.livros.add(new Livro("200", "Code Complete", "Microsoft Press",
		new String[]{"Steve McConnell"}, "2", 2014));
		this.livros.add(new Livro("201", "Agile Software Develpoment, Principles, Patterns and Practices", "Prentice Hall",
		new String[]{"Robert Martin"}, "1", 2002));
		this.livros.add(new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional",
		new String[]{"Martin Fowler"}, "1", 1999));
		this.livros.add(new Livro("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press",
		new String[]{"Norman Fenton", "James Bieman"}, "3", 2014));
		this.livros.add(new Livro("400", "Design Patterns: Element of Reusable Object-Oriented Software", "Addison Wesley Professional",
		new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, "1", 1994));
		this.livros.add(new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional",
		new String[]{"Martin Fowler"}, "3", 2003));

		this.livros.get(0).adicionarExemplar("01", true);
		this.livros.get(0).adicionarExemplar("02", true);
		this.livros.get(1).adicionarExemplar("03", true);
		this.livros.get(2).adicionarExemplar("04", true);
		this.livros.get(3).adicionarExemplar("05", true);
		this.livros.get(4).adicionarExemplar("06", true);
		this.livros.get(4).adicionarExemplar("07", true);
		this.livros.get(5).adicionarExemplar("08", true);
		this.livros.get(5).adicionarExemplar("09", true);
	};
	
	public static Biblioteca obterInstancia() {
		if (instancia == null)
			instancia = new Biblioteca();
		return instancia;
	}

	public static GerenciadorEmprestimos obterEmprestimos(){
		Biblioteca biblioteca = Biblioteca.obterInstancia();

		return biblioteca.emprestimos;
	}

	public static GerenciadorReservas obterReservas(){
		Biblioteca biblioteca = Biblioteca.obterInstancia();

		return biblioteca.reservas;
	}
	
	public Usuario obterUsuarioPorId(String id) {
		for(Usuario usuario : this.usuarios){
			if(usuario.getId().equals(id)){
				return usuario;
			}
		}
		return null;
	}
	
	public Livro obterLivroPorId(String id) {
		for(Livro livro : this.livros){
			if(livro.getId().equals(id)){
				return livro;
			}
		}
		return null;
	}

	public void criarEmprestimo(Usuario usuario, Livro livro){
		this.emprestimos.adicionarEmprestimo(usuario, livro);
	}

	public void removerEmprestimo(Emprestimo emprestimo){
		this.emprestimos.devolverEmprestimo(emprestimo);
	}

	public void adicionarReserva(Reserva reserva){
		this.reservas.adicionarReserva(reserva);
	}

	public void removerReserva(Reserva reserva){
		this.reservas.removerReserva(reserva);
	}

}
