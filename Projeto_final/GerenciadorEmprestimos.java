import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorEmprestimos {
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Emprestimo> emprestimosFinalizados;


    public GerenciadorEmprestimos(){
        this.emprestimosAtivos = new ArrayList<>();
        this.emprestimosFinalizados = new ArrayList<>();
    }

    public void adicionarEmprestimo(Usuario usuario, Livro livro) {
        Exemplar exemplar = livro.getExemplarDisponivel();
		exemplar.setDisponibilidade(false);

		EmprestimoStrategy estrategia = usuario.obterEstrategia();
		Emprestimo e = new Emprestimo(usuario, exemplar, estrategia);

        this.emprestimosAtivos.add(e);  
    }

    public void devolverEmprestimo(Emprestimo emprestimo) {
        this.emprestimosAtivos.removeIf(e -> e.equals(emprestimo));
        
        Exemplar exemplar = emprestimo.getExemplar();
        
		exemplar.setDisponibilidade(true);
		emprestimo.setFinalizado();
        emprestimo.setDataDevolucao(LocalDate.now());

        this.emprestimosFinalizados.add(emprestimo);
    }

    public boolean existeEmprestimo(Usuario usuario, Livro livro) {
        for(Emprestimo e : this.emprestimosAtivos){
            if(e.getUsuario().equals(usuario) && e.getLivroDoExemplar().equals(livro)){
                return true;
            }
        }
        return false;
    }

    public Emprestimo obterEmprestimo(Usuario usuario, Livro livro){
		for(Emprestimo e : this.emprestimosAtivos){
			if(e.getUsuario().equals(usuario) && e.getLivroDoExemplar().equals(livro)){
				return e;
			}
		}
		return null;
	}

    public ArrayList<Emprestimo> getEmprestimosUsuario(Usuario usuario){
        ArrayList<Emprestimo> emprestimosUsuario = new ArrayList<>();

        for(Emprestimo e : this.emprestimosAtivos){
            if(e.getUsuario().equals(usuario)){
                emprestimosUsuario.add(e);
            }
        }

        for(Emprestimo e : this.emprestimosFinalizados){
            if(e.getUsuario().equals(usuario)){
                emprestimosUsuario.add(e);
            }
        }

        return emprestimosUsuario;
    }

    public ArrayList<Emprestimo> getEmprestimosAtivosUsuario(Usuario usuario){
        ArrayList<Emprestimo> emprestimosUsuario = new ArrayList<>();

        for(Emprestimo e : this.emprestimosAtivos){
            if(e.getUsuario().equals(usuario)){
                emprestimosUsuario.add(e);
            }
        }

        return emprestimosUsuario;
    }

    public int numEmprestimosAtivos(Usuario usuario){
        return this.getEmprestimosAtivosUsuario(usuario).size();
    }

    public boolean isDevedor(Usuario usuario){
        ArrayList<Emprestimo> listaEmprestimos = this.getEmprestimosUsuario(usuario);

        for(Emprestimo e : listaEmprestimos){
            if(e.estaAtrasado()){
                return true;
            }
        }
        return false;
    }

    public Emprestimo encontraEmprestimoPeloExemplar(Exemplar exemplar){
		for(Emprestimo e : this.emprestimosAtivos){
			if(e.getExemplar().equals(exemplar)){
				return e;
			}
		}
		return null;
	}
}
