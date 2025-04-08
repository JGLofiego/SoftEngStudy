
public class Fabrica {
	public static IItemBiblioteca obterItem() {
		return new LivroConsulta();
	}
	
	public static IEmprestavel obterItemEmprestavel() {
		return new Filme();
	}
	
	public static ILivro obterLivro() {
		return new Livro();
	}
}
